package com.nt.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bo.ConsultationBO;
import com.nt.bo.ConsultationTrackerBO;
import com.nt.bo.DoctorsBO;
import com.nt.bo.PatientBO;
import com.nt.dao.ConsultationDAO;
import com.nt.dao.ConsultationTrackerDAO;
import com.nt.dao.DoctorsDAO;
import com.nt.dao.PatientDAO;
import com.nt.dto.ConsultationDTO;
import com.nt.dto.ConsultationTrackerDTO;
import com.nt.dto.DoctorsDTO;
import com.nt.dto.PatientDTO;
import com.nt.util.GenerateTemplate;
import com.nt.util.SendEmail;
import com.nt.util.TimeManagementUtil;

import antlr.StringUtils;

@RestController
public class DoctorsController {

	@Autowired
	private DoctorsDAO doctorsDao;

	@Autowired
	private PatientDAO patientDao;
	
	@Autowired
	private ConsultationDAO  consultationDao;
	
	@Autowired
	private SendEmail  sendEmail;
	
	@Autowired
	private GenerateTemplate generateTemplates;
	
	@Autowired
	private ConsultationTrackerDAO consultationTrackerDao;
	

	@GetMapping(value = "/checkDoctorsAvailability/{disease}")
	public DoctorsDTO checkDoctorsAvailability(@PathVariable(value = "disease") String diseaseName) {
		// todo get the param value and hit the DB
		System.out.println("DoctorsController.checkDoctorsAvailability()");
		List<DoctorsBO> listOfDoctors = doctorsDao.findByDiseaseName(diseaseName);

		// # doc_id, doc_name, doc_shift_timing, room_no, specialist_for
		// '101', 'R.K.Das', 'morning', '10A', 'fever'
		// '102', 'M.Mittal', 'afternoon', '12B', 'eye'
		// '103', 'A.Tripathy', 'night', '13C', 'cardiac'
		
		Date dt = new Date();
		int hours = dt.getHours();

		// compare the retrived datas with the shift timing
		DoctorsDTO doctorsDto = new DoctorsDTO();
		if (null != listOfDoctors && listOfDoctors.size() >= 1)
			for (DoctorsBO doctorBO : listOfDoctors) {
				if (null != doctorBO.getDocShiftTiming()
						&& doctorBO.getDocShiftTiming().equalsIgnoreCase(TimeManagementUtil.getShiftTime(hours))) {
					doctorsDto.setDocId(doctorBO.getDocId());
					doctorsDto.setDocName(doctorBO.getDocName());
					doctorsDto.setRoomNo(doctorBO.getRoomNo());
				}

			}
		return doctorsDto;
	}
	
	

	@PostMapping(value = "/updatePatientDetails/{disease}")
	public String updatePatientDetails(@PathVariable(value = "disease") String diseasename,
			@RequestBody PatientDTO patientDTO) {
		System.out.println(patientDTO.toString());
		PatientBO patientBo = null;
		if (null != patientDTO.getPatientMob()) {
			patientBo = patientDao.findByPatientMob(patientDTO.getPatientMob());
		}

		if (patientBo != null && patientBo.getPatientMob().equalsIgnoreCase(patientDTO.getPatientMob())) {
			return "Patientdata already available";
		} else {
			patientBo = new PatientBO();
			patientBo.setPatientMob(patientDTO.getPatientMob());
			patientBo.setPatientName(patientDTO.getPatientName());
			//patientBo.setPatientAge(12); // Integer.valueOf(Value) / (Integer)value
			patientBo.setPatientAge(patientDTO.getPatientAge()); 
			patientBo.setGender(patientDTO.getGender());
			patientBo.setAddress(patientDTO.getAddress());
			patientBo.setReasonOfVisit(diseasename);

			patientDao.save(patientBo);
			// patientDao.savePatientDetails(mob,pName,Integer.valueOf(pAge),gen,addrs,diseasename);

			return "PatientDetail saved";
		}
	}
	@GetMapping(value="/getPatientDetails/{mobno}/{docId}")
	public ConsultationTrackerDTO getPatientDetails(@PathVariable(value="mobno") String mobileNo,
			@PathVariable(value="docId") int docId){
		PatientBO patientBo= patientDao.findByPatientMob(mobileNo);
				
		if (patientBo != null) {
			PatientDTO patientDto = new PatientDTO();
			patientDto.setPatientMob(patientBo.getPatientMob());
			patientDto.setPatientName(patientBo.getPatientName());
			patientDto.setPatientAge(patientBo.getPatientAge());
			patientDto.setAddress(patientBo.getAddress());
			patientDto.setGender(patientBo.getGender());
			System.out.println(patientBo.getBloodGroup());
			patientDto.setBloodGroup(patientBo.getBloodGroup());
			
			List<ConsultationDTO> consultationDTOList = new ArrayList<>();
			
			//get thw data from db
			List<ConsultationBO> consultationBos=consultationDao.findByPatientMob(mobileNo);
			
			for (ConsultationBO consultationBo : consultationBos) {
				
				//[{},{},{}]
				
				//creating th DTO object for UI
				ConsultationDTO consultationDTO = new ConsultationDTO();
				
				//set the DTO from BO
				consultationDTO.setDate(consultationBo.getDate());
				consultationDTO.setAdmnDate(consultationBo.getAdmnDate ());
				consultationDTO.setDiscDate(consultationBo.getDiscDate());
				consultationDTO.setDocName(consultationBo.getDocName());
				consultationDTO.setPatientType(consultationBo.getPatientType());
				consultationDTO.setDisease(consultationBo.getDisease());
				consultationDTO.setMedications(consultationBo.getMedications());
				
				consultationDTOList.add(consultationDTO);
			}
			
			patientDto.setConsultationDTOList(consultationDTOList);
			
			
			String uniqueToken=createToken(patientDto.getPatientName());
			
			ConsultationTrackerBO consulationTrackerBo=new ConsultationTrackerBO();
			ConsultationTrackerDTO consulationTrackerDto=new ConsultationTrackerDTO();
			consulationTrackerDto.setTokenId(uniqueToken);
			consulationTrackerDto.setPatientMob(patientBo.getPatientMob());
			consulationTrackerDto.setDocId(docId);
			
			consulationTrackerBo.setTokenId(consulationTrackerDto.getTokenId());
			consulationTrackerBo.setPatientMobile(consulationTrackerDto.getPatientMob());
			consulationTrackerBo.setDocId(consulationTrackerDto.getDocId());
			
			consultationTrackerDao.save(consulationTrackerBo);
			
			
			return consulationTrackerDto;
		}
		else
			return null;
		
	}
	
	public static String createToken(String patientName) {
		StringBuilder token=new StringBuilder();
		token.append(patientName.substring(0, 4));
		token.append(new Date().getDate());
		token.append(new Date().getHours());
		
		return token.toString();
	}
	@GetMapping(value="/getPatientDetail/{tokenid}")
	public PatientDTO getPatientDetail(@PathVariable(value="tokenid") String tokenId){
		ConsultationTrackerBO consultationTrackerBo= consultationTrackerDao.findByTokenId(tokenId);
		consultationTrackerBo.getPatientMobile();
		consultationTrackerBo.getDocId();
		PatientBO patientBo=patientDao.findByPatientMob(consultationTrackerBo.getPatientMobile());
		
		Long docId = Long.valueOf(consultationTrackerBo.getDocId());
		DoctorsBO doctorBo = doctorsDao.findByDocId(docId);
		
		List<ConsultationDTO> consultationDTOList = new ArrayList<>();
		List<ConsultationBO> consultationBos=consultationDao.findByPatientMob(consultationTrackerBo.getPatientMobile());
		for (ConsultationBO consultationBo : consultationBos) {
			
			//[{},{},{}]
			
			//creating th DTO object for UI
			ConsultationDTO consultationDTO = new ConsultationDTO();
			
			//set the DTO from BO
			consultationDTO.setDate(consultationBo.getDate());
			consultationDTO.setAdmnDate(consultationBo.getAdmnDate ());
			consultationDTO.setDiscDate(consultationBo.getDiscDate());
			consultationDTO.setDocName(consultationBo.getDocName());
			consultationDTO.setPatientType(consultationBo.getPatientType());
			consultationDTO.setDisease(consultationBo.getDisease());
			consultationDTO.setMedications(consultationBo.getMedications());
			
			consultationDTOList.add(consultationDTO);
		}
		PatientDTO patientDto=new PatientDTO();
		DoctorsDTO doctorsDto=new DoctorsDTO();
		patientDto.setPatientMob(patientBo.getPatientMob());
		doctorsDto.setDocId(doctorBo.getDocId());
		doctorsDto.setDocName(doctorBo.getDocName());
		doctorsDto.setRoomNo(doctorBo.getRoomNo());
		doctorsDto.setMobileNo(doctorBo.getMobileNo());
		doctorsDto.setSpecialistFor(doctorBo.getSpecialistFor());
		patientDto.setDoctorsdto(doctorsDto);
		patientDto.setAddress(patientBo.getAddress());
		patientDto.setBloodGroup(patientBo.getBloodGroup());
		patientDto.setEmailId(patientBo.getEmailId());
		patientDto.setGender(patientBo.getGender());
		patientDto.setPatientAge(patientBo.getPatientAge());
		patientDto.setPatientName(patientBo.getPatientName());
		patientDto.setConsultationDTOList(consultationDTOList);
		
		return patientDto;
	}
	
	@PostMapping(value="/savePatientDetails")
	public String savePatientDetails(@RequestBody PatientDTO patientDto)throws Exception {
		System.out.println(patientDto.toString());
		ConsultationBO consultationBo=new ConsultationBO();
		
		consultationBo.setMobileNo(patientDto.getPatientMob());
		consultationBo.setDate(patientDto.getConsultaDto().getDate());
		consultationBo.setAdmnDate(patientDto.getConsultaDto().getAdmnDate());
		consultationBo.setDiscDate(patientDto.getConsultaDto().getDiscDate());
		consultationBo.setDisease(patientDto.getConsultaDto().getDisease());
		consultationBo.setDocName(patientDto.getConsultaDto().getDocName());
		consultationBo.setPatientType(patientDto.getConsultaDto().getPatientType());
		consultationBo.setMedications(patientDto.getConsultaDto().getMedications());
		
		consultationDao.saveAndFlush(consultationBo);
		
		//generate method call -- will generate  a template
		//@Param patientDto
		
		  generateTemplates.generateTemplate(patientDto);
		  
		   File file = new File("D:/spring_prgms_workspace/FirstPDF.pdf");
		  if (file.exists())
		 
			sendEmail.emailSend();
		
		return "Structure of the data";
	}
	
}

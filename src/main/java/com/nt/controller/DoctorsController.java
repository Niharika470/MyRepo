package com.nt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bo.DoctorsBO;
import com.nt.bo.PatientBO;
import com.nt.dao.DoctorsDAO;
import com.nt.dao.PatientDAO;
import com.nt.dto.DoctorsDTO;
import com.nt.dto.PatientDTO;
import com.nt.util.TimeManagementUtil;

@RestController
public class DoctorsController {

	@Autowired
	private DoctorsDAO doctorsDao;

	@Autowired
	private PatientDAO patientDao;

	@GetMapping(value = "/checkDoctorsAvailability/{disease}")
	public DoctorsDTO checkDoctorsAvailability(@PathVariable(value = "disease") String diseaseName) {
		// todo get the param value and hit the DB
		System.out.println("DoctorsController.checkDoctorsAvailability()");
		List<DoctorsBO> listOfDoctors = doctorsDao.findByDiseaseName(diseaseName);

		// # doc_id, doc_name, doc_shift_timing, room_no, specialist_for
		// '101', 'R.K.Das', 'morning', '10A', 'fever'
		// '102', 'M.Mittal', 'afternoon', '12B', 'eye'
		// '103', 'A.Tripathy', 'night', '13C', 'cardiac'

		// List<DoctorsBO> listOfDoctors = doctorsDao.findAll();

		// listOfDoctors = null;
		// [DoctorsBO,DoctorsBO1] //[] | null
		//

		// capture the current timestamp and define what is the shift timing
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

	@PostMapping(value = "/updatePatientDetails/{mobileno}/{name}/{age}/{gender}/{address}/{disease}")
	public String updaupdatePatientDetailste(@PathVariable(value = "mobileno") String mob,
			@PathVariable(value = "name") String pName, @PathVariable(value = "age") String pAge,
			@PathVariable(value = "gender") String gen, @PathVariable(value = "address") String addrs,
			@PathVariable(value = "disease") String diseasename) {
		PatientBO patientBo = null;
		if (null != mob) {
			patientBo = patientDao.findByPatientMob(mob);
		}

		if (patientBo != null && patientBo.getPatientMob().equalsIgnoreCase(mob)) {
			return "Patientdata already available";
		} else {
			patientBo = new PatientBO();
			patientBo.setPatientMob(mob);
			patientBo.setPatientName(pName);
			patientBo.setPatientAge(Integer.valueOf(pAge)); // Integer.valueOf(Value) / (Integer)value
			patientBo.setGender(gen);
			patientBo.setAddress(addrs);
			patientBo.setReasonOfVisit(diseasename);

			patientDao.save(patientBo);
			// patientDao.savePatientDetails(mob,pName,Integer.valueOf(pAge),gen,addrs,diseasename);

			return "PatientDetail saved";
		}
	}
}

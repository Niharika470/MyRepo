package com.nt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientDTO {
	
	private String patientMob;
	private String patientName;
	private int patientAge;
	private String gender;
	private String address;
	private String bloodGroup;
	private String emailId;
	private List<ConsultationDTO> consultationDTOList;
	private ConsultationDTO consultaDto;
	private DoctorsDTO doctorsdto;
	


	public void setConsultaDto(ConsultationDTO consultaDto) {
		this.consultaDto = consultaDto;
	}

	public DoctorsDTO getDoctorsdto() {
		return doctorsdto;
	}

	public void setDoctorsdto(DoctorsDTO doctorsdto) {
		this.doctorsdto = doctorsdto;
	}

	public ConsultationDTO getConsultaDto() {
		return consultaDto;
	}
	
	@JsonProperty("consultaDto")
	public void setConsultationTrackerDto(ConsultationDTO consultationDto) {
		this.consultaDto = consultationDto;
	}
	public String getPatientMob() {
		return patientMob;
	}
	@JsonProperty("patientMob")
	public void setPatientMob(String patientMob) {
		this.patientMob = patientMob;
	}
	public String getPatientName() {
		return patientName;
	}
	@JsonProperty("patientName")
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	@JsonProperty("patientAge")
	public void setPatientAge(int string) {
		this.patientAge = string;
	}
	public String getGender() {
		return gender;
	}
	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonProperty("bloodgroup")
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	@JsonProperty("emailId")
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public List<ConsultationDTO> getConsultationDTOList() {
		return consultationDTOList;
	}
	@JsonProperty("consultaDTOList")
	public void setConsultationDTOList(List<ConsultationDTO> consultationDTOList) {
		this.consultationDTOList = consultationDTOList;
	}
	@Override
	public String toString() {
		return "PatientDTO [patientMob=" + patientMob + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", gender=" + gender + ", address=" + address + ", bloodGroup=" + bloodGroup
				+ ",emailId="+emailId+", consultationDTOList=" + consultationDTOList + ", consultaDto=" + consultaDto + "]";
	}

	
}

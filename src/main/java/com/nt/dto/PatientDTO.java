package com.nt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientDTO {
	
	private String patientMob;
	private String patientName;
	private int patientAge;
	private String gender;
	private String address;
	
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
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
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
	@Override
	public String toString() {
		return "PatientDTO [patientMob=" + patientMob + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", gender=" + gender + ", address=" + address + "]";
	}

	
}

package com.nt.dto;

public class PatientDTO {
	private String patientMob;
	private String patientName;
	private int patientAge;
	private String gender;
	private String address;
		public String getPatientMob() {
		return patientMob;
	}
	public void setPatientMob(String patientMob) {
		this.patientMob = patientMob;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}

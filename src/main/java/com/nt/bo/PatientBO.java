package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_table")
public class PatientBO {
	
	@Id
	@Column(name="Patient_Mob")
	private String patientMob;
	
	@Column(name="Patient_Name")
	private String patientName;
	
	@Column(name="Patient_Age")
	private int patientAge;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Reason_Of_Visit")
	private String reasonOfVisit;
	
	@Column(name="Visit_History")
	private String visitHistory;
	
	@Column(name="Address")
	private String address;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	public String getReasonOfVisit() {
		return reasonOfVisit;
	}
	public void setReasonOfVisit(String reasonOfVisit) {
		this.reasonOfVisit = reasonOfVisit;
	}
	public String getVisitHistory() {
		return visitHistory;
	}
	public void setVisitHistory(String visitHistory) {
		this.visitHistory = visitHistory;
	}

}

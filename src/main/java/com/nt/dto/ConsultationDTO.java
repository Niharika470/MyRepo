package com.nt.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultationDTO {
	
	
	@JsonProperty("Date")
    private Date date;
	
	@JsonProperty("AdmnDate")
	private Date admnDate;
	
	@JsonProperty("DiscDate")
	private Date discDate;
	
	@JsonProperty("DocName")
	private String docName;
	
	@JsonProperty("PatientType")
	private String patientType;
	
	@JsonProperty("Disease")
	private String disease;
	
	@JsonProperty("Medications")
	private String medications;

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getAdmnDate() {
		return admnDate;
	}


	public void setAdmnDate(Date admnDate) {
		this.admnDate = admnDate;
	}


	public Date getDiscDate() {
		return discDate;
	}


	public void setDiscDate(Date discDate) {
		this.discDate = discDate;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getPatientType() {
		return patientType;
	}


	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public String getMedications() {
		return medications;
	}


	public void setMedications(String medications) {
		this.medications = medications;
	}


	
}

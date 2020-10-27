package com.nt.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="consultation_history_table")
public class ConsultationBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="mobileno")
	private String mobileNo;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="admn_date")
	private Date admnDate;
	
	@Column(name="disc_date")
	private Date discDate;
	
	@Column(name="docname")
	private String docName;
	
	@Column(name="patienttype")
	private String patientType;
	
	@Column(name="disease")
	private String disease;
	
	@Column(name="medications")
	private String medications;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}

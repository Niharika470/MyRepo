package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultation_tracker")
public class ConsultationTrackerBO {
	@Id
	@Column(name="tokenid")
	private String tokenId;
	
	@Column(name="patient_mob")
	private String patientMobile;
	
	@Column(name="doc_id")
	private int docId;

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

}

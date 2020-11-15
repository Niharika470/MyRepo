package com.nt.dto;

public class ConsultationTrackerDTO {
	
	private String tokenId;
	private String patientMob;
	private int docId;
	
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getPatientMob() {
		return patientMob;
	}
	public void setPatientMob(String patientMob) {
		this.patientMob = patientMob;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}

}

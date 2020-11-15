package com.nt.dto;

public class DoctorsDTO {
	
	
	private long docId;
	private String docName;
	private String roomNo;
	private String specialistFor;
	private String mobileNo;
	


	public long getDocId() {
		return docId;
	}


	public void setDocId(long docId) {
		this.docId = docId;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getSpecialistFor() {
		return specialistFor;
	}
	public void setSpecialistFor(String specialistFor) {
		this.specialistFor = specialistFor;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctorsdetails")
public class DoctorsBO {
	
	
	@Id
	@Column(name="doc_id")
	private long docId;
	
	@Column(name="doc_name")
	private String docName;
	
	@Column(name="doc_shift_timing")
	private String docShiftTiming;
	
	@Column(name="room_no")
	private String roomNo;
	
	@Column(name="specialist_for")
	private String specialistFor;
	
	@Column(name="MobileNo")
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
	public String getDocShiftTiming() {
		return docShiftTiming;
	}
	public void setDocShiftTiming(String docShiftTiming) {
		this.docShiftTiming = docShiftTiming;
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
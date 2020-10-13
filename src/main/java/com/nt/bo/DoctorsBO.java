package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctorsdetails")
public class DoctorsBO {
	
	
	@Id
	@Column(name="DocId")
	private long docId;
	
	@Column(name="DocName")
	private String docName;
	
	@Column(name="DocShiftTiming")
	private String docShiftTiming;
	
	@Column(name="RoomNo")
	private String roomNo;
	
	@Column(name="SpecialistFor")
	private String specialistFor;
	
	
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
	
	
	
}
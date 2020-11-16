package com.nt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.bo.ConsultationTrackerBO;
import com.nt.bo.DoctorsBO;
import com.nt.bo.PatientBO;

@Repository
public interface ConsultationTrackerDAO extends JpaRepository<ConsultationTrackerBO, String>{
	@Query("select s from ConsultationTrackerBO s where s.tokenId=?1")
	ConsultationTrackerBO findByTokenId(String token);
}

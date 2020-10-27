package com.nt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.bo.ConsultationBO;
import com.nt.bo.PatientBO;
@Repository
public interface ConsultationDAO extends JpaRepository<ConsultationBO,Integer>{
	@Query("select s from ConsultationBO s where s.mobileNo=?1")
	List<ConsultationBO> findByPatientMob(String mob);

}

package com.nt.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.bo.PatientBO;

@Repository
public interface PatientDAO extends JpaRepository<PatientBO,String>{
	
	@Query("select s from PatientBO s where s.patientMob=?1")
	PatientBO findByPatientMob(String mob);

	/*
	 * @Query("insert into PatientBO (address, gender, patient_age, patient_name, reason_of_visit, patient_mob) values (?5, ?4, ?3, ?2, ?6, ?, ?1)"
	 * ) void savePatientDetails(String mob, String pName, Integer valueOf, String
	 * gen, String addrs, String diseasename);
	 */
}

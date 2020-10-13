package com.nt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.bo.DoctorsBO;

@Repository
public interface DoctorsDAO extends JpaRepository<DoctorsBO, Long>{
	
	
	  @Query("select d from DoctorsBO d where d.specialistFor =?1")
	  List<DoctorsBO> findByDiseaseName(String disease);
	 

}



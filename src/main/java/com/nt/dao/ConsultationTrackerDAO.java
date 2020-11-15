package com.nt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.bo.ConsultationTrackerBO;
import com.nt.bo.DoctorsBO;

@Repository
public interface ConsultationTrackerDAO extends JpaRepository<ConsultationTrackerBO, String>{

}

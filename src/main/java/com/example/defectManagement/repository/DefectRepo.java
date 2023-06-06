package com.example.defectManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.defectManagement.entity.Defect; 

@Repository
public interface DefectRepo extends JpaRepository<Defect, Long> {
	
	List<Defect> findByAssignedToDeveloperId(String assignedToDeveloperId);

}
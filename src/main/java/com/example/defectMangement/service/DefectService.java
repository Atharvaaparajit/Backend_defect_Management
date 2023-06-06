package com.example.defectMangement.service;

import java.util.List;

import com.example.defectManagement.entity.Defect;

public interface DefectService {

	Defect createDefect(Defect defect);
	
	Defect getDefectById(Long Id);
	
	List<Defect> getAllDefects();
	
	Defect updateDefects(Defect defects);
	
	void deleteDefect(Long id);
	
	List<Defect> getDefectByDeveloperId(String Id);

}

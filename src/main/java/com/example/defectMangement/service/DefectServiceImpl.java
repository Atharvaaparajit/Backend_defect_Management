package com.example.defectMangement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.defectManagement.entity.Defect;
import com.example.defectManagement.entity.PriorityType;
import com.example.defectManagement.entity.SeverityType;
//import com.example.defectManagement.entity.Resolutions;
import com.example.defectManagement.repository.DefectRepo;

import java.time.LocalDate;
//import com.example.defectManagement.repository.ResolutionRepo;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	private DefectRepo defectRepo;

	public Defect createDefect(Defect defect) {
		// TODO Auto-generated method stub
		String defectDetails[] = defect.getDefectDetails().split(" ");
		String stepsToReproduce[] = defect.getStepsToReproduce().split(" ");
		System.out.println(stepsToReproduce.length);
		System.out.println(defectDetails.length);
		if (defectDetails.length >= 10 && stepsToReproduce.length >= 10) {
			LocalDate date = java.time.LocalDate.now();
			defect.setDetectedOn(date);
			if(defect.getSeverity().equals(SeverityType.Blocker)) {
				if(defect.getPriority().equals(PriorityType.P1)) {
					date = date.plusDays(2);
				}
				else if (defect.getPriority().equals(PriorityType.P2)){
					date = date.plusDays(3);
				}
			}
			else if (defect.getSeverity().equals(SeverityType.Critcal)) {
				if(defect.getPriority().equals(PriorityType.P1)) {
					date = date.plusDays(1);
				}
				else if (defect.getPriority().equals(PriorityType.P2)){
					date = date.plusDays(2);
				}
			}
			else {
				if(defect.getPriority().equals(PriorityType.P1)) {
					date = date.plusDays(5);
				}
				else if (defect.getPriority().equals(PriorityType.P2)){
					date = date.plusDays(8);
				}
				else {
					date = date.plusDays(10);
				}
			}
			defect.setExpectedResolution(date);
			return defectRepo.save(defect);
		}
		return null;
	}

	public Defect getDefectById(Long Id) {
		Optional<Defect> optionalDefect = defectRepo.findById(Id);
		return optionalDefect.get();
	}

	@Override
	public List<Defect> getAllDefects() {
		// TODO Auto-generated method stub
		return defectRepo.findAll();
	}

	public Defect updateDefects(Defect defects) {
		Defect existingDefect = defectRepo.findById(defects.getDefect_id()).get();
		existingDefect.setAssignedToDeveloperId(defects.getAssignedToDeveloperId());
		existingDefect.setDefectDetails(defects.getDefectDetails());
		existingDefect.setDetectedOn(defects.getDetectedOn());
		existingDefect.setExpectedResolution(defects.getExpectedResolution());
		existingDefect.setProjectCode(defects.getProjectCode());
		existingDefect.setPriority(defects.getPriority());
		existingDefect.setSeverity(defects.getSeverity());
		existingDefect.setStatus(defects.getStatus());
		existingDefect.setTitle(defects.getTitle());
		Defect updatedDefect = defectRepo.save(existingDefect);
		return updatedDefect;
	}

	public void deleteDefect(Long id) {
		// TODO Auto-generated method stub
		defectRepo.deleteById(id);
	}

	public List<Defect> getDefectByDeveloperId(String id) {
		// TODO Auto-generated method stub
		return defectRepo.findByAssignedToDeveloperId(id);
	}
}

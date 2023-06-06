package com.example.defectMangement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.defectManagement.entity.Defect;
import com.example.defectManagement.entity.Resolutions;
import com.example.defectManagement.repository.ResolutionRepo;

@Service
public class ResolutionServiceImpl implements ResolutionService {
	
	@Autowired
	private ResolutionRepo resolutionRepo;

	@Override
	public Resolutions createResolutions(Resolutions resolutions) {
		// TODO Auto-generated method stub
		return resolutionRepo.save(resolutions);
	}

	@Override
	public Resolutions getResolutionsById(Long Id) {
        Optional<Resolutions> optionalResolution = resolutionRepo.findById(Id);
        return optionalResolution.get();
	}

	@Override
	public List<Resolutions> getAllResolutions() {
		// TODO Auto-generated method stub
		return resolutionRepo.findAll();
	}

	@Override
	public Resolutions updateResolutions(Resolutions resolutions) {
		Resolutions existingResolutions= resolutionRepo.findById(resolutions.getId()).get();
		existingResolutions.setResolution(resolutions.getResolution());
		existingResolutions.setResolutionDate(resolutions.getResolutionDate());
		existingResolutions.setDefect_id(resolutions.getDefect_id());
		Resolutions updatedResolution=resolutionRepo.save(existingResolutions);
		return updatedResolution;
	}


	@Override
	public void deleteResolutions(Long id) {
		// TODO Auto-generated method stub
		resolutionRepo.deleteById(id);
	}
	

}

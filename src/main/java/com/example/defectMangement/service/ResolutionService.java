package com.example.defectMangement.service;

import java.util.List;

import com.example.defectManagement.entity.Resolutions;

public interface ResolutionService {
	
	Resolutions createResolutions(Resolutions resolutions);

	Resolutions getResolutionsById(Long Id);

    List<Resolutions> getAllResolutions();
    
    Resolutions updateResolutions(Resolutions resolutions);

    void deleteResolutions(Long id);

}

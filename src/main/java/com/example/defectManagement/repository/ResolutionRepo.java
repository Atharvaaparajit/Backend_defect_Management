package com.example.defectManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.defectManagement.entity.Resolutions;

@Repository
public interface ResolutionRepo extends JpaRepository<Resolutions, Long> {

}

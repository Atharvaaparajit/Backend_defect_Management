package com.example.defectManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.defectMangement.controller", "com.example.defectMangement.service", "com.example.defectManagement.repository", "com.example.defectManagement.entity"})
public class DefectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefectManagementApplication.class, args);
	}

}

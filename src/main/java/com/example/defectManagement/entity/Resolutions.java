package com.example.defectManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resolutions")
public class Resolutions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long defect_id;

	private String resolutionDate;

	private String resolution;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDefect_id() {
		return defect_id;
	}

	public void setDefect_id(Long defect_id) {
		this.defect_id = defect_id;
	}

	public String getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}

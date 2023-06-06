package com.example.defectManagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Defect")
public class Defect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "defect_id")
	private Long defect_id;

	private String title;

	private String defectDetails;

	private String stepsToReproduce;

	private PriorityType priority;

	private LocalDate detectedOn;

	private LocalDate expectedResolution;

	private String reportedByTesterId;

	private String assignedToDeveloperId;

	private SeverityType severity;

	private String status;

	private Integer projectCode;

	@OneToMany
	@JoinColumn(name = "defect_id")
	List<Resolutions> resolutions;

	public Long getDefect_id() {
		return defect_id;
	}

	public void setDefect_id(Long defect_id) {
		this.defect_id = defect_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDefectDetails() {
		return defectDetails;
	}

	public void setDefectDetails(String defectDetails) {
		this.defectDetails = defectDetails;
	}

	public String getStepsToReproduce() {
		return stepsToReproduce;
	}

	public void setStepsToReproduce(String stepsToReproduce) {
		this.stepsToReproduce = stepsToReproduce;
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}

	public LocalDate getDetectedOn() {
		return detectedOn;
	}

	public void setDetectedOn(LocalDate detectedOn) {
		this.detectedOn = detectedOn;
	}

	public LocalDate getExpectedResolution() {
		return expectedResolution;
	}

	public void setExpectedResolution(LocalDate expectedResolution) {
		this.expectedResolution = expectedResolution;
	}

	public String getReportedByTesterId() {
		return reportedByTesterId;
	}

	public void setReportedByTesterId(String reportedByTesterId) {
		this.reportedByTesterId = reportedByTesterId;
	}

	public String getAssignedToDeveloperId() {
		return assignedToDeveloperId;
	}

	public void setAssignedToDeveloperId(String assignedToDeveloperId) {
		this.assignedToDeveloperId = assignedToDeveloperId;
	}

	public SeverityType getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityType severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}

}

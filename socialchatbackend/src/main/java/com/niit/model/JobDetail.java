package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@SequenceGenerator(name = "jobidseq", sequenceName="job_id_sequence", allocationSize = 1)
public class JobDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobidseq")
	private int jobId;
	private String jobDesignation;

	private int salary;
	private String company;
	private String role;
	private String location;
	private String lastDateToApply;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(String lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

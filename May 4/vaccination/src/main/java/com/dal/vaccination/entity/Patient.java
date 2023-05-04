package com.dal.vaccination.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vac_patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
	
	@Column(nullable = false)
	private String patientFirstName;
	
	@Column(nullable = false)
	private String patientLastName;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = true)
	private Long mobile;
	
	@Column(nullable = false)
	private String dob;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Patient(Long patientId, String patientFirstName, String patientLastName, String address, Long mobile,
			String dob) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.address = address;
		this.mobile = mobile;
		this.dob = dob;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}

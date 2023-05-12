package com.dal.vaccination.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vac_patient_details")
public class PatientVaccinationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(nullable = false)
	private Long patientId;
	
	public PatientVaccinationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientVaccinationDetails(Long id, Long patientId, Long vacinationId, Date vaccinationDate) {
		super();
		Id = id;
		this.patientId = patientId;
		this.vacinationId = vacinationId;
		this.vaccinationDate = vaccinationDate;
	}

	
	@Column(nullable = false)
	private Long vacinationId;
	
	@Column(nullable = false)
	private Date vaccinationDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getVacinationId() {
		return vacinationId;
	}

	public void setVacinationId(Long vacinationId) {
		this.vacinationId = vacinationId;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	@Override
	public String toString() {
		return "PatientVaccinationDetails [Id=" + Id + ", patientId=" + patientId + ", vacinationId=" + vacinationId
				+ ", vaccinationDate=" + vaccinationDate + "]";
	}
	


}

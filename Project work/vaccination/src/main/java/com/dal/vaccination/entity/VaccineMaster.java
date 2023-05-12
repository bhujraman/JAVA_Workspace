package com.dal.vaccination.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "vac_master")
public class VaccineMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long VaccineMasterId;
	
	@Column(nullable = false)
	private String vaccineName;
	
	@Column(nullable = false)
	private String age;
	
	@Column(nullable = false)
	private String ageinDays;

	public VaccineMaster(Long vaccineMasterId, String vaccineName, String age, String ageinDays) {
		super();
		VaccineMasterId = vaccineMasterId;
		this.vaccineName = vaccineName;
		this.age = age;
		this.ageinDays = ageinDays;
	}

	public VaccineMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getVaccineMasterId() {
		return VaccineMasterId;
	}

	public void setVaccineMasterId(Long vaccineMasterId) {
		VaccineMasterId = vaccineMasterId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeinDays() {
		return ageinDays;
	}

	public void setAgeinDays(String ageinDays) {
		this.ageinDays = ageinDays;
	}

	@Override
	public String toString() {
		return "VaccineMaster [VaccineMasterId=" + VaccineMasterId + ", vaccineName=" + vaccineName + ", age=" + age
				+ ", ageinDays=" + ageinDays + "]";
	}


}

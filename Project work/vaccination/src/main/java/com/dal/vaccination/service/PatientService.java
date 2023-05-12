package com.dal.vaccination.service;

import java.util.List;

import com.dal.vaccination.entity.Patient;

public interface PatientService {
	public Patient addPatient(Patient patient);	
	public List<Patient> getAllPatient();
	//public List<Patient> getAllList();
	public void deleteByPatientId(Long pid);
	public Patient updatePatient(Patient patient);
}

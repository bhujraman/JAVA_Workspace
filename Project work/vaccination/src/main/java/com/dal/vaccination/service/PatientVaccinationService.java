package com.dal.vaccination.service;

import java.util.List;
import java.util.Optional;

import com.dal.vaccination.entity.PatientVaccinationDetails;

public interface PatientVaccinationService {

	public PatientVaccinationDetails addPatientVaccination(PatientVaccinationDetails patientVaccination);
	public List<PatientVaccinationDetails> getAllPatientVaccinationDetails();
	public List<PatientVaccinationDetails> getPatientVaccinatorDetails();
	
	public Optional<PatientVaccinationDetails> searchByPatientId(Long pid);
}


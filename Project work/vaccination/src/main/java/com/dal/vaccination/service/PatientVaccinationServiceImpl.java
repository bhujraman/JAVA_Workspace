package com.dal.vaccination.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.vaccination.entity.PatientVaccinationDetails;
import com.dal.vaccination.repo.PatientVaccinationDetailsRepo;

@Service
public class PatientVaccinationServiceImpl implements PatientVaccinationService {
	@Autowired
	PatientVaccinationDetailsRepo vaccinationRepo;
	
	@Override
	public PatientVaccinationDetails addPatientVaccination(PatientVaccinationDetails patientVaccine) {
		return vaccinationRepo.save(patientVaccine);
	}

	@Override
	public List<PatientVaccinationDetails> getAllPatientVaccinationDetails() {
		
		return (List<PatientVaccinationDetails>)vaccinationRepo.findAll();
	}

	@Override
	public Optional<PatientVaccinationDetails> searchByPatientId(Long pid) {
		
		return vaccinationRepo.findByPatientId(pid);
	}

	@Override
	public List<PatientVaccinationDetails> getPatientVaccinatorDetails() {
			return vaccinationRepo.getPatientVaccinatorDetails();
	}
	

}

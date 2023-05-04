package com.dal.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepo patientRepo;
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepo.save(patient);
	}

}

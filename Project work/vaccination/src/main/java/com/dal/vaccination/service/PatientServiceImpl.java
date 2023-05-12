package com.dal.vaccination.service;

import java.util.List;

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
	public List<Patient> getAllPatient(){
		return (List<Patient>)patientRepo.findAll();
	}
	@Override
	public void deleteByPatientId(Long pid) {
		patientRepo.deleteById(pid);
	}
	@Override
	public Patient updatePatient(Patient patient) {
		Patient existingPatient = patientRepo.findById(patient.getPatientId()).orElse(null);
		existingPatient.setMobile(patient.getMobile());
		return patientRepo.save(existingPatient);
	}
//	public List<Patient> getAllList(){
//		return (List<Patient>)patientRepo.findAllByCustomQueryAndStream();
//	}
	
}

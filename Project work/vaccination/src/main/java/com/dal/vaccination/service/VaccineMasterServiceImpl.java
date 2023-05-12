package com.dal.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.entity.PatientVaccinationDetails;
import com.dal.vaccination.entity.VaccineMaster;
import com.dal.vaccination.repo.PatientRepo;
import com.dal.vaccination.repo.VaccineMasterRepo;

@Service
public class VaccineMasterServiceImpl implements VaccineMasterService {

	@Autowired
	VaccineMasterRepo vacmasterRepo;
	
	@Override
	public VaccineMaster addVaccine(VaccineMaster vacmaster) {
		
		return vacmasterRepo.save(vacmaster);
	}


}

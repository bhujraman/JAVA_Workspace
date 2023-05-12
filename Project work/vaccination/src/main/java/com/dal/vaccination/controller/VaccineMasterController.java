package com.dal.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.entity.PatientVaccinationDetails;
import com.dal.vaccination.entity.VaccineMaster;
import com.dal.vaccination.service.PatientService;
import com.dal.vaccination.service.VaccineMasterService;


@RestController
public class VaccineMasterController {

	@Autowired
	VaccineMasterService vaccMasterService;
	
	@GetMapping("/welcomevaccinemaster")
	public String hellovaccine() {
		return "Hello vaccine master";
	}
	
	@PostMapping("/addVaccineMaster")
	public VaccineMaster postVaccineMaster(@RequestBody VaccineMaster vaccmaster) {
		return vaccMasterService.addVaccine(vaccmaster);
	}
	
}

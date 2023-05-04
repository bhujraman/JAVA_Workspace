package com.dal.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.service.PatientService;


@RestController
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@GetMapping("/welcome")
	public String helloWorld() {
		return "Hello Welcome";
	}
	
	@PostMapping("/addPatient")
	public Patient postTravellers(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
}

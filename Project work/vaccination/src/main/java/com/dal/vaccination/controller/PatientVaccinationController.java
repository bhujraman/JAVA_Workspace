package com.dal.vaccination.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.entity.PatientVaccinationDetails;
import com.dal.vaccination.service.PatientService;
import com.dal.vaccination.service.PatientVaccinationService;


//class UserFoundException1 extends RuntimeException {
//
//	private static final long serialVersionUID = 1L;
//
//	public UserFoundException1(String message) {
//		super(message);
//	}
//
//}

@RestController
public class PatientVaccinationController {

	@Autowired
	PatientVaccinationService patientVacService;
	

	@PostMapping("/addPatientVaccination")
	public PatientVaccinationDetails postPatientVaccination(@RequestBody PatientVaccinationDetails patientVaccination) {
		try
		{
		return patientVacService.addPatientVaccination(patientVaccination);
		}
		catch (MappingNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method Not Found", e);
		} 
		catch (Exception exc) { throw new UserFoundException("Request body is not valid" + exc); }
	}
	@GetMapping("/getAllVaccinatedList")
	public List<PatientVaccinationDetails> getPatientVaccination() {
		
		//return patientVacService.getAllPatientVaccinationDetails();
		try
		{

		return Optional.ofNullable(patientVacService.getAllPatientVaccinationDetails())
				.orElseThrow(() -> new Exception("No record Found...."));
	}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method Not Found", e);
		}
	}
	@GetMapping("/getVaccinationByPatientId/{pid}")
	public Optional<PatientVaccinationDetails> getVaccinationPatientByid(@PathVariable Long pid) {
		return patientVacService.searchByPatientId(pid);
	}
	


}



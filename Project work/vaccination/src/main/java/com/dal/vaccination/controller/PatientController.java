package com.dal.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.boot.MappingNotFoundException;
import org.springframework.web.server.ResponseStatusException;
import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.service.PatientService;

class UserFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserFoundException(String message) {
		super(message);
	}

}

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@GetMapping("/welcome")
	public String helloWorld() {
		try {
			return "Hello Welcome to our Team5 Baby Vaccination System";
		} catch (MappingNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method Not Found", e);
		} catch (Exception exc) {
			throw exc;
		}
	}

	@PostMapping("/addPatient")
	public Patient postPatient(@RequestBody Patient patient) {
		try {
			return patientService.addPatient(patient);
		} catch (MappingNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method Not Found", e);
		} 
		catch (Exception exc) { throw new UserFoundException("Request body is not valid     " + exc); }

	}

	@DeleteMapping("/deletePatient/{pid}")
	public void deletePatient(@PathVariable Long pid) {
		patientService.deleteByPatientId(pid);

	}

	@PutMapping("/updatePatient")
	public void updatePatient(@RequestBody Patient patient) {
		patientService.updatePatient(patient);

	}

//	@GetMapping("/getAllPatient")
//	public List<Patient> getPatient() {
//		return patientService.getAllPatient();
//	}
}

package com.dal.vaccination.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;



import com.dal.vaccination.entity.PatientVaccinationDetails;

public interface PatientVaccinationDetailsRepo extends CrudRepository<PatientVaccinationDetails, Long> {
	@Procedure(name="getPatVaccinationDetails")
	public List<PatientVaccinationDetails> getPatientVaccinatorDetails();
	
	public Optional<PatientVaccinationDetails> findByPatientId(long pid);
}

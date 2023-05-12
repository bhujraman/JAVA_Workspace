package com.dal.vaccination.repo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.vaccination.entity.Patient;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Long> {

	public Patient findByPatientName(String name);
	
}

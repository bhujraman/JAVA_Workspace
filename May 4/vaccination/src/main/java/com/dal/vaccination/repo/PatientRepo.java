package com.dal.vaccination.repo;

import org.springframework.data.repository.CrudRepository;

import com.dal.vaccination.entity.Patient;

public interface PatientRepo extends CrudRepository<Patient, Long> {

}

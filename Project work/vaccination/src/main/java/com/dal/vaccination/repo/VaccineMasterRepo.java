package com.dal.vaccination.repo;

import org.springframework.data.repository.CrudRepository;

import com.dal.vaccination.entity.VaccineMaster;

public interface VaccineMasterRepo extends CrudRepository<VaccineMaster, Long> {

}

package com.agkw.studentHub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agkw.studentHub.models.University;

@Repository
public interface UniversityRepository extends CrudRepository<University, Long>{
	
}

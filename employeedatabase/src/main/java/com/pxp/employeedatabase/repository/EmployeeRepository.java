package com.pxp.employeedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pxp.employeedatabase.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	public boolean existsByFirstNameAndLastName(String firstName , String lastName);
	
	public boolean existsById(int id);
}

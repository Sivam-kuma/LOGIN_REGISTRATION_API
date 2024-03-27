package com.pxp.employeedatabase.services;

import org.springframework.stereotype.Service;

import com.pxp.employeedatabase.entity.EmployeeEntity;
import com.pxp.employeedatabase.model.Employee;
import com.pxp.employeedatabase.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class EmployeeService {
	
 @Autowired
 EmployeeRepository employeeRepository;
 
 public List<Employee> getAllEmployee(){
	 try {
		 List<EmployeeEntity> employees = employeeRepository.findAll();
		 List<Employee> customEmployees = new ArrayList<>();
		 employees.stream().forEach(e ->{
			Employee employee = new Employee();
			BeanUtils.copyProperties(e, employee);
			customEmployees.add(employee);
		 });
		 return customEmployees;
	 }catch(Exception e) {
		 throw e;
	 }
 }
 public String addEmployee(EmployeeEntity employee) {
	try {
		
	if(!employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(),employee.getLastName())) {
		employeeRepository.save(employee);
		return "Employee added successfully";
	}
	else{
		return "This employee already exist in the database.";
		}
	}catch(Exception e) {
		throw e;
	}
	 
	 
 }
 
 public String removeEmployeeById(Integer id) {
	    try {
	        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);

	        if (optionalEmployee.isPresent()) {
	            employeeRepository.delete(optionalEmployee.get());
	            return "Employee deleted successfully.";
	        } else {
	            return "Employee with id " + id + " does not exist.";
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}
 public String updateEmployee(Integer id, EmployeeEntity updatedEmployee) {
	    try {
	        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);

	        if (optionalEmployee.isPresent()) {
	            EmployeeEntity existingEmployee = optionalEmployee.get();
	            existingEmployee.setFirstName(updatedEmployee.getFirstName());
	            existingEmployee.setLastName(updatedEmployee.getLastName());

	            employeeRepository.save(existingEmployee);
	            return "Employee updated successfully.";
	        } else {
	            return "Employee does not exist.";
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}

 }


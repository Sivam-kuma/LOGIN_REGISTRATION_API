package com.pxp.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxp.employeedatabase.entity.EmployeeEntity;
import com.pxp.employeedatabase.model.Employee;
import com.pxp.employeedatabase.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@RequestMapping(value = "getallemployees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	@RequestMapping(value = "addemployee",method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeEntity employee) {
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping(value = "updateemployee/{id}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable Integer id, @RequestBody EmployeeEntity employee) {
	    
	    employeeService.updateEmployee(id, employee);
	    return "Employee updated successfully.";
	}
	
	@RequestMapping(value = "deleteemp/{id}", method = RequestMethod.DELETE)
	public String removeEmployeeById(@PathVariable Integer id) {
	    return employeeService.removeEmployeeById(id);
	}

}

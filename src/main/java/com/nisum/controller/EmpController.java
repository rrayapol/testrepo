package com.nisum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.dao.CustomerRepository;
import com.nisum.model.Employee;

@RestController
@RequestMapping("/")
public class EmpController {

	@Autowired
	private CustomerRepository repository;
	
	 private static final Logger LOG = LoggerFactory.getLogger(EmpController.class);
	
	/*
	 * Get All Employee Details
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	List<Employee> getEmployees(){
        LOG.debug("Getting Employee Details");
		return repository.findAll();
	}
	

	/*
	 * Add Employee Details
	 */
	
	@RequestMapping(method=RequestMethod.POST )
	Employee addEmployee(@RequestBody Employee emp) {
		
		return repository.save(emp);
		
	}
	
	/*
	 *  Update Employee Details
	 */

	
	@RequestMapping(method=RequestMethod.PUT)	
	Employee updateEmployee(@RequestBody Employee emp)  {

		return repository.save(emp);
	
	}
	
	
	/*
	 * Delete Employee Details
	 */

	@RequestMapping(value="/{empId}",method=RequestMethod.DELETE )
	Employee deleteEmployee(@PathVariable("empId") String empId) {
		
		Employee emp = repository.findOne(empId);
		repository.delete(emp);
		return emp;
	}
	
	
}

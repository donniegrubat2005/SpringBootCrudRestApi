package com.donniegrubat2005.SpringBootCrudRestApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donniegrubat2005.SpringBootCrudRestApi.models.Employee;
import com.donniegrubat2005.SpringBootCrudRestApi.services.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	
	@GetMapping(path="/employees")
	public List<Employee> getAllEmployees() 
	{		
		 return empservice.listEmployee();
		 
		 
	}
	
	@PostMapping(path = "/employees")
	  public Employee postEmployee(@RequestBody Employee employee) {
	 
	    empservice.save(employee);
	    return employee;
	  }
	
	@PutMapping("/employees/{id}")
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
	    System.out.println("Update employee with ID = " + id + "...");
	 
	    Employee EmployeeData = empservice.getById(id);
	    	   	 
	    empservice.save(employee);

		return ResponseEntity.ok().build();
	  }

	@DeleteMapping(value="employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		Employee emp = empservice.getById(id);
		empservice.delete(emp);
		
		return new ResponseEntity<>("employee have been deleted!", HttpStatus.OK);
	}
	 
	 
}

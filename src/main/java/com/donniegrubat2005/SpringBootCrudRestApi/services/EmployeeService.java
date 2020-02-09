package com.donniegrubat2005.SpringBootCrudRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donniegrubat2005.SpringBootCrudRestApi.models.Employee;
import com.donniegrubat2005.SpringBootCrudRestApi.repository.EmployeeRepository;

@Transactional
@Service(value="employeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> listEmployee()
	{
		return employeeRepo.findAll();
	}
	
	public Employee getById(int id) {
		return employeeRepo.findById(id).get();
		
	}
	
	public void save(Employee emp) {
		employeeRepo.save(emp);
	}
	
	public void delete(Employee emp) {
		employeeRepo.delete(emp);
    }
	

}

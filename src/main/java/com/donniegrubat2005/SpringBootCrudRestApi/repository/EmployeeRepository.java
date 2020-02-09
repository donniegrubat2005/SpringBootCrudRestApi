package com.donniegrubat2005.SpringBootCrudRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donniegrubat2005.SpringBootCrudRestApi.models.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}

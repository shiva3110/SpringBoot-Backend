package com.myProject.StudentManagement.service;

import java.util.List;

import com.myProject.StudentManagement.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee,Long id);

}

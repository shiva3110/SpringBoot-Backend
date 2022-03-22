package com.myProject.StudentManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myProject.StudentManagement.exception.ResourceNotFoundException;
import com.myProject.StudentManagement.model.Employee;
import com.myProject.StudentManagement.repository.EmployeeRepository;
import com.myProject.StudentManagement.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		/*Optional<Employee> employee= employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw  new ResourceNotFoundException("Employee", "id", id);
		}*/
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "ID", id));
		 existingEmployee.setFirstName(employee.getFirstName());
		 existingEmployee.setLastName(employee.getLastName());
		 existingEmployee.setEmail(employee.getEmail());
		 employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

}

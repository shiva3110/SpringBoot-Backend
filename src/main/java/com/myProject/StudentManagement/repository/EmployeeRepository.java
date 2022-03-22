package com.myProject.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.StudentManagement.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

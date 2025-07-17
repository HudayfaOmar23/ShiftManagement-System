package com.springboot.sms.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sms.backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findAll();


}

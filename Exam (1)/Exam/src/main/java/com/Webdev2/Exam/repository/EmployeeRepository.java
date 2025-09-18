package com.Webdev2.Exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Webdev2.Exam.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);
}



package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByMatriculation(String matriculation);

	Employee findByEmail(String email);
	
//	/List<Employee> findAll();

	long countByServiceDepartment_Id(Integer id);   
}

package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.momarious.model.ServiceDepartment;

@Repository
public interface ServiceDepartmentRepository extends JpaRepository<ServiceDepartment, Integer> {
	
	 long countByName(String name); 
}

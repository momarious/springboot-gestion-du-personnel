package com.momarious.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Sanction;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Integer> {

	List<Sanction> findByEmployee_Id(Integer id) ;
	
}

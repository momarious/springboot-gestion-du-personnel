package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Vacation;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Integer> {
	
}

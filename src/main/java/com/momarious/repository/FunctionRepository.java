package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Integer> {
	
}


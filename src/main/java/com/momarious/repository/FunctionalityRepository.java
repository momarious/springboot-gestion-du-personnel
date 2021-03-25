package com.momarious.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Functionality;

@Repository
public interface FunctionalityRepository extends JpaRepository<Functionality, Integer> {
	
	List<Functionality> findByRole_NameOrderByDisplayOrderAsc(String name);
}


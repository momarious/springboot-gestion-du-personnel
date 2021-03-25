package com.momarious.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {


	List<Action> findAllByOrderByIdDesc();

	
}

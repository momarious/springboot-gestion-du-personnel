package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
	Contract findByEmployee_Id(Integer id);

}

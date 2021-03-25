package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.Functionality;

public interface FunctionalityService {

	List<Functionality> findAll();
	
	List<Functionality> findByRole_Name(String name);

}

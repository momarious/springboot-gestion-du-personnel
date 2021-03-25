package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Functionality;
import com.momarious.repository.FunctionalityRepository;
import com.momarious.service.contract.FunctionalityService;

@Service
public class FunctionalityServiceImpl implements FunctionalityService {

	@Autowired
	FunctionalityRepository functionalityRepository;

	@Override
	public List<Functionality> findAll() {
		// TODO Auto-generated method stub
		return functionalityRepository.findAll();
	}

	@Override
	public List<Functionality> findByRole_Name(String name) {
		// TODO Auto-generated method stub
		return functionalityRepository.findByRole_NameOrderByDisplayOrderAsc(name);
	}
	


}

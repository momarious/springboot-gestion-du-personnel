package com.momarious.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Role;
import com.momarious.repository.RoleRepository;
import com.momarious.service.contract.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).get();
	}

}

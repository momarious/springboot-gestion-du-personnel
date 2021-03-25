package com.momarious.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.Permission;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.PermissionRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return permissionRepository.findAll();
	}

	@Override
	public void save(Permission permission, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un permission pour l'employe, " + permission.getEmployee().getFirstname() + " " + permission.getEmployee().getLastname());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Permission");
		actionRepository.save(action);
		permissionRepository.save(permission);
	}

	@Override
	public List<Permission> findByEmployee_Id(Integer id) {
		// TODO Auto-generated method stub
		return permissionRepository.findByEmployee_Id(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		permissionRepository.deleteById(id);
	}

}
package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.Sanction;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.SanctionRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.SanctionService;

@Service
public class SanctionServiceImpl implements SanctionService {

	@Autowired
	SanctionRepository sanctionRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Sanction> findAll() {
		// TODO Auto-generated method stub
		return sanctionRepository.findAll();
	}

	@Override
	public void save(Sanction sanction, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté une sanction pour l'employe, " + sanction.getEmployee().getFirstname() + " " + sanction.getEmployee().getLastname());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Sanction");
		sanctionRepository.save(sanction);
	}

	@Override
	public List<Sanction> findByEmployee_Id(Integer id) {
		// TODO Auto-generated method stub
		return sanctionRepository.findByEmployee_Id(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		sanctionRepository.deleteById(id);
	}

}
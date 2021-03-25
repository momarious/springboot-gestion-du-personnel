package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.Function;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.FunctionRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	FunctionRepository functionRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Function> findAll() {
		// TODO Auto-generated method stub
		return functionRepository.findAll();
	}

	@Override
	public void save(Function function, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté une fonction, " + function.getDenomination());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Fonction");
		actionRepository.save(action);
		functionRepository.save(function);
	}

	@Override
	public Function findById(Integer id) {
		// TODO Auto-generated method stub
		return functionRepository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		functionRepository.deleteById(id);
	}

}

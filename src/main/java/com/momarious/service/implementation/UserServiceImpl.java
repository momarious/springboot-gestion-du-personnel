package com.momarious.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		return user;
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Action action = new Action();
		User user = userRepository.findById(id).get();
		action.setDenomination("L'utilisateur " + user.getUsername() + " a été supprimé");
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Utilisateurs");
		actionRepository.save(action);
		userRepository.deleteById(id);
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un nouvequ compte");
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Utilisateurs");
		actionRepository.save(action);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void edit(User user) {
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a modifié son mot de passe");
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Utilisateurs");
		actionRepository.save(action);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public String getPasswordById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.getPasswordById(id);
	}
}
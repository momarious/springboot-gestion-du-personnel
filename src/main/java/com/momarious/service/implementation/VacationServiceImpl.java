package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.User;
import com.momarious.model.Vacation;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.UserRepository;
import com.momarious.repository.VacationRepository;
import com.momarious.service.contract.VacationService;
import com.momarious.util.AppUtil;

@Service
public class VacationServiceImpl implements VacationService {

	@Autowired
	VacationRepository vacationRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Vacation> findAll() {
		// TODO Auto-generated method stub
		List<Vacation> list = vacationRepository.findAll();
		for (Vacation vacation : list) {
			vacation.setStartDateFrench(AppUtil.getDateFr(vacation.getStartDate()));
		}
		
		return list;
	}

	@Override
	public void save(Vacation vacation, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un congé pour l'employe, " + vacation.getEmployee().getFirstname() + " " + vacation.getEmployee().getLastname());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Conge");
		actionRepository.save(action);
		vacationRepository.save(vacation);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		vacationRepository.deleteById(id);
	}

}

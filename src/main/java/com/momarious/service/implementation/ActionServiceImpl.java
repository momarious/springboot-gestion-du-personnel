package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.repository.ActionRepository;
import com.momarious.service.contract.ActionService;
import com.momarious.util.AppUtil;

@Service
public class ActionServiceImpl implements ActionService {

	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public void save(Action action) {
		// TODO Auto-generated method stub
		actionRepository.save(action);
	}

	@Override
	public List<Action> findAll() {
		// TODO Auto-generated method stub
		List<Action> list = actionRepository.findAllByOrderByIdDesc();
		for (Action action : list) {
			action.setEffectiveDateFr(AppUtil.getDateTimeFr(action.getEffectiveDate()));
		}
		return list;
	}

}
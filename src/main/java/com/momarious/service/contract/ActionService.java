package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.Action;

public interface ActionService {
	
	void save(Action action);

	List<Action> findAll();

}

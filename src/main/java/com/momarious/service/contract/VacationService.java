package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.User;
import com.momarious.model.Vacation;

public interface VacationService {

	List<Vacation> findAll();

	void save(Vacation vacation, User user);

	void deleteById(Integer id);


}

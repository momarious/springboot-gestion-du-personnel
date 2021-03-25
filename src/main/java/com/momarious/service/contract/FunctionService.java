package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.Function;
import com.momarious.model.User;

public interface FunctionService {

	List<Function> findAll();

	void save(Function function, User user);

	Function findById(Integer parseInt);

	void deleteById(Integer id);
	

}

package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.Sanction;
import com.momarious.model.User;

public interface SanctionService {

	List<Sanction> findAll();

	void save(Sanction sanction, User user);

	List<Sanction> findByEmployee_Id(Integer id);

	void deleteById(Integer id);

}

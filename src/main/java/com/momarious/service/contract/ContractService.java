package com.momarious.service.contract;

import java.util.List;
import com.momarious.model.Contract;
import com.momarious.model.User;

public interface ContractService {

	void save(Contract contract, User user);
	
	List<Contract> findAll();

	Contract findByEmployee_Id(Integer id);

	void deleteById(Integer id);

	Contract findById(Integer id);


}

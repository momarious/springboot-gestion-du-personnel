package com.momarious.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.Contract;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.ContractRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractRepository contractRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public void save(Contract contract, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un  contrat");
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Contrat");
		actionRepository.save(action);
		contractRepository.save(contract);
	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		List<Contract> list = contractRepository.findAll();
		for (Contract contract : list) {
			int netSalary = contract.getBaseSalary() + contract.getHousingAllowance() + contract.getTransportationAllowance() + contract.getSeniorityBonus();
			contract.setNetSalary(netSalary );
		}
		return list;
	}

	@Override
	public Contract findByEmployee_Id(Integer id) {
		// TODO Auto-generated method stub
		return contractRepository.findByEmployee_Id(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		contractRepository.deleteById(id);
	}

	@Override
	public Contract findById(Integer id) {
		// TODO Auto-generated method stub
		return contractRepository.findById(id).get();
	}

}
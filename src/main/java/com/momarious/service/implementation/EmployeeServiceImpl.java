package com.momarious.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.Employee;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.EmployeeRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(Employee employee, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un  employé, " + employee.getFirstname() + " " + employee.getLastname());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Employee");
		actionRepository.save(action);
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee findByMatriculation(String matriculation) {
		// TODO Auto-generated method stub
		return employeeRepository.findByMatriculation(matriculation);
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email);
	}

	@Override
	public Long countByServiceDepartment_Id(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.countByServiceDepartment_Id(id);
	}

}
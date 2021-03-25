package com.momarious.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momarious.model.Action;
import com.momarious.model.ServiceDepartment;
import com.momarious.model.User;
import com.momarious.repository.ActionRepository;
import com.momarious.repository.EmployeeRepository;
import com.momarious.repository.ServiceDepartmentRepository;
import com.momarious.repository.UserRepository;
import com.momarious.service.contract.ServiceDepartmentService;

@Service
public class ServiceDepartmentServiceImpl implements ServiceDepartmentService {

	@Autowired
	ServiceDepartmentRepository serviceRepository;
	
	@Autowired 
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void save(ServiceDepartment service, User user) {
		// TODO Auto-generated method stub
		Action action = new Action();
		action.setDenomination("L'utilisateur " + user.getRole().getDenomination() + " a ajouté un Direction/Service, " + service.getName());
		action.setUser(userRepository.findByUsername(user.getUsername()));
		action.setExtension("Direction & Service");
		actionRepository.save(action);
		serviceRepository.save(service);
	}

	@Override
	public List<ServiceDepartment> findAll() {
		// TODO Auto-generated method stub
		List<ServiceDepartment> list = serviceRepository.findAll();
		for (ServiceDepartment serviceDepartment : list) {
			long numberOfEmployees = employeeRepository.countByServiceDepartment_Id(serviceDepartment.getId());
			serviceDepartment.setNumberOfEmployees(numberOfEmployees);
		}
		return list;
	}

	@Override
	public ServiceDepartment findById(int id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).get();
	}

	

}

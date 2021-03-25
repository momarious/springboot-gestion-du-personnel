package com.momarious.service.contract;

import java.util.List;
import com.momarious.model.ServiceDepartment;
import com.momarious.model.User;

public interface ServiceDepartmentService {

	void save(ServiceDepartment serviceDepartment, User user);
	
	List<ServiceDepartment> findAll();

	ServiceDepartment findById(int parseInt);

}

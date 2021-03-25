package com.momarious.service.contract;

import java.util.List;
import com.momarious.model.Employee;
import com.momarious.model.User;

public interface EmployeeService {

	void save(Employee employee, User user);

	List<Employee> findAll();

	Employee findById(Integer id);

	Employee findByMatriculation(String matriculation);

	Employee findByEmail(String email);

	Long countByServiceDepartment_Id(Integer id);
}

package com.momarious.service.contract;

import java.util.List;
import com.momarious.model.Permission;
import com.momarious.model.User;

public interface PermissionService {

	List<Permission> findAll();

	void save(Permission permission, User user);

	List<Permission> findByEmployee_Id(Integer id);

	void deleteById(Integer id);

}

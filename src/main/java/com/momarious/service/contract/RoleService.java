package com.momarious.service.contract;

import com.momarious.model.Role;

public interface RoleService {

	Role findByName(String name);

	Role findById(Integer parseInt);

}

package com.momarious.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momarious.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

	List<Permission> findByEmployee_Id(Integer id);

	
}

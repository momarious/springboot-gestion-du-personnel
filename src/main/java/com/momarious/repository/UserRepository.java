package com.momarious.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momarious.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);	
	
	@Query("select u.password from User u where u.id = :id")
	String getPasswordById(Integer id);

}

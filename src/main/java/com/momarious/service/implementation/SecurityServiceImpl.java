package com.momarious.service.implementation;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.momarious.service.contract.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String findLoggedInUsername() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} 
		return null;
	}

}

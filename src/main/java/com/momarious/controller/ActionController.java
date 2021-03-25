package com.momarious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momarious.model.User;
import com.momarious.service.contract.ActionService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;

@Controller
@RequestMapping("/action")
public class ActionController {
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@GetMapping
	public String action(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("actions", actionService.findAll());
		return "action/action";
	}
	
	
}
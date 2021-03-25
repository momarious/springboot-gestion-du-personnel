package com.momarious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momarious.model.Action;
import com.momarious.model.User;
import com.momarious.service.contract.ActionService;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.RoleService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	FunctionalityService functionalityService;

	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;
	
	@Autowired
	RoleService roleService;
		
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ActionService actionService;


	@GetMapping
	public String home(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		String home = userPrincipal.getRole().getHomePage();
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("users", userService.findAll());
		
		
		Action action = new Action();
		action.setDenomination("L'utilisateur " + userPrincipal.getRole().getName() + " s'est connecté");
		action.setUser(userPrincipal);
		action.setExtension("Utilisateurs");
	
		actionService.save(action );
		return home + "/" + home;
	}


}
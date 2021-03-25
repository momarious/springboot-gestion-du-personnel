package com.momarious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momarious.model.ServiceDepartment;
import com.momarious.model.User;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.RoleService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.ServiceDepartmentService;
import com.momarious.service.contract.UserService;

@Controller
@RequestMapping("/service")
public class ServiceDepartmentController {

	@Autowired
	ServiceDepartmentService serviceDepartmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String serviceDepartment(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("services", serviceDepartmentService.findAll());
		return "service/service";
	}
	
	@GetMapping("/add")
	public String addServiceDepartmentView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("service", new ServiceDepartment());
		return "service/add-service";
	}
	
	@PostMapping("/add")
	public String addServiceDepartmentAction(@ModelAttribute("service") @Validated ServiceDepartment service, Model model) {
	
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("services", serviceDepartmentService.findAll());
	
		serviceDepartmentService.save(service, userPrincipal);
		return "redirect:/service";
	}
	
}
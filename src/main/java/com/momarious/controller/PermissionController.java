package com.momarious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momarious.model.Employee;
import com.momarious.model.Permission;
import com.momarious.model.User;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.PermissionService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@GetMapping
	public String permission(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("permissions", permissionService.findAll());
		return "permission/permission";
	}
	
	/**
	 * Add permission
	 *
	 */
	
	@GetMapping("/add")
	public String addPermissionView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("permission", new Permission());
		return "permission/add-permission";
	}
	
	@PostMapping("/add")
	public String addPermissionAction(@ModelAttribute("permission") @Validated Permission permission, Model model) {
		Employee employee = employeeService.findByMatriculation(permission.getMatriculation());
		permission.setEmployee(employee);
		
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("permissions", permissionService.findAll());
	
		permissionService.save(permission, userPrincipal);
		return "redirect:/permission";
	}

	/**
	 * Delete permission
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String deletePermission(@PathVariable Integer id) {
		permissionService.deleteById(id);
		return "redirect:/permission";
	}
}
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
import com.momarious.model.Sanction;
import com.momarious.model.User;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.SanctionService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;

@Controller
@RequestMapping("/sanction")
public class SanctionController {

	@Autowired
	SanctionService sanctionService;
	
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
		model.addAttribute("sanctions", sanctionService.findAll());
		return "sanction/sanction";
	}
	
	@GetMapping("/add")
	public String addEmployeeView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("sanction", new Sanction());
		return "sanction/add-sanction";
	}
	
	@PostMapping("/add")
	public String addEmployeeAction(@ModelAttribute("sanction") @Validated Sanction sanction, Model model) {
		
		Employee employee = employeeService.findByMatriculation(sanction.getMatriculation());
		sanction.setEmployee(employee);
		
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("sanctions", sanctionService.findAll());
	
		sanctionService.save(sanction, userPrincipal);
		return "redirect:/sanction";
	}
	
	/**
	 * Delete Sanction
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String deleteContract(@PathVariable Integer id) {
		sanctionService.deleteById(id);
		return "redirect:/sanction";
	}
	
}
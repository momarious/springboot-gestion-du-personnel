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

import com.momarious.model.Function;
import com.momarious.model.User;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.RoleService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;

/**
 * @author acer
 *
 */
@Controller
@RequestMapping("/function")
public class FunctionController {

	@Autowired
	FunctionService functionService;

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
	public String function(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("functions", functionService.findAll());
		return "function/function";
	}

	@GetMapping("/add")
	public String addFunctionView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("function", new Function());
		return "function/add-function";
	}

	@PostMapping("/add")
	public String addFunctionAction(@ModelAttribute("function") @Validated Function function, Model model) {

		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("functions", functionService.findAll());

		functionService.save(function, userPrincipal);
		return "redirect:/function";
	}
	
	/**
	 * Delete function
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String deleteContract(@PathVariable Integer id) {
		functionService.deleteById(id);
		return "redirect:/function";
	}

}
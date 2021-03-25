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
import com.momarious.model.User;
import com.momarious.model.Vacation;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;
import com.momarious.service.contract.VacationService;

@Controller
@RequestMapping("/vacation")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@GetMapping
	public String vacation(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("vacations", vacationService.findAll());
		model.addAttribute("searchVacationForm", new Vacation());
		return "vacation/vacation";
	}
	
	@GetMapping("/add")
	public String addVacationView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("vacation", new Vacation());
		return "vacation/add-vacation";
	}
	
	@PostMapping("/add")
	public String addVacationAction(@ModelAttribute("vacation") @Validated Vacation vacation, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("vacations", vacationService.findAll());
		
		Employee employee = employeeService.findByMatriculation(vacation.getMatriculation());
		vacation.setEmployee(employee);
		
		vacationService.save(vacation, userPrincipal);
		return "redirect:/vacation";
	}
	
	/**
	 * Delete vacation
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String deleteVacation(@PathVariable Integer id) {
		vacationService.deleteById(id);
		return "redirect:/vacation";
	}

	/**
	 * Search vacation
	 *
	 */
	
	@PostMapping("/search")
	public String searchVacationView(@ModelAttribute("searchVacationForm") @Validated Vacation vacation, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("searchVacationForm", new Vacation());
		
		System.out.println(vacation);
		//result
		model.addAttribute("employees", employeeService.findAll());
		return "vacation/vacation";
	}
	
}
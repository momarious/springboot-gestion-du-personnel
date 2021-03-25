package com.momarious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momarious.form.ContractForm;
import com.momarious.model.Contract;
import com.momarious.model.User;
import com.momarious.service.contract.ContractService;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;
import com.momarious.validator.AddContractValidator;

@Controller
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserService userService;
	

	@Autowired
	SecurityService securityService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@Autowired
	AddContractValidator addContractValidator;

	/**
	 * Contract
	 *
	 */
	
	@GetMapping
	public String contract(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("contracts", contractService.findAll());
		
		return "contract/contract";
	}
	

	/**
	 * Add contract
	 *
	 */
	
	@GetMapping("/add")
	public String addContractView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("addContractForm", new ContractForm());
		
		return "contract/add-contract";
	}
	
	@PostMapping("/add")
	public String addContractAction(@ModelAttribute("addContractForm") @Validated Contract contract, Model model, BindingResult bindingResult) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		
		addContractValidator.validate(contract, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("employees", employeeService.findAll());
			return "contract/add-contract";	
		}
		contract.setEmployee(employeeService.findById(contract.getEmployeeID()));
		contractService.save(contract, userPrincipal);
		
		return "redirect:/contract";
	}
	

	/**
	 * Edit contract
	 *
	 */

	@GetMapping("/edit/{id}")
	public String editContractView(@PathVariable Integer id, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("contractForm", contractService.findById(id));
		model.addAttribute("employees", employeeService.findAll());
		
		return "contract/edit-contract";
	}
	
	@PostMapping("/edit")
	public String editContractAction(@ModelAttribute("contractForm") @Validated ContractForm form, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		
		Contract contract = contractService.findById(Integer.parseInt(form.getId()));
		contract.setNature(form.getNature());
		contract.setDuration(Integer.parseInt(form.getDuration()));
		contract.setBaseSalary(Integer.parseInt(form.getBaseSalary()));
		contract.setHousingAllowance(Integer.parseInt(form.getHousingAllowance()));
		contract.setSeniorityBonus(Integer.parseInt(form.getSeniorityBonus()));
		contract.setTransportationAllowance(Integer.parseInt(form.getTransportationAllowance()));

		contractService.save(contract, userPrincipal);
		return "redirect:/contract";
	}
		
	/**
	 * Delete contract
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String deleteContract(@PathVariable Integer id) {
		contractService.deleteById(id);
		return "redirect:/contract";
	}
}
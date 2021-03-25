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

import com.momarious.model.User;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.RoleService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.UserService;
import com.momarious.validator.AddUserValidator;
import com.momarious.validator.EditPasswordValidator;

@Controller
@RequestMapping("/user")
public class UserController {

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
	AddUserValidator addUserValidator;
	
	@Autowired
	EditPasswordValidator editPasswordValidator;

	@GetMapping
	public String viewUser(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("users", userService.findAll());
		return "user/user";
	}

	/**
	 * Add user
	 *
	 */

	@GetMapping("/add")
	public String viewAddUser(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("addUserForm", new User());

		return "user/add-user";
	}

	@PostMapping("/add")
	public String addUser(@ModelAttribute("addUserForm") @Validated User user, Model model, BindingResult bindingResult) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));

		addUserValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/add-user";	
		}
		
		user.setRole(roleService.findById(user.getRoleID()));		
		userService.save(user);
		return "redirect:/user";
	}

	/**
	 * Single user
	 *
	 */

	@GetMapping("/{id}")
	public String viewSingleUser(@PathVariable Integer id, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("user", userService.findById(id));
		return "user/single-user";
	}
	
	/**
	 * Edit user
	 *
	 */

	@GetMapping("/edit/{id}")
	public String viewEdit(@PathVariable Integer id, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("editPasswordForm", userService.findById(id));
		return "user/edit-user";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute("editPasswordForm") @Validated User userForm, Model model, BindingResult bindingResult) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("users", userService.findAll());
				
		editPasswordValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/edit-user";
		}
		
		userPrincipal.setPassword(userForm.getPassword());
		userService.edit(userPrincipal);
		return "redirect:/user";
	}
		
	/**
	 * Delete user
	 *
	 */
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.deleteById(id);
		return "redirect:/user";
	}
}
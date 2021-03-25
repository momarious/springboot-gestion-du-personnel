package com.momarious.controller;

import java.util.List;

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

import com.momarious.model.Contract;
import com.momarious.model.Employee;
import com.momarious.model.Permission;
import com.momarious.model.Sanction;
import com.momarious.model.User;
import com.momarious.service.contract.ContractService;
import com.momarious.service.contract.EmployeeService;
import com.momarious.service.contract.FunctionService;
import com.momarious.service.contract.FunctionalityService;
import com.momarious.service.contract.PermissionService;
import com.momarious.service.contract.RoleService;
import com.momarious.service.contract.SanctionService;
import com.momarious.service.contract.SecurityService;
import com.momarious.service.contract.ServiceDepartmentService;
import com.momarious.service.contract.UserService;
import com.momarious.validator.AddEmployeeValidator;
import com.momarious.validator.EditEmployeeValidator;

/**
 * @author acer
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceDepartmentService serviceDepartmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	SanctionService sanctionService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	PermissionService permissionService;
	
	@Autowired
	FunctionalityService functionalityService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FunctionService functionService;
	
	@Autowired
	AddEmployeeValidator addEmployeeValidator;
	
	@Autowired
	EditEmployeeValidator editEmployeeValidator;
	
	@GetMapping
	public String employeeView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		return "employee/employee";
	}
	
	@GetMapping("/add")
	public String addEmployeeView(Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("functions", functionService.findAll());
		model.addAttribute("services", serviceDepartmentService.findAll());
		model.addAttribute("addEmployeeForm", new Employee());
		return "employee/add-employee";
	}
	
	@PostMapping("/add")
	public String addEmployeeAction(@ModelAttribute("addEmployeeForm") @Validated Employee employee, Model model, BindingResult bindingResult) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		
		addEmployeeValidator.validate(employee, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("functions", functionService.findAll());
			model.addAttribute("services", serviceDepartmentService.findAll());
			return "employee/add-employee";	
		}
		
		employee.setServiceDepartment(serviceDepartmentService.findById(employee.getServiceID()));
		employee.setFunction(functionService.findById(employee.getFunctionID()));
		employeeService.save(employee, userPrincipal);
		return "redirect:/employee";
	}
	
	
	@GetMapping("/{id}")
	public String singleEmployeeView(@PathVariable Integer id, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		Employee employee = employeeService.findById(id);
		Contract contract = null;
		List<Permission> permissions = null;
		List<Sanction> sanctions = null;
		
		try {
			contract = contractService.findByEmployee_Id(employee.getId());
			permissions = permissionService.findByEmployee_Id(employee.getId());
			sanctions = sanctionService.findByEmployee_Id(employee.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("contract", contract);
		model.addAttribute("permissions", permissions);
		model.addAttribute("sanctions", sanctions);
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("employee", employee);
		
		return "employee/single-employee";
	}

	/**
	 * Modifier employee
	 *
	 */
	
	@GetMapping("/edit/{id}")
	public String editEmployeeView(@PathVariable Integer id, Model model) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		model.addAttribute("functions", functionService.findAll());
		model.addAttribute("services", serviceDepartmentService.findAll());
		model.addAttribute("editEmployeeForm", employeeService.findById(id));
		return "employee/edit-employee";
	}
	
	@PostMapping("/edit")
	public String editEmployeeAction(@ModelAttribute("editEmployeeForm") @Validated Employee employee, Model model, BindingResult bindingResult) {
		User userPrincipal = userService.findByUsername(securityService.findLoggedInUsername());
		model.addAttribute("home", userPrincipal.getRole().getHomePage());
		model.addAttribute("userPrincipal", userPrincipal);
		model.addAttribute("functionalities", functionalityService.findByRole_Name(userPrincipal.getRole().getName()));
		
		editEmployeeValidator.validate(employee, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("functions", functionService.findAll());
			model.addAttribute("services", serviceDepartmentService.findAll());
			return "employee/edit-employee";	
		}
		
		employee.setServiceDepartment(serviceDepartmentService.findById(employee.getServiceID()));
		employee.setFunction(functionService.findById(employee.getFunctionID()));
		employeeService.save(employee, userPrincipal);
		return "redirect:/employee";
	}
}
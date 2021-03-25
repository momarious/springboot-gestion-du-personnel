package com.momarious.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.momarious.model.Employee;
import com.momarious.service.contract.EmployeeService;

@Component
public class AddEmployeeValidator implements Validator {

	@Autowired
	EmployeeService employeeService;
	
	final private String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	final private String idcardnumberPattern = "^[0-9+ ]*$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee employee = (Employee)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matriculation", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeOfBirth", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeOfResidence", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellphone", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationalIdentificationNumber", "NotEmpty");
		
//		String matriculation = employee.getMatriculation();
//		System.out.println("heuha "+ matriculation);
//		System.out.println("heuha  " + employeeService.findByMatriculation(matriculation));
		
		if (!errors.hasFieldErrors("matriculation")) {
			if (employeeService.findByMatriculation(employee.getMatriculation()) != null)
				errors.rejectValue("matriculation", "Duplicate");		
		}
		
		if (!errors.hasFieldErrors("cellphone")) {
			if (!Pattern.matches(idcardnumberPattern, employee.getCellphone()))
				errors.rejectValue("cellphone", "Pattern");
		}
		
		if (!errors.hasFieldErrors("email")) {
			if (!Pattern.matches(emailPattern, employee.getEmail()))
				errors.rejectValue("email", "Pattern");
			if (employeeService.findByEmail(employee.getEmail()) != null)
				errors.rejectValue("email", "Duplicate");
		}
		
	}
}

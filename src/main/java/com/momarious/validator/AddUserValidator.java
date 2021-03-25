package com.momarious.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.momarious.model.User;
import com.momarious.service.contract.UserService;

@Component
public class AddUserValidator implements Validator {

	@Autowired
	UserService userService;
	
	final private String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
		
		if (!errors.hasFieldErrors("username")) {
			if (userService.findByUsername(user.getUsername()) != null)
				errors.rejectValue("username", "Duplicate");
			
			if (!Pattern.matches(emailPattern, user.getUsername()))
				errors.rejectValue("username", "Pattern");
		}
		
		if (!errors.hasFieldErrors("password"))
			if (user.getPassword().length() < 8 || user.getPassword().length() > 32)
				errors.rejectValue("password", "Size");

		if (!user.getPasswordConfirm().equals(user.getPassword()))
			errors.rejectValue("passwordConfirm", "Match");
		
	}

}

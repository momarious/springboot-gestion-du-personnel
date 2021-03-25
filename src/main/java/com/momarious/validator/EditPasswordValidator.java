package com.momarious.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.momarious.model.User;
import com.momarious.service.contract.UserService;

@Component
public class EditPasswordValidator implements Validator {

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		String rawPassword = user.getPasswordCurrent();
		String encodedPassword = userService.getPasswordById(user.getId());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordCurrent", "NotEmpty");
		
		if (!errors.hasFieldErrors("passwordCurrent")) {
			if (!bCryptPasswordEncoder.matches(rawPassword, encodedPassword))
				errors.rejectValue("passwordCurrent", "Match.editPasswordForm.passwordCurrent");			
		}
		
		if (!errors.hasFieldErrors("password")) {
			if (user.getPassword().length() < 8 || user.getPassword().length() > 32)
				errors.rejectValue("password", "Size.editPasswordForm.password");
		}

		if (!errors.hasFieldErrors("passwordConfirm")) {
			if (!user.getPasswordConfirm().equals(user.getPassword()))
			errors.rejectValue("passwordConfirm", "Match.editPasswordForm.passwordConfirm");
		}
	}
}

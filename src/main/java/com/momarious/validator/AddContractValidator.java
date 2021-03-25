package com.momarious.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.momarious.form.ContractForm;
import com.momarious.model.Contract;

@Component
public class AddContractValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Contract.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Contract contract = (Contract)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty");
		

			
			
	}

}

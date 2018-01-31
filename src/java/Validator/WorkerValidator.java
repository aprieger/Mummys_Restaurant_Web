/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import domain.Worker;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author syntel
 */
public class WorkerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Worker.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required");
                Worker worker = (Worker) target;
               
	}
}

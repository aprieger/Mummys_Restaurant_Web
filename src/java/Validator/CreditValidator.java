/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

/**
 *
 * @author LS5002117
 */


import domain.CreditCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class CreditValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CreditCard.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		CreditCard card = (CreditCard) target;	
	}

}
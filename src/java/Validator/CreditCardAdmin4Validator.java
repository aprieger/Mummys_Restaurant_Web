/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import domain.CreditCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author syntel
 */
public class CreditCardAdmin4Validator implements Validator {
    @Override
	public boolean supports(Class<?> clazz) {
            return true;
            //return CreditCard.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CreditCard card = (CreditCard) target;	
	}
}
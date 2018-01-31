/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import domain.Login;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LoginValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
	return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "loginId.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        Login login = (Login) target;
  
	}
}


package Validator;

import domain.Login;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 * Class created to validate user input while logging into system
 * 
 */ 
public class LoginValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
	return Login.class.isAssignableFrom(clazz);
    }
    
    // Method verifies the login fields have information entered
    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "loginId.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        Login login = (Login) target;
        
	}
}


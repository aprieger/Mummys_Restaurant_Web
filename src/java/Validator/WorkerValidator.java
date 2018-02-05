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
 *   This class will validate form input from the user for any worker
 * 
 */
public class WorkerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Worker.class.isAssignableFrom(clazz);
    }
        
    // Method to check input and return an error if incorrectly entered in some fields
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required");
        Worker worker = (Worker) target;
        // Checks phone number input to be ### ### #### or # ### ### ####        
        String regexStr = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        if (!(worker.getPhoneNumber().matches(regexStr))){
            errors.rejectValue("phoneNumber","phoneFormat.required");
        }
        // Checks if firstName field is greater than 1 character        
        if(worker.getFirstName().length() < 1){
            errors.rejectValue("firstName","nameLength.required");
        }
        // Checks if lastName field is greater than 1 character               
        if(worker.getLastName().length() < 1){
            errors.rejectValue("firstName","nameLength.required");
        }
               
    }
}

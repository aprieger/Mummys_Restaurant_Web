package Validator.Credit;

import domain.Credit.CreditCard;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CreditCardAdmin1Validator implements Validator {
    @Override
	public boolean supports(Class<?> clazz) {
            return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CreditCard card = (CreditCard) target;	
	}
}

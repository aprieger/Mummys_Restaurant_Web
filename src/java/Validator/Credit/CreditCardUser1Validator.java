package Validator.Credit;

import domain.Credit.CreditCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreditCardUser1Validator implements Validator {
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

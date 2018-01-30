package Validator;
import domain.CreditCard;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class CreditCardAdmin3Validator implements Validator {
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
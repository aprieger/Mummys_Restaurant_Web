package Validator;

import Model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import Service.PackageDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AdminPackageAddValidator implements Validator {
        private PackageDAO packageDAO;

        public void setpackageDAO(PackageDAO packageDAO) {
            this.packageDAO = packageDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return PkgOrder.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "quantity.required");
	}
}


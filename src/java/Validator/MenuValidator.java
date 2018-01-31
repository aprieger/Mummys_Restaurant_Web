package Validator;

import Model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import Service.PkgOrderDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MenuValidator implements Validator {
        private PkgOrderDAO pkgOrderDAO;

        public void setpackageDAO(PkgOrderDAO pkgOrderDAO) {
            this.pkgOrderDAO = pkgOrderDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return PkgOrder.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
            //check if the user has any open pkg orders
	}
}


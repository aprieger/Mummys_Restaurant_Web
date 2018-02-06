package Validator;

import Model.*;
import Service.*;
import Model.Package;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class PkgOrderValidator implements Validator {
        private PkgOrderDAO pkgOrderDAO;
        public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
            this.pkgOrderDAO = pkgOrderDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return PkgOrder.class.isAssignableFrom(clazz);
	}
        
	@Override
	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "pkgorder.quantity.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "packageId", "pkgorder.packageId.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderId", "pkgorder.orderId.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pricePerPkg", "pkgorder.pricePerPkg.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isOpen", "pkgorder.isOpen.required");
            PkgOrder pkgOrder = (PkgOrder) target;
            if (pkgOrder.getQuantity()<1)
                errors.reject("quantity", "pkgorder.quantity.minimum");
	}
}


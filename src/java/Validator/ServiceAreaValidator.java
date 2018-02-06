package Validator;

import Model.*;
import Service.*;
import Model.Package;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class ServiceAreaValidator implements Validator {
        private ServiceAreaDAO serviceAreaDAO;
        public void setServiceAreaDAO(ServiceAreaDAO serviceAreaDAO) {
            this.serviceAreaDAO = serviceAreaDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return PkgOrder.class.isAssignableFrom(clazz);
	}
        
	@Override
	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "servicearea.name.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "areaCode", "servicearea.quantity.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxRate", "servicearea.packageId.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "packageId", "servicearea.orderId.required");
	}
}


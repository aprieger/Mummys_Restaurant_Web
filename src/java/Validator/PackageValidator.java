package Validator;

import Model.*;
import Model.Package;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import Service.PackageDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class PackageValidator implements Validator {
        private PackageDAO packageDAO;

        public void setpackageDAO(PackageDAO packageDAO) {
            this.packageDAO = packageDAO;
        }
        
	@Override
	public boolean supports(Class<?> clazz) {
            return Package.class.isAssignableFrom(clazz);
	}
        
	@Override
	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "package.name.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "package.description.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mealCategory", "package.mealCategory.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imageSource", "package.imageSource.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mealType", "package.mealType.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isSpecial", "package.isSpecial.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "package.price.required");
	}
}


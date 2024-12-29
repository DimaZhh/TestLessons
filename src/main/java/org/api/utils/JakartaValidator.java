package org.api.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JakartaValidator {

    private static final ValidatorFactory factory = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory();

    private static final Validator validator = factory.getValidator();

    public static <T> void isValid(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Found constraint validation errors:\n");
            for (ConstraintViolation<T> violation : violations) {
                errorMessage.append(String.format(
                        "Property '%s' in class '%s' failed validation: %s (Value: %s)\n",
                        violation.getPropertyPath(),
                        violation.getRootBeanClass().getSimpleName(),
                        violation.getMessage(),
                        violation.getInvalidValue()
                ));
            }
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }
}

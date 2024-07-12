
package com.codegym.module4test.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
        import java.time.LocalDate;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = EndDateAfterStartDateValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EndDateAfterStartDate {

    String message() default "End date must be after start date by at least one day";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
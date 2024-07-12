package com.codegym.module4test.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class EndDateAfterStartDateValidator implements ConstraintValidator<EndDateAfterStartDate, LocalDate> {

    @Override
    public void initialize(EndDateAfterStartDate constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(LocalDate endDate, ConstraintValidatorContext context) {
        LocalDate startDate = endDate.minusDays(1); // Assuming the start date is one day before the end date
        return endDate.isAfter(startDate);
    }
}
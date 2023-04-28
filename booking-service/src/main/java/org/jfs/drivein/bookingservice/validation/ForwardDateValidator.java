package org.jfs.drivein.bookingservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ForwardDateValidator implements ConstraintValidator<ForwardDateValidation, String> {
    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        return localDate.isAfter(LocalDate.now());
    }
}

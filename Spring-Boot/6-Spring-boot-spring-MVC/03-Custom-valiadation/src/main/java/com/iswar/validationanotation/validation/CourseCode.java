package com.iswar.validationanotation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // Define Default Course Code
    public String value() default "LUV";

    // Define Default Error Message
    public String message() default "Must Start With LUV";

    // Define Default Groups
    public Class<?>[] groups() default {};

    // Define Default Payloads
    public Class<? extends Payload>[] payload() default {};
}

package de.lh39.springbootrestfilevalidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FileValidator.class})
public @interface ValidFile {
    String message() default "Invalid file";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Maximum allowed file size in megabytes.
     */
    long maxFileSize() default Long.MAX_VALUE;

    /**
     * Allowed file types/extensions.
     */
    String[] allowedFileTypes() default {};
}
package de.lh39.springbootrestfilevalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {
    private long maxFileSizeMB;
    private String[] fileTypes;

    @Override
    public void initialize(ValidFile constraintAnnotation) {
        this.maxFileSizeMB = constraintAnnotation.maxFileSize();
        this.fileTypes = constraintAnnotation.allowedFileTypes();
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return true; // no file present
        }

        if (!isSupportedContentType(multipartFile.getContentType())) {
            return false; // file type not supported
        }

        if (multipartFile.getSize() > maxFileSizeMB * 1024 * 1024) {
            return false; // file size exceeds limit
        }
        return true; // file is valid
    }

    private boolean isSupportedContentType(String contentType) {
        return Arrays.asList(this.fileTypes).contains(contentType);
    }
}

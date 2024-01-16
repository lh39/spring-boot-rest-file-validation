package de.lh39.springbootrestfilevalidation.upload;

import de.lh39.springbootrestfilevalidation.validation.ValidFile;
import de.lh39.springbootrestfilevalidation.validation.ValidFiles;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class UploadController {
    @PostMapping("/files")
    @ResponseStatus(HttpStatus.OK)
    public String createFile(
            @Validated
            @ValidFile(allowedFileTypes = ValidFiles.PDF_FILE_TYPE, maxFileSize = 1, message = "Only PDF file type allowed with maximum of 1 megabyte")
            @RequestPart("file") MultipartFile file) {
        return file.getOriginalFilename();
    }
}

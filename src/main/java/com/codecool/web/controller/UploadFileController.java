package com.codecool.web.controller;

import com.codecool.web.service.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UploadFileController {

	@Autowired
    S3Services s3Services;

    @PostMapping("/upload/{fileName}/{fileExtension}")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @PathVariable String fileName,
                                      @PathVariable String fileExtension) throws IOException {
    	String keyName = fileName + '.' + fileExtension;
		return s3Services.uploadFile(keyName, file);
    }
}

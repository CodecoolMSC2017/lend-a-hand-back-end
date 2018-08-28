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

    @PostMapping("/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) throws IOException {
    	String keyName = file.getOriginalFilename();
		return s3Services.uploadFile(keyName, file);
    }
}
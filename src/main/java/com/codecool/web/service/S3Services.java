package com.codecool.web.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public interface S3Services {
	ByteArrayOutputStream downloadFile(String keyName);
	String uploadFile(String keyName, MultipartFile file) throws IOException;
	List<String> listFiles();
}

package com.codecool.web.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface S3Services {
	ByteArrayOutputStream downloadFile(String keyName);
	void uploadFile(String keyName, MultipartFile file);
	List<String> listFiles();
}

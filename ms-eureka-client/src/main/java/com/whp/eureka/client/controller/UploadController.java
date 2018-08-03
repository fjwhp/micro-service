package com.whp.eureka.client.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {

		return file.getName();

	}

	@RequestMapping(value = "/junitTest")
	public String junitTest() {
		return "junttest";
	}
}

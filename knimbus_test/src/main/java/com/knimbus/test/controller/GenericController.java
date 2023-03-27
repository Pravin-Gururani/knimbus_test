package com.knimbus.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knimbus.test.service.GenericService;

@RestController
public class GenericController {
	
	@Autowired
	GenericService genericService;

	@GetMapping(value = "/getNextTenTrainDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllSurge() throws Exception {
		return genericService.getNextTenTrainDetails();
	}
}

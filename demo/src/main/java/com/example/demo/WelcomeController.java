package com.example.demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	private static Logger logger = LogManager.getLogger(WelcomeController.class);

	@GetMapping("/hello")
	public String welcome() {
		
		logger.info("Hello World");
		
		return "Hello World";
	}
	
}

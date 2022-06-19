package com.example.demo;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();//Configures Log4J

		SpringApplication.run(DemoApplication.class, args);
	}

}

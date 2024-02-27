package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
public class HelloworldApplication {
	private static Logger logger = LogManager.getLogger(HelloworldApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
		logger.info("HelloWorld Application started");
	}

}
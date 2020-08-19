package com.spring.logger.springlogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	Logger LOGGER = LoggerFactory.getLogger(RestController.class);

	@RequestMapping("/")
	public String helloWorld() {

		LOGGER.error("Error thrown while calling helloworld()");
		return "Hello World!";
	}

}

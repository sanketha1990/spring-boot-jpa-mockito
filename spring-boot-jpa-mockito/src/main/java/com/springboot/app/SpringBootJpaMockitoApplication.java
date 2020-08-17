package com.springboot.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.app.model.Person;
import com.springboot.app.repository.PersonDetailsRepository;

@SpringBootApplication
//@EntityScan("com.springboot.app.model")
//@EnableJpaRepositories("com.springboot.app.repository")
//@ComponentScan("com.springboot.app")
public class SpringBootJpaMockitoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJpaMockitoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMockitoApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(PersonDetailsRepository personDetailsRepository) {
		return (a) -> {
			personDetailsRepository.save(new Person("Samip", 30));
			personDetailsRepository.save(new Person("Samiksha", 28));
			personDetailsRepository.save(new Person("Samrat", 29));
			personDetailsRepository.save(new Person("Virat", 33));
			LOGGER.info("The sample data has been generated");
		};
	}

}

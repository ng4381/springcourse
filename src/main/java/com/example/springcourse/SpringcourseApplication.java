package com.example.springcourse;

import com.example.springcourse.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(SpringitProperties.class)
@SpringBootApplication
public class SpringcourseApplication {

	@Autowired
	private SpringitProperties springitProperties;

	private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringcourseApplication.class, args);
		System.out.println("Welcome to springit");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Welcome message: " + springitProperties.getWelcomeMsg());
			log.error("error");
			log.warn("warn");
			log.info("info");
			log.debug("debug");
			log.trace("trace");
		};
	}

}

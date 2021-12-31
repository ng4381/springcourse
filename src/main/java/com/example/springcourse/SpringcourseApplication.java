package com.example.springcourse;

import com.example.springcourse.config.SpringitProperties;
import com.example.springcourse.domain.Comment;
import com.example.springcourse.domain.Link;
import com.example.springcourse.repository.CommentRepository;
import com.example.springcourse.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@EnableConfigurationProperties(SpringitProperties.class)
//@EnableJpaAuditing
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
	PrettyTime prettyTime() {
		return new PrettyTime();
	}

	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

	/*
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

	@Bean
	CommandLineRunner runner2(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started with Spring Boot 2", "http://thre...");
			linkRepository.save(link);

			Comment comment = new Comment("This spring boot link is awesome!", link);
			commentRepository.save(comment);
			link.addComment(comment);

			System.out.println("We just inserted a link and a comment");
			System.out.println("=====================================");

		};
	}
	 */
}

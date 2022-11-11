package com.code.develop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AngelApiApplication {
	private static final Logger log =LoggerFactory.getLogger(AngelApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AngelApiApplication.class, args);
	}

	/*
	@Bean 
	public Docket getSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.code.develop"))
				.build();
				
	}
	*/

}

package com.jsp.ContactBookApp;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ContactBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookAppApplication.class, args);
	}

	@Bean
	public Docket contactApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jsp.ContactBookApp")).build().apiInfo(apiInfo());
	}
	
	public ApiInfo apiInfo()
	{
		return new ApiInfo("CONTACT BOOK APP", "its an contact book application.We can store , update , delete or retriev contact details", 
				"version 1.0v", "Terms of Service", 
				new Contact("Pooja", "https://www.java.com/en", 
						"pujapoo984@gmail.com"), "License url", "https://www.java.com/en",Collections.emptyList());
		
		
	}
	
}

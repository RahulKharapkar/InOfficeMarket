package com.rk.iom.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

// Access Swagger spec at http://localhost:8080/swagger-ui/index.html#/

@Configuration
public class OpenAPIConfiguration {

	@Value("${project.version}")
	private String projectVersion;

	@Bean
	public OpenAPI expenseAPI() {
		return new OpenAPI()
				.info(new Info().title("InOffice Marketplace")
						.description("in-house Marketplace for Employees who would like to seek or offer something, like finding PG or Selling phone/bike etc. Employees may offer/require help, product or service to/from others.")
						.version(projectVersion)
						 .contact(new Contact().name("Rahul Kharapkar").email("rahul.p.kharapkar@gmail.com").url("http://geekon99.wordpress.com")));
	}
}
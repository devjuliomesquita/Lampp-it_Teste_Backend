package com.api.crudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Teste Backend Lampp-it", version = "1.0", description = "CRUD de funcionários e teste de Array de strings.", license = @License(name = "Apache 2.0", url = "https://www.apache.org/licesen.html"), contact = @Contact(name = "Júlio C. Mesquita", email = "juliocesarmcamilo@gmail.com", url = "https://github.com/devjuliomesquita")))
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

}

package br.com.senai.sollaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Empresa", 
	version = "2.7.9", description = "CRUD para manter empresa",
	license = @License(name = "Pertencente: Sollaris Marketplace", url = "https://github.com/SENAIMARKETPLACE"),
	contact = @Contact(name = "Email da Empresa", email = "sollaris@gmail.com.br"),
	termsOfService = "Terms_Service"))
public class ApiEmpresaPrestadorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiEmpresaPrestadorApplication.class, args);
	}

}
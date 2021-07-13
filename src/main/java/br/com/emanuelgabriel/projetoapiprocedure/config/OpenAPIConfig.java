package br.com.emanuelgabriel.projetoapiprocedure.config;

import org.springdoc.webmvc.ui.SwaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		info = @Info(description = "API de gerenciamento e acesso a procedure", 
		termsOfService = "Termos de serviço",
title = "Projeto - API - Procedure", 
version = "1.0.0", 
contact = @Contact(name = "Emanuel Gabriel Sousa", email = "emanuel.gabriel.sousa@protonmail.com", url = "emanuelgabriel.github.io")))
public class OpenAPIConfig extends SwaggerConfig {

}

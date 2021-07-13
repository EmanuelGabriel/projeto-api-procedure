package br.com.emanuelgabriel.projetoapiprocedure.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Clientes", description = "Recurso de clientes")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteResource {

	
	
}

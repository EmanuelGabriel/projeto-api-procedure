package br.com.emanuelgabriel.projetoapiprocedure.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request.ClienteModelInputRequest;
import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.response.ClienteModelResponse;
import br.com.emanuelgabriel.projetoapiprocedure.services.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Tag(name = "Clientes", description = "Recurso de cliente")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteResourceImp {

	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteModelResponse>> getAll() {
		log.info("GET /v1/clientes");
		List<ClienteModelResponse> listClienteResponse = clienteService.getAll();
		return listClienteResponse != null ? ResponseEntity.ok().body(listClienteResponse)
				: ResponseEntity.ok().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteModelResponse> criar(@Valid @RequestBody ClienteModelInputRequest request) {
		log.info("POST /v1/clientes - body {}", request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCliente}")
				.buildAndExpand(request.getCpf()).toUri();
		return ResponseEntity.created(location).body(clienteService.criar(request));
	}

	@GetMapping(value = "{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteModelResponse> getById(@PathVariable Long idCliente) {
		log.info("GET /v1/clientes/{}", idCliente);
		ClienteModelResponse clientePorIdResponse = clienteService.getById(idCliente);
		return clientePorIdResponse != null ? ResponseEntity.ok().body(clientePorIdResponse)
				: ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> remover(@PathVariable Long idCliente) {
		log.info("DELETE /v1/clientes/{}", idCliente);
		if (clienteService.remover(idCliente)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

}

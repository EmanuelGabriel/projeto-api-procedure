package br.com.emanuelgabriel.projetoapiprocedure.resources.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.response.ClienteModelResponse;

public interface ClienteResourceService {

	public ResponseEntity<List<ClienteModelResponse>> getAll();

}

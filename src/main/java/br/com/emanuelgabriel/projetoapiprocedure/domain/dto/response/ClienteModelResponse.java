package br.com.emanuelgabriel.projetoapiprocedure.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModelResponse {

	private Long id;
	private String nome;

}

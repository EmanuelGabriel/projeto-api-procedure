package br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModelInputRequest {

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;

}

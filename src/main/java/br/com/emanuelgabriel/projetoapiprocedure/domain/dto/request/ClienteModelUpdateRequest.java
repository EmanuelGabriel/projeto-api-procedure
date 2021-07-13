package br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request;

import java.time.LocalDateTime;

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
public class ClienteModelUpdateRequest {

	private String nome;
	private String email;
	private String telefone;
	private LocalDateTime dataAtualizacao;

}

package br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Campo nome não pode ser vazio")
	private String nome;

	@Email(message = "Campo e-mail deve ser válido")
	private String email;

	@NotBlank(message = "Campo telefone não pode ser vazio")
	@Size(max = 10, message = "Campo telefone deve conter no máximo 10 dígitos")
	private String telefone;

}

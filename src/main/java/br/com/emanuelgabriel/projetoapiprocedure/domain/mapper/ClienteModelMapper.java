package br.com.emanuelgabriel.projetoapiprocedure.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request.ClienteModelInputRequest;
import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.response.ClienteModelResponse;
import br.com.emanuelgabriel.projetoapiprocedure.domain.entity.Cliente;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClienteModelMapper {

	private ModelMapper modelMapper;

	/**
	 * Método responsável pela conversão de entidade para DTO
	 * 
	 * @author emanuel.sousa
	 * @param entity
	 * @return dto
	 */
	public ClienteModelResponse entityToDTO(Cliente entity) {
		return this.modelMapper.map(entity, ClienteModelResponse.class);
	}

	/**
	 * Método responsável pela conversão de DTO para entidade
	 * 
	 * @author emanuel.sousa
	 * @param dto
	 * @return entity
	 */
	public Cliente dtoToEntity(ClienteModelInputRequest request) {
		return this.modelMapper.map(request, Cliente.class);
	}

	/**
	 * Método responsável pela conversão de DTO para entidade
	 * 
	 * @author emanuel.sousa
	 * @param dto
	 * @return entity
	 */
	public Cliente dtoToEntity(ClienteModelResponse dto) {
		return this.modelMapper.map(dto, Cliente.class);
	}

	/**
	 * Método responsável pela conversão List entidade para List dto
	 * 
	 * @author emanuel.sousa
	 * @param clientes
	 * @return clienteModelResponse
	 */
	public List<ClienteModelResponse> listEntityToDTO(List<Cliente> clientes) {
		return clientes.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	public List<ClienteModelResponse> mapPageDTO(Page<Cliente> clientes) {
		return clientes.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	public Page<ClienteModelResponse> mapEntityPageToDTO(Pageable pageable, Page<Cliente> pageCliente) {
		List<ClienteModelResponse> dtos = listEntityToDTO(pageCliente.getContent());
		return new PageImpl<>(dtos, pageable, pageCliente.getTotalElements());
	}

}

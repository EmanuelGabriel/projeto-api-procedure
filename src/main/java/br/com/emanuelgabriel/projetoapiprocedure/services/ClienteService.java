package br.com.emanuelgabriel.projetoapiprocedure.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.request.ClienteModelInputRequest;
import br.com.emanuelgabriel.projetoapiprocedure.domain.dto.response.ClienteModelResponse;
import br.com.emanuelgabriel.projetoapiprocedure.domain.entity.Cliente;
import br.com.emanuelgabriel.projetoapiprocedure.domain.mapper.ClienteModelMapper;
import br.com.emanuelgabriel.projetoapiprocedure.domain.repository.ClienteRepository;
import br.com.emanuelgabriel.projetoapiprocedure.services.exception.ObjNaoEncontradoException;
import br.com.emanuelgabriel.projetoapiprocedure.services.exception.RegraNegocioException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

	private static final String MSG_IMPOSSIVEL_REMOVER = "O cliente não pode ser removido, pois está em uso";

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteModelMapper clienteMapper;

	public List<ClienteModelResponse> getAll() {
		log.info("Busca todos os clientes");
		return this.clienteMapper.listEntityToDTO(clienteRepository.findAll());
	}

	@Transactional
	public ClienteModelResponse criar(ClienteModelInputRequest request) {
		log.info("Cria um cliente {}", request);

		Cliente cpfClienteExistente = this.clienteRepository.findByCpf(request.getCpf());
		if (cpfClienteExistente != null && !cpfClienteExistente.equals(request)) {
			throw new RegraNegocioException("Já existe cliente registrado com este CPF");
		}

		Cliente clienteSalvo = this.clienteMapper.dtoToEntity(request);
		clienteSalvo.setDataCadastro(LocalDateTime.now());

		return this.clienteMapper.entityToDTO(clienteRepository.saveAndFlush(clienteSalvo));

	}

	public ClienteModelResponse getById(Long idCliente) {
		log.info("Busca cliente por seu ID {}", idCliente);
		Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
		if (!clienteOpt.isPresent()) {
			throw new ObjNaoEncontradoException("Cliente de ID não encontrado");
		}

		return this.clienteMapper.entityToDTO(clienteOpt.get());
	}

	@Transactional
	public void remover(Long idCliente) {
		try {

			getById(idCliente);
			clienteRepository.deleteById(idCliente);
		} catch (Exception e) {
			throw new DataIntegrityViolationException(MSG_IMPOSSIVEL_REMOVER);
		}
	}

}

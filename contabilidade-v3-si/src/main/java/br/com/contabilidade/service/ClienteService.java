package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Cliente;
import br.com.contabilidade.repository.ClienteRepository;

@Service //Define a classe como um bean do Spring
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os clientes inseridos
	public List<Cliente> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um cliente a partir do ID
	public Optional<Cliente> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um cliente
	public Cliente save(@Valid Optional<Cliente> cliente) {
		return repository.saveAndFlush(cliente.get());
	}
	
	//Exclui um cliente
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

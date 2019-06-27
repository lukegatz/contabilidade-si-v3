package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Conta;
import br.com.contabilidade.repository.ContaRepository;

@Service //Define a classe como um bean do Spring
public class ContaService {
	
	@Autowired
	private ContaRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos as contas inseridas
	public List<Conta> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna uma conta a partir do ID
	public Optional<Conta> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza uma conta
	public Conta save(@Valid Optional<Conta> conta) {
		return repository.saveAndFlush(conta.get());
	}
	
	//Exclui uma conta
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

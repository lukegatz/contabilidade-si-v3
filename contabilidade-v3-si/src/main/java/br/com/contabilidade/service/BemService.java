package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Bem;
import br.com.contabilidade.repository.BemRepository;

@Service //Define a classe como um bean do Spring
public class BemService {
	
	@Autowired
	private BemRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os Bens inseridos
	public List<Bem> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um Bem a partir do ID
	public Optional<Bem> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um Bem
	public Bem save(@Valid Optional<Bem> bem) {
		return repository.saveAndFlush(bem.get());
	}
	
	//Exclui um Bem
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

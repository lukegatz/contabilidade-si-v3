package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.TipoPessoa;
import br.com.contabilidade.repository.TipoPessoaRepository;

@Service //Define a classe como um bean do Spring
public class TipoPessoaService {
	
	@Autowired
	private TipoPessoaRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os tipos de pessoas inseridas
	public List<TipoPessoa> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um tipo de pessoa a partir do ID
	public Optional<TipoPessoa> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um tipo de pessoa
	public TipoPessoa save(@Valid Optional<TipoPessoa> tipoPessoa) {
		return repository.saveAndFlush(tipoPessoa.get());
	}
	
	//Exclui um tipo de pessoa
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

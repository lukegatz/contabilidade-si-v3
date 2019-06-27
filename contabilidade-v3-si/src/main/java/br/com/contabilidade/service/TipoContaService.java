package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.TipoConta;
import br.com.contabilidade.repository.TipoContaRepository;

@Service //Define a classe como um bean do Spring
public class TipoContaService {
	
	@Autowired
	private TipoContaRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os tipos de contas inseridas
	public List<TipoConta> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um tipo de conta a partir do ID
	public Optional<TipoConta> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um tipo de conta
	public TipoConta save(@Valid Optional<TipoConta> tipoConta) {
		return repository.saveAndFlush(tipoConta.get());
	}
	
	//Exclui um tipo de conta
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

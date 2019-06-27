package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Lancamento;
import br.com.contabilidade.repository.LancamentoRepository;

@Service //Define a classe como um bean do Spring
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os lançamentos inseridos
	public List<Lancamento> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um lançamento a partir do ID
	public Optional<Lancamento> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um lançamento
	public Lancamento save(@Valid Optional<Lancamento> lance) {
		return repository.saveAndFlush(lance.get());
	}
	
	//Exclui um lançamento
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

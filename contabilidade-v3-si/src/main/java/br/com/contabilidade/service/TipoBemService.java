package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.TipoBem;
import br.com.contabilidade.repository.TipoBemRepository;

@Service //Define a classe como um bean do Spring
public class TipoBemService {
	
	@Autowired
	private TipoBemRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os tipos de bens inseridos
	public List<TipoBem> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um tipo de bem a partir do ID
	public Optional<TipoBem> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um tipo de bem
	public TipoBem save(@Valid Optional<TipoBem> tipoBem) {
		return repository.saveAndFlush(tipoBem.get());
	}
	
	//Exclui um tipo de bem
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

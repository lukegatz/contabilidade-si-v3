package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Depreciacao;
import br.com.contabilidade.repository.DepreciacaoRepository;

@Service //Define a classe como um bean do Spring
public class DepreciacaoService {
	
	@Autowired
	private DepreciacaoRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos as depreciações inseridas
	public List<Depreciacao> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna uma depreciação a partir do ID
	public Optional<Depreciacao> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza uma conta
	public Depreciacao save(@Valid Optional<Depreciacao> deprec) {
		return repository.saveAndFlush(deprec.get());
	}
	
	//Exclui uma conta
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

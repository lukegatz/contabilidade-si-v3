package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Telefone;
import br.com.contabilidade.repository.TelefoneRepository;

@Service //Define a classe como um bean do Spring
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos os telefones inseridos
	public List<Telefone> findAll() {
		return repository.findAll(); 
	}
	
	//Retorna um telefone a partir do ID
	public Optional<Telefone> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um telefone
	public Telefone save(@Valid Optional<Telefone> fone) {
		return repository.saveAndFlush(fone.get());
	}
	
	//Exclui um telefone
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

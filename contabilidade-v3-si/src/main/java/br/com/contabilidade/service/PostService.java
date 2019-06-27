package br.com.contabilidade.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabilidade.model.Post;
import br.com.contabilidade.repository.PostRepository;

@Service //Define a classe como um bean do Spring
public class PostService {
	
	@Autowired
	private PostRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos posts inseridos
	public List<Post> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um post a partir do ID
	public Optional<Post> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um post
	public Post save(@Valid Optional<Post> post) {
		return repository.saveAndFlush(post.get());
	}
	
	//Exclui um post
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

package br.com.contabilidade.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.contabilidade.model.Post;
import br.com.contabilidade.service.PostService;

@Controller //Define a classe como um bean do Spring
public class PostController {
	
	@Autowired
	private PostService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os posts
	@GetMapping("/posts")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", service.findAll());
		
		return mv;
	}
	
	//Vai para tela de adição de post
	@GetMapping("/posts/add")
	public ModelAndView add(Optional<Post> optional) {
		
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/posts/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um post por seu ID e redireciona para a tela principal
	@GetMapping("/posts/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/posts/save")
	public ModelAndView save(@Valid Optional<Post> post, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(post);
		}
		
		service.save(post);
		
		return findAll();
	}
	
}

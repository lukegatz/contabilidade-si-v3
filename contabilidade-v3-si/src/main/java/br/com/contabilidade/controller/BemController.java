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

import br.com.contabilidade.model.Bem;
import br.com.contabilidade.service.BemService;

@Controller //Define a classe como um bean do Spring
public class BemController {
	
	@Autowired
	private BemService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os Bens
	@GetMapping("/bem")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/bem");
		mv.addObject("bens", service.findAll());
		
		return mv;
	}
	
	//Obtém um bem por id
	@GetMapping("/bem/{id}")
	public Optional<Bem> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de bem
	@GetMapping("/bem/add")
	public ModelAndView add(Optional<Bem> optional) {
		
		ModelAndView mv = new ModelAndView("/bemAdd");
		mv.addObject("bem", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de bens (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/bem/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um bem por seu ID e redireciona para a tela principal
	@GetMapping("/bem/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/bem/save")
	public ModelAndView save(@Valid Optional<Bem> bem, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(bem);
		}
		
		service.save(bem);
		
		return findAll();
	}
	
}

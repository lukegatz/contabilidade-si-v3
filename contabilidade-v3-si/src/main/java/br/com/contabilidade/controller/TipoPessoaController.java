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

import br.com.contabilidade.model.TipoPessoa;
import br.com.contabilidade.service.TipoPessoaService;

@Controller //Define a classe como um bean do Spring
public class TipoPessoaController {
	
	@Autowired
	private TipoPessoaService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os Tipos de Pessoas
	@GetMapping("/tipoPessoa")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/tipoPessoa");
		mv.addObject("tipoPessoas", service.findAll());
		
		return mv;
	}
	
	//Obtém um tipo de pessoa por id
	@GetMapping("/tipoPessoa/{id}")
	public Optional<TipoPessoa> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de tipo de pessoa
	@GetMapping("/tipoPessoa/add")
	public ModelAndView add(Optional<TipoPessoa> optional) {
		
		ModelAndView mv = new ModelAndView("/tipoPessoaAdd");
		mv.addObject("tipoPessoa", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de tipos de pessoas (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/tipoPessoa/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um tipo de pessoa por seu ID e redireciona para a tela principal
	@GetMapping("/tipoPessoa/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/tipoPessoa/save")
	public ModelAndView save(@Valid Optional<TipoPessoa> tipoPessoa, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(tipoPessoa);
		}
		
		service.save(tipoPessoa);
		
		return findAll();
	}
	
}

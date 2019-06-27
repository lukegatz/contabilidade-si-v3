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

import br.com.contabilidade.model.Lancamento;
import br.com.contabilidade.service.LancamentoService;

@Controller //Define a classe como um bean do Spring
public class LancamentoController {
	
	@Autowired
	private LancamentoService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os lançamentos
	@GetMapping("/lanc")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/lanc");
		mv.addObject("lancs", service.findAll());
		
		return mv;
	}
	
	//Obtém o lançamento por id
	@GetMapping("/lanc/{id}")
	public Optional<Lancamento> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de lançamentos
	@GetMapping("/lanc/add")
	public ModelAndView add(Optional<Lancamento> optional) {
		
		ModelAndView mv = new ModelAndView("/lancAdd");
		mv.addObject("lanc", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de lançamento (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/lanc/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um lançamento por seu ID e redireciona para a tela principal
	@GetMapping("/lanc/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/lanc/save")
	public ModelAndView save(@Valid Optional<Lancamento> lanc, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(lanc);
		}
		
		service.save(lanc);
		
		return findAll();
	}
	
}

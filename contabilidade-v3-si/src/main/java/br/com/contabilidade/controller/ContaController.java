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

import br.com.contabilidade.model.Conta;
import br.com.contabilidade.service.ContaService;

@Controller //Define a classe como um bean do Spring
public class ContaController {
	
	@Autowired
	private ContaService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listadas todas as contas
	@GetMapping("/conta")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/conta");
		mv.addObject("contas", service.findAll());
		
		return mv;
	}
	
	//Obtém uma conta por id
	@GetMapping("/conta/{id}")
	public Optional<Conta> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de conta
	@GetMapping("/conta/add")
	public ModelAndView add(Optional<Conta> optional) {
		
		ModelAndView mv = new ModelAndView("/contaAdd");
		mv.addObject("conta", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de contas (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/conta/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui uma conta por seu ID e redireciona para a tela principal
	@GetMapping("/conta/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/conta/save")
	public ModelAndView save(@Valid Optional<Conta> conta, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(conta);
		}
		
		service.save(conta);
		
		return findAll();
	}
	
}

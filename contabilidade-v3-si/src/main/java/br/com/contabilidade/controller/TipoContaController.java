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

import br.com.contabilidade.model.TipoConta;
import br.com.contabilidade.service.TipoContaService;

@Controller //Define a classe como um bean do Spring
public class TipoContaController {
	
	@Autowired
	private TipoContaService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os Tipos de Contas
	@GetMapping("/tipoConta")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/tipoConta");
		mv.addObject("tipoContas", service.findAll());
		
		return mv;
	}
	
	//Obtém um tipo de conta por id
	@GetMapping("/tipoConta/{id}")
	public Optional<TipoConta> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de tipo de conta
	@GetMapping("/tipoConta/add")
	public ModelAndView add(Optional<TipoConta> optional) {
		
		ModelAndView mv = new ModelAndView("/tipoContaAdd");
		mv.addObject("tipoConta", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de tipos de contas (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/tipoConta/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um tipo de conta por seu ID e redireciona para a tela principal
	@GetMapping("/tipoConta/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/tipoConta/save")
	public ModelAndView save(@Valid Optional<TipoConta> tipoConta, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(tipoConta);
		}
		
		service.save(tipoConta);
		
		return findAll();
	}
	
}

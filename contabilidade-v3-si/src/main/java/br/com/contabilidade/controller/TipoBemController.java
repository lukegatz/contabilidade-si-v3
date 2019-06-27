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

import br.com.contabilidade.model.TipoBem;
import br.com.contabilidade.service.TipoBemService;

@Controller //Define a classe como um bean do Spring
public class TipoBemController {
	
	@Autowired
	private TipoBemService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os Tipos de Bens
	@GetMapping("/tipoBem")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/tipoBem");
		mv.addObject("tipoBens", service.findAll());
		
		return mv;
	}
	
	//Obtém um tipo de bem por id
	@GetMapping("/tipoBem/{id}")
	public Optional<TipoBem> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de tipo de bem
	@GetMapping("/tipoBem/add")
	public ModelAndView add(Optional<TipoBem> optional) {
		
		ModelAndView mv = new ModelAndView("/tipoBemAdd");
		mv.addObject("tipoBem", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de tipos de bens (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/tipoBem/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um tipo de bem por seu ID e redireciona para a tela principal
	@GetMapping("/tipoBem/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/tipoBem/save")
	public ModelAndView save(@Valid Optional<TipoBem> tipoBem, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(tipoBem);
		}
		
		service.save(tipoBem);
		
		return findAll();
	}
	
}

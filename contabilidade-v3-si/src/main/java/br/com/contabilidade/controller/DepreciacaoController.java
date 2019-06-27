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

import br.com.contabilidade.model.Depreciacao;
import br.com.contabilidade.service.DepreciacaoService;

@Controller //Define a classe como um bean do Spring
public class DepreciacaoController {
	
	@Autowired
	private DepreciacaoService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listadas todas as depreciações
	@GetMapping("/deprec")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/deprec");
		mv.addObject("deprecs", service.findAll());
		
		return mv;
	}
	
	//Obtém a depreciação por id
	@GetMapping("/deprec/{id}")
	public Optional<Depreciacao> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de depreciação
	@GetMapping("/deprec/add")
	public ModelAndView add(Optional<Depreciacao> optional) {
		
		ModelAndView mv = new ModelAndView("/deprecAdd");
		mv.addObject("deprec", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de depreciação (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/deprec/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui uma depreciação por seu ID e redireciona para a tela principal
	@GetMapping("/deprec/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/deprec/save")
	public ModelAndView save(@Valid Optional<Depreciacao> deprec, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(deprec);
		}
		
		service.save(deprec);
		
		return findAll();
	}
	
}

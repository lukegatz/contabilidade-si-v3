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

import br.com.contabilidade.model.Telefone;
import br.com.contabilidade.service.TelefoneService;

@Controller //Define a classe como um bean do Spring
public class TelefoneController {
	
	@Autowired
	private TelefoneService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os telefones
	@GetMapping("/telefone")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/telefone");
		mv.addObject("telefones", service.findAll());
		
		return mv;
	}
	
	//Obtém um telefone por id
	@GetMapping("/telefone/{id}")
	public Optional<Telefone> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de telefone
	@GetMapping("/telefone/add")
	public ModelAndView add(Optional<Telefone> optional) {
		
		ModelAndView mv = new ModelAndView("/foneAdd");
		mv.addObject("telefone", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de telefones (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/telefone/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um telefone por seu ID e redireciona para a tela principal
	@GetMapping("/telefone/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/telefone/save")
	public ModelAndView save(@Valid Optional<Telefone> fone, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(fone);
		}
		
		service.save(fone);
		
		return findAll();
	}
	
}

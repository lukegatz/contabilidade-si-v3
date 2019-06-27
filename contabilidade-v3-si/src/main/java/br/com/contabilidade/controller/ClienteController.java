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

import br.com.contabilidade.model.Cliente;
import br.com.contabilidade.service.ClienteService;

@Controller //Define a classe como um bean do Spring
public class ClienteController {
	
	@Autowired
	private ClienteService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os clientes
	@GetMapping("/cliente")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/cliente");
		mv.addObject("clientes", service.findAll());
		
		return mv;
	}
	
	//Obtém um cliente por id
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	//Vai para tela de adição de cliente
	@GetMapping("/cliente/add")
	public ModelAndView add(Optional<Cliente> optional) {
		
		ModelAndView mv = new ModelAndView("/clienteAdd");
		mv.addObject("cliente", optional.get());
		
		return mv;
	}
	
	//Vai para tela de edição de clientes (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/cliente/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um cliente por seu ID e redireciona para a tela principal
	@GetMapping("/cliente/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/cliente/save")
	public ModelAndView save(@Valid Optional<Cliente> cliente, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(cliente);
		}
		
		service.save(cliente);
		
		return findAll();
	}
	
}

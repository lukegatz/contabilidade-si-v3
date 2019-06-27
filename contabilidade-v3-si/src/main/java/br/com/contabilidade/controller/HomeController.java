package br.com.contabilidade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("relatorios")
	public String relatorios() {
		return "relatorios";
	}
	
	@GetMapping("relatorios/bp")
	public String balancoPatrimonial() {
		return "relatorios/bp";
	}
	
	@GetMapping("relatorios/dre")
	public String DRE() {
		return "relatorios/DRE";
	}
	
	@GetMapping("relatorios/razao")
	public String razao() {
		return "relatorios/razao";
	}
}

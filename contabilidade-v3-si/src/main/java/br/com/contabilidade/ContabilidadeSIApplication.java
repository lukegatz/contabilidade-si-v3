package br.com.contabilidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("br.com.contabilidade.repository")
@EntityScan("br.com.contabilidade.model")
@SpringBootApplication
public class ContabilidadeSIApplication {
	
	//Inicializa a aplicação
	public static void main(String[] args) {
		SpringApplication.run(ContabilidadeSIApplication.class, args);
	}
}

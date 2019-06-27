package br.com.contabilidade.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
@Entity(name = "tipo_pessoaDB") //Define o nome da tabela que será criada no banco de dados
public class TipoPessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected TipoPessoa() {}
	
	/**
	 * Construtor.
	 * 
	 * @param id_tipo_pessoa
	 * @param tipo
	 */
	public TipoPessoa(Long id_tipo_pessoa, String tipo) {
		super();
		this.id_tipo_pessoa = id_tipo_pessoa;
		this.tipo = tipo;
	}

	@Id
	@SequenceGenerator(name = "tipo_pessoa_seq", sequenceName = "tipo_pessoa_seq") 		//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_pessoa_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_tipo_pessoa;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Tipo da pessoa é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String tipo;
	
	// getters & setters
	public Long getId_tipo_pessoa() {
		return id_tipo_pessoa;
	}

	public void setId_tipo_bem(Long id_tipo_pessoa) {
		this.id_tipo_pessoa = id_tipo_pessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

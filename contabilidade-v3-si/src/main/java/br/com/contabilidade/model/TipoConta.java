package br.com.contabilidade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
@Entity(name = "tipo_contaDB") //Define o nome da tabela que será criada no banco de dados
public class TipoConta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected TipoConta() {}
	
	/**
	 * Construtor.
	 * 
	 * @param id_tipo_conta
	 * @param tipo
	 */
	public TipoConta(Long id_tipo_conta, String tipo) {
		super();
		this.id_tipo_conta = id_tipo_conta;
		this.tipo = tipo;
	}

	@Id
	@SequenceGenerator(name = "tipo_conta_seq", sequenceName = "tipo_conta_seq") 		//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_conta_seq") 	//Define que a tabela fará uso da sequence criada antes
	private Long id_tipo_conta;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Tipo da conta é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String tipo;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conta2_id_conta", nullable = false)
	private Conta conta2;
	
	// getters & setters
	public Long getId_tipo_conta() {
		return id_tipo_conta;
	}

	public void setId_tipo_conta(Long id_tipo_conta) {
		this.id_tipo_conta = id_tipo_conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

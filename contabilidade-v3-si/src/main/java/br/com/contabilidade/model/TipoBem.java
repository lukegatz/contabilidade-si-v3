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
@Entity(name = "tipo_bemDB") //Define o nome da tabela que será criada no banco de dados
public class TipoBem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected TipoBem() {}
	
	/**
	 * Construtor.
	 * 
	 * @param id_tipo_bem
	 * @param tipo
	 */
	public TipoBem(Long id_tipo_bem, String tipo) {
		super();
		this.id_tipo_bem = id_tipo_bem;
		this.tipo = tipo;
	}

	@Id
	@SequenceGenerator(name = "tipo_bem_seq", sequenceName = "tipo_bem_seq") 		//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_bem_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_tipo_bem;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Tipo do bem é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String tipo;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deprec_id_deprec", nullable = false)
	private Depreciacao deprec;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bem_id_bem", nullable = false)
	private Bem bem;
	
	// getters & setters
	public Long getId_tipo_bem() {
		return id_tipo_bem;
	}

	public void setId_tipo_bem(Long id_tipo_bem) {
		this.id_tipo_bem = id_tipo_bem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

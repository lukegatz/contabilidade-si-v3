package br.com.contabilidade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
@Entity(name = "bemDB") //Define o nome da tabela que será criada no banco de dados
public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Bem() {}
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_bem
	 * @param descricao
	 * @param tipo_bem
	 * @param valor
	 * @param documento
	 * @param data_cadastro
	 * @param chapa
	 */
	public Bem(Long id_bem, String descricao,
			TipoBem tipo_bem, Double valor,
			String documento, Date data_cadastro, String chapa) {
		super();
		this.id_bem = id_bem;
		this.descricao = descricao;
		this.tipo_bem = tipo_bem;
		this.valor = valor;
		this.documento = documento;
		this.data_cadastro = data_cadastro;
		this.chapa = chapa;
	}

	@Id	
	@SequenceGenerator(name = "bem_seq", sequenceName = "bem_seq") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bem_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_bem;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Descrição é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String descricao;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "bem")
	private TipoBem tipo_bem;
	
	@Column
	private Double valor;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Documento é uma informação obrigatória.")
	private String documento;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data_cadastro;
	
	@Column
	private String chapa;
	
	// chaves estrangeiras
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lanc_bem_id_lancamento", nullable = false)
	private Lancamento lanc_bem;

	public Long getId_bem() {
		return id_bem;
	}

	public void setId_bem(Long id_bem) {
		this.id_bem = id_bem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoBem getTipo_bem() {
		return tipo_bem;
	}

	public void setTipo_bem(TipoBem tipo_bem) {
		this.tipo_bem = tipo_bem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
}

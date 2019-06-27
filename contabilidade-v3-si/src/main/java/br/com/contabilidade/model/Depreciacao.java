package br.com.contabilidade.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "depreciacaoDB") //Define o nome da tabela que será criada no banco de dados
public class Depreciacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Depreciacao() {}
	
	/**
	 * Construtor.
	 * 
	 * @param id_deprec
	 * @param tipo_bem
	 * @param taxa
	 * @param vidaUtil
	 */
	public Depreciacao(Long id_deprec, TipoBem tipo_bem, Double taxa, Integer vidaUtil) {
		super();
		this.id_deprec = id_deprec;
		this.tipo_bem = tipo_bem;
		this.taxa = taxa;
		this.vidaUtil = vidaUtil;
	}

	@Id	
	@SequenceGenerator(name = "deprec_seq", sequenceName = "deprec_seq") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deprec_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_deprec;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "deprec")
	private TipoBem tipo_bem;
	
	@Column(nullable = false)
	private Double taxa;
	
	@Column(nullable = false)
	private Integer vidaUtil;

	// getters & setters
	public Long getId_deprec() {
		return id_deprec;
	}

	public void setId_deprec(Long id_deprec) {
		this.id_deprec = id_deprec;
	}

	public TipoBem getTipo_bem() {
		return tipo_bem;
	}

	public void setTipo_bem(TipoBem tipo_bem) {
		this.tipo_bem = tipo_bem;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Integer getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(Integer vidaUtil) {
		this.vidaUtil = vidaUtil;
	}
}

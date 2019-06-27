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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "lancamentoDB") //Define o nome da tabela que será criada no banco de dados
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Lancamento() {}
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_lancamento
	 * @param conta
	 * @param cliente
	 * @param bem
	 * @param valor
	 * @param data
	 * @param is_debito
	 * @param is_credito
	 */
	public Lancamento(Long id_lancamento, Conta conta, Cliente cliente, Bem bem, Double valor,
			Date data, boolean is_debito, boolean is_credito) {
		super();
		this.id_lancamento = id_lancamento;
		this.conta = conta;
		this.cliente = cliente;
		this.bem = bem;
		this.valor = valor;
		this.data = data;
		this.is_debito = is_debito;
		this.is_credito = is_credito;
	}

	@Id
	@SequenceGenerator(name = "lancamento_seq", sequenceName = "lancamento_seq") 		//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lancamento_seq") 	//Define que a tabela fará uso da sequence criada antes
	private Long id_lancamento;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "lanc_conta")
	private Conta conta;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "lanc_cli")
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "lanc_bem")
	private Bem bem;
	
	@Column
	private Double valor;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;
	
	@Column
	@Value("false")
	private boolean is_debito;
	
	@Column
	@Value("false")
	private boolean is_credito;
	
	// getters & setters
	public Long getId_lancamento() {
		return id_lancamento;
	}

	public void setId_lancamento(Long id_lancamento) {
		this.id_lancamento = id_lancamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isIs_debito() {
		return is_debito;
	}

	public void setIs_debito(boolean is_debito) {
		this.is_debito = is_debito;
	}

	public boolean isIs_credito() {
		return is_credito;
	}

	public void setIs_credito(boolean is_credito) {
		this.is_credito = is_credito;
	}
}

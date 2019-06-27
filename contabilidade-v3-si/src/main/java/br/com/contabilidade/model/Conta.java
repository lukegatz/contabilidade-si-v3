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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
@Entity(name = "contaDB") //Define o nome da tabela que será criada no banco de dados
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Conta() {}
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_conta
	 * @param id_cliente
	 * @param titulo
	 * @param tipo
	 * @param data_criacao
	 * @param valor_inicial
	 * @param is_imobilizado
	 * @param is_totalizadora
	 * @param nr_seq_01
	 * @param nr_seq_02
	 * @param nr_seq_03
	 * @param nr_seq_04
	 */
	public Conta(Long id_conta, Cliente cliente, String titulo, TipoConta tipo, Date data_criacao, Double valor_inicial,
			boolean is_imobilizado, boolean is_totalizadora, int nr_seq_01, int nr_seq_02, int nr_seq_03,
			int nr_seq_04) {
		super();
		this.id_conta = id_conta;
		this.cliente = cliente;
		this.titulo = titulo;
		this.tipo = tipo;
		this.data_criacao = data_criacao;
		this.valor_inicial = valor_inicial;
		this.is_imobilizado = is_imobilizado;
		this.is_totalizadora = is_totalizadora;
		this.nr_seq_01 = nr_seq_01;
		this.nr_seq_02 = nr_seq_02;
		this.nr_seq_03 = nr_seq_03;
		this.nr_seq_04 = nr_seq_04;
	}

	@Id
	@SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_conta;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "conta")
	private Cliente cliente;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Título é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String titulo;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "conta2")
	private TipoConta tipo;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data_criacao;
	
	@Column
	private Double valor_inicial;
	
	@Column
	@Value("false")
	private boolean is_imobilizado;
	
	@Column
	@Value("false")
	private boolean is_totalizadora;

	@Column
	private int nr_seq_01;

	@Column
	private int nr_seq_02;

	@Column
	private int nr_seq_03;

	@Column
	private int nr_seq_04;
	
	// chave estrangeira
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lanc_conta_id_lancamento", nullable = false)
	private Lancamento lanc_conta;
	
	// getters & setters
	public Long getId_conta() {
		return id_conta;
	}

	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Double getValor_inicial() {
		return valor_inicial;
	}

	public void setValor_inicial(Double valor_inicial) {
		this.valor_inicial = valor_inicial;
	}

	public boolean isIs_imobilizado() {
		return is_imobilizado;
	}

	public void setIs_imobilizado(boolean is_imobilizado) {
		this.is_imobilizado = is_imobilizado;
	}

	public boolean isIs_totalizadora() {
		return is_totalizadora;
	}

	public void setIs_totalizadora(boolean is_totalizadora) {
		this.is_totalizadora = is_totalizadora;
	}

	public int getNr_seq_01() {
		return nr_seq_01;
	}

	public void setNr_seq_01(int nr_seq_01) {
		this.nr_seq_01 = nr_seq_01;
	}

	public int getNr_seq_02() {
		return nr_seq_02;
	}

	public void setNr_seq_02(int nr_seq_02) {
		this.nr_seq_02 = nr_seq_02;
	}

	public int getNr_seq_03() {
		return nr_seq_03;
	}

	public void setNr_seq_03(int nr_seq_03) {
		this.nr_seq_03 = nr_seq_03;
	}

	public int getNr_seq_04() {
		return nr_seq_04;
	}

	public void setNr_seq_04(int nr_seq_04) {
		this.nr_seq_04 = nr_seq_04;
	}

}


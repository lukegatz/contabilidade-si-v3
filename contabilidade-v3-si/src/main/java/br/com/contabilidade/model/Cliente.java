package br.com.contabilidade.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

@SuppressWarnings("deprecation")
@Entity(name = "clienteDB") //Define o nome da tabela que será criada no banco de dados
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Cliente() {}
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_cliente
	 * @param nome
	 * @param cEP
	 * @param endereco
	 * @param numero
	 * @param bairro
	 * @param cidade
	 * @param estado
	 * @param cPF
	 * @param cNPJ
	 * @param telefone
	 * @param email
	 * @param tipo_pessoa
	 * @param is_CPF
	 * @param is_CNPJ
	 */
	public Cliente(Long id_cliente, String nome, Integer cEP,
			String endereco, String numero, String bairro, String cidade, String estado, Integer cPF, Integer cNPJ,
			Telefone telefone, String email, TipoPessoaENUM tipo_pessoa,
			boolean is_CPF, boolean is_CNPJ) { 
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		CEP = cEP;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		CPF = cPF;
		CNPJ = cNPJ;
		this.telefone = telefone;
		this.email = email;
		this.tipo_pessoa = tipo_pessoa;
		this.is_CPF = is_CPF;
		this.is_CNPJ = is_CNPJ;
	}

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_cliente;

	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Nome é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String nome;

	@Column(nullable = false)
	private Integer CEP;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	@Column
	private Integer CPF;

	@Column
	private Integer CNPJ;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.PERSIST,
            mappedBy = "cliente")
	private Telefone telefone;

	@Column(nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	private TipoPessoaENUM tipo_pessoa;

	@Column
	@Value("false")
	private boolean is_CPF;

	@Column
	@Value("false")
	private boolean is_CNPJ;
	
	// chaves estrangeiras
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conta_id_conta", nullable = false)
	private Conta conta;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lanc_cli_id_lancamento", nullable = false)
	private Lancamento lanc_cli;

	// getters & setters
	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCEP() {
		return CEP;
	}

	public void setCEP(Integer cEP) {
		CEP = cEP;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCPF() {
		return CPF;
	}

	public void setCPF(Integer cPF) {
		CPF = cPF;
	}

	public Integer getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {
		CNPJ = cNPJ;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoPessoaENUM getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(TipoPessoaENUM tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}

	public boolean isIs_CPF() {
		return is_CPF;
	}

	public void setIs_CPF(boolean is_CPF) {
		this.is_CPF = is_CPF;
	}

	public boolean isIs_CNPJ() {
		return is_CNPJ;
	}

	public void setIs_CNPJ(boolean is_CNPJ) {
		this.is_CNPJ = is_CNPJ;
	}
}

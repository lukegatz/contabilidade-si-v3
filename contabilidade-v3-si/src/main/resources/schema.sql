DROP TABLE IF EXISTS tbl_post;

CREATE TABLE IF NOT EXISTS tbl_post (
	id INT  NOT NULL PRIMARY KEY, 
	autor VARCHAR(150) NOT NULL, 
	titulo VARCHAR(150) NOT NULL,
	texto VARCHAR(MAX) NOT NULL,
	data TIMESTAMP NOT NULL
);


DROP TABLE IF EXISTS tipo_bemDB;

CREATE TABLE IF NOT EXISTS tipo_bemDB (
  id_tipo_bem INT NOT NULL PRIMARY KEY,
  tipo VARCHAR(30) NOT NULL
);


DROP TABLE IF EXISTS tipo_contaDB;

CREATE TABLE IF NOT EXISTS tipo_contaDB (
  id_tipo_conta INT NOT NULL PRIMARY KEY,
  tipo VARCHAR(30) NOT NULL
);


DROP TABLE IF EXISTS tipo_pessoaDB;

CREATE TABLE IF NOT EXISTS tipo_pessoaDB (
  id_tipo_pessoa INT NOT NULL PRIMARY KEY,
  tipo VARCHAR(30) NOT NULL
);


DROP TABLE IF EXISTS contaDB;

CREATE TABLE IF NOT EXISTS contaDB (
	id_conta INT  NOT NULL PRIMARY KEY,
	id_cliente INT NOT NULL,
	titulo VARCHAR(80) NOT NULL,
	tipo INT NOT NULL,
	data_criacao TIMESTAMP NOT NULL,
	valor_inicial NUMERIC(14,2),
	is_imobilizado BOOLEAN,
	is_totalizadora BOOLEAN,
	nr_seq_01 INT,
	nr_seq_02 INT,
	nr_seq_03 INT,
	nr_seq_04 INT
);


DROP TABLE IF EXISTS clienteDB;

CREATE TABLE IF NOT EXISTS clienteDB (
  id_cliente INT NOT NULL PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  CEP INT NOT NULL,
  endereco VARCHAR(40) NOT NULL,
  numero VARCHAR(8) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cidade VARCHAR(30) NOT NULL,
  estado CHAR(2) NOT NULL,
  CPF INT,
  CNPJ INT,
  id_telefone INT NOT NULL,
  email VARCHAR(30) NOT NULL,
  tipo CHAR(2) NOT NULL,
  is_CPF BOOLEAN,
  is_CNPJ BOOLEAN
);


DROP TABLE IF EXISTS telefoneDB;

CREATE TABLE IF NOT EXISTS telefoneDB (
  id_fone INT NOT NULL PRIMARY KEY,
  id_cliente VARCHAR(40) NOT NULL,
  tipo CHAR(12) NOT NULL, 
  numero INT,
  FOREIGN KEY(id_cliente) references clienteDB(id_cliente)
);


DROP TABLE IF EXISTS usuarioDB;

CREATE TABLE IF NOT EXISTS usuarioDB (
  id_usuario INT NOT NULL PRIMARY KEY,
  usuario VARCHAR(30) NOT NULL,
  senha VARCHAR(16)
);


DROP TABLE IF EXISTS bemDB;

CREATE TABLE IF NOT EXISTS bemDB (
  id_bem INT NOT NULL PRIMARY KEY,
  descricao VARCHAR(30) NOT NULL,
  tipo INT NOT NULL,
  valor NUMERIC(14,2) NOT NULL,
  documento VARCHAR(30),
  data_cadastro TIMESTAMP,
  chapa VARCHAR(8),
  FOREIGN KEY(tipo) references tipo_bemDB(id_tipo_bem)
);


DROP TABLE IF EXISTS lancamentoDB;

CREATE TABLE IF NOT EXISTS lancamentoDB (
  id_lancamento INT NOT NULL PRIMARY KEY,
  id_conta INT NOT NULL,
  id_cliente INT NOT NULL,
  id_bem INT,
  valor NUMERIC(14,2),
  data_lancamento TIMESTAMP NOT NULL,
  is_debito BOOLEAN,
  is_credito BOOLEAN,
  FOREIGN KEY(id_conta) references contaDB(id_conta),
  FOREIGN KEY(id_cliente) references clienteDB(id_cliente),
  FOREIGN KEY(id_bem) references bemDB(id_bem)
);


DROP TABLE IF EXISTS depreciacaoDB;

CREATE TABLE IF NOT EXISTS depreciacaoDB (
  id_deprec INT NOT NULL PRIMARY KEY,
  tipo INT NOT NULL,
  taxa NUMERIC(2),
  vida_util NUMERIC(2),
  FOREIGN KEY(tipo) references tipo_bemDB(id_tipo_bem)
);

-- SEQUENCES >>

DROP sequence IF EXISTS hibernate_sequence;
DROP sequence IF EXISTS conta_seq;
DROP sequence IF EXISTS cliente_seq;
DROP sequence IF EXISTS tipo_bem_seq;
DROP sequence IF EXISTS tipo_conta_seq;
DROP sequence IF EXISTS tipo_pessoa_seq;
DROP sequence IF EXISTS telefone_seq;
DROP sequence IF EXISTS usuario_seq;
DROP sequence IF EXISTS bem_seq;
DROP sequence IF EXISTS lancamento_seq;
DROP sequence IF EXISTS deprec_seq;

-- Teste das sequências

create sequence hibernate_sequence start with 1 increment by 1;
create sequence conta_seq start with 1 increment by 1;
create sequence cliente_seq start with 1 increment by 1;
create sequence tipo_bem_seq start with 1 increment by 1;
create sequence tipo_conta_seq start with 1 increment by 1;
create sequence tipo_pessoa_seq start with 1 increment by 1;
create sequence telefone_seq start with 1 increment by 1;
create sequence usuario_seq start with 1 increment by 1;
create sequence bem_seq start with 1 increment by 1;
create sequence lancamento_seq start with 1 increment by 1;
create sequence deprec_seq start with 1 increment by 1;
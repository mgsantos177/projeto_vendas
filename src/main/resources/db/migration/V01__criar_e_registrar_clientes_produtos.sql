CREATE TABLE if not exists clientes(
	id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	nome varchar(40) not null,
	cpf_cnpj varchar(15) not null unique,
	data_nasc DATE not null,
	sexo char not null 
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 


CREATE TABLE IF NOT EXISTS produtos(
	id BIGINT(10) PRIMARY KEY AUTO_INCREMENT, 
	nome varchar(100) not null,
	valor DECIMAL (6,2) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

CREATE TABLE if not exists vendas(
	id BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_cliente BIGINT(10) NOT NULL,
	id_produto BIGINT(20) NOT NULL,
	quant_produtos INT not null,
	valor_total DECIMAL(10,2),
	FOREIGN KEY (id_cliente) REFERENCES clientes(id),
	FOREIGN KEY (id_produto) REFERENCES produtos(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO CLIENTES (nome,cpf_cnpj,data_nasc, sexo) values ("Matheus Gonçalves","23640996844","1997-10-31","M");
INSERT INTO CLIENTES (nome,cpf_cnpj,data_nasc, sexo) values ("Douglas Gonçalves","25425715847","1991-03-05","M");
INSERT INTO CLIENTES (nome,cpf_cnpj,data_nasc, sexo) values ("Beatriz Candido","25158261582","1998-06-09","F");


INSERT INTO produtos(nome, valor) values("Curso Java O.O", 300.00);
INSERT INTO produtos(nome, valor) values("Python basico", 250.00);
INSERT INTO produtos(nome, valor) values("Java Basico", 200.00);
INSERT INTO produtos(nome, valor) values("Introdução a Banco de Dados", 200.00); 
INSERT INTO produtos(nome, valor) values("Html Basico", 100.00); 
INSERT INTO produtos(nome, valor) values("CSS E JAVA SCRIPT", 300.00); 
INSERT INTO produtos(nome, valor) values("Angular Basico", 500.00); 
INSERT INTO produtos(nome, valor) values("Spring Framework", 400.00); 
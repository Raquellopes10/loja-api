CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor_venda DOUBLE NOT NULL,
    marca VARCHAR(255),
    quantidade_estoque DOUBLE DEFAULT 0
);

CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE produto_categoria (
    produto_id INT,
    categoria_id INT,
    PRIMARY KEY (produto_id, categoria_id),
    FOREIGN KEY (produto_id) REFERENCES produtos (id),
    FOREIGN KEY (categoria_id) REFERENCES categorias (id)
);

CREATE TABLE estado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sigla VARCHAR(255) NOT NULL
);

CREATE TABLE cidade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    estado_id INT,
    FOREIGN KEY (estado_id) REFERENCES estado (id)
);

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cidade_id INT,
    FOREIGN KEY (cidade_id) REFERENCES cidade (id)
);

CREATE TABLE compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    data_compra TIMESTAMP NOT NULL,
    forma_pagamento VARCHAR(255) NOT NULL,
    valor_total DOUBLE DEFAULT 0,
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario_bruto DOUBLE NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE,
    cargo VARCHAR(255) NOT NULL,
    cidade_id INT,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255) NOT NULL,
    uf VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    FOREIGN KEY (cidade_id) REFERENCES cidade (id)
);

CREATE TABLE itens_compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    compra_id INT,
    quantidade INT NOT NULL,
    valor_unitario DOUBLE DEFAULT 0,
    valor_total DOUBLE DEFAULT 0,
    FOREIGN KEY (produto_id) REFERENCES produtos (id),
    FOREIGN KEY (compra_id) REFERENCES compra (id)
);

CREATE TABLE produto_imagem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    produto_id int,
    FOREIGN KEY (produto_id) REFERENCES produtos (id)
);



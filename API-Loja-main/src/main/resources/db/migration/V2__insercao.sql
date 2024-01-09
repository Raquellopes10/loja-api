INSERT INTO categorias (nome) VALUES
    ('Eletrônicos'),
    ('Roupas'),
    ('Livros');

INSERT INTO produtos (descricao, valor_venda, marca, quantidade_estoque) VALUES
    ('Smartphone', 999.99, 'Samsung', 50),
    ('Camiseta', 29.99, 'Nike', 100),
    ('Java: The Complete Reference', 49.99, 'Oracle Press', 30);

INSERT INTO estado (nome, sigla) VALUES
    ('São Paulo', 'SP'),
    ('Rio de Janeiro', 'RJ'),
    ('Minas Gerais', 'MG');

INSERT INTO cidade (nome, estado_id) VALUES
    ('São Paulo', 1),
    ('Rio de Janeiro', 2),
    ('Belo Horizonte', 3);

INSERT INTO cliente (nome, cpf, email, senha, cidade_id) VALUES
    ('João Silva', '123.456.789-01', 'joao@email.com', 'senha123', 1),
    ('Maria Oliveira', '987.654.321-01', 'maria@email.com', 'senha456', 2),
    ('Carlos Santos', '111.222.333-44', 'carlos@email.com', 'senha789', 3);

INSERT INTO compra (cliente_id, data_compra, forma_pagamento, valor_total) VALUES
    (1, '2023-01-15 10:30:00', 'Cartão de Crédito', 150.0),
    (2, '2023-02-20 15:45:00', 'Boleto Bancário', 200.0),
    (3, '2023-03-25 14:00:00', 'Transferência Bancária', 120.0);

INSERT INTO funcionario (nome, salario_bruto, data_entrada, data_saida, cargo, cidade_id, logradouro, numero, complemento, bairro, uf, cep, email, senha) VALUES
    ('Ana Pereira', 3000.0, '2022-05-10', NULL, 'Vendedor', 1, 'Rua A', '123', 'Apto 1', 'Centro', 'SP', '12345-678', 'ana@email.com', 'senha123'),
    ('Pedro Souza', 3500.0, '2021-08-20', '2023-01-05', 'Gerente', 2, 'Rua B', '456', 'Casa 2', 'Lapa', 'RJ', '54321-876', 'pedro@email.com', 'senha456'),
    ('Mariana Oliveira', 2800.0, '2023-02-15', NULL, 'Atendente', 3, 'Rua C', '789', 'Sala 3', 'Savassi', 'MG', '98765-432', 'mariana@email.com', 'senha789');

INSERT INTO itens_compra (produto_id, compra_id, quantidade, valor_unitario, valor_total) VALUES
    (1, 1, 2, 499.99, 999.98),
    (2, 2, 3, 29.99, 89.97),
    (3, 3, 1, 49.99, 49.99);

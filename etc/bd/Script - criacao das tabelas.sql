/* criacao das tabelas */

USE jailsys;

CREATE TABLE grupo (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(100) NOT NULL,
                        descricao VARCHAR(500));

CREATE TABLE pessoa (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(100) NOT NULL,
                        cpfCnpj VARCHAR(20) NOT NULL,
                        email VARCHAR(100) NOT NULL,
                        dataNasc DATE NOT NULL);

CREATE TABLE usuario (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
						login VARCHAR(100) NOT NULL, 
						senha VARCHAR(100) NOT NULL,
                        pessoa BIGINT NOT NULL,
                        grupo BIGINT NOT NULL,
                        ativo BOOL NOT NULL,
                        FOREIGN KEY FK_USUARIO_PESSOA (pessoa) REFERENCES pessoa(id),
                        FOREIGN KEY FK_USUARIO_GRUPO (grupo) REFERENCES grupo(id)); 
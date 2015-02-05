USE jailsys;
CREATE TABLE pessoa (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(100) NOT NULL,
                        cpf VARCHAR(20),
						email VARCHAR(100),
                        dataNasc DATETIME,
                        celular VARCHAR(15),
                        ativo BOOL NOT NULL);
                        
CREATE TABLE funcionario (id INT NOT NULL PRIMARY KEY,
							codigo VARCHAR(45) NOT NULL,
                            cargaHoraria TIME NOT NULL,
                            dataEntrada DATETIME NOT NULL,
                            horarioEntrada TIME NOT NULL,
                            FOREIGN KEY FK_FUNCIONARIO_PESSOA (id) REFERENCES pessoa(id));
                            
CREATE TABLE grupo (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(100) NOT NULL,
                        descricao BLOB NOT NULL);
                            
CREATE TABLE usuario (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						login VARCHAR(45) NOT NULL,
                        senha VARCHAR(45) NOT NULL,
                        pessoa INT NOT NULL,
                        grupo INT NOT NULL,
                        ativo BOOL NOT NULL,
                        FOREIGN KEY FK_USUARIO_PESSOA (pessoa) REFERENCES pessoa(id),
                        FOREIGN KEY FK_USUARIO_GRUPO (grupo) REFERENCES grupo(id));
                        
CREATE TABLE preso (id INT NOT NULL PRIMARY KEY,
						codigo VARCHAR(26) NOT NULL,
                        dataPrisao DATETIME NOT NULL,
                        dataSaida DATETIME,
                        FOREIGN KEY FK_PRESO_PESSOA (id) REFERENCES pessoa(id));
                        
CREATE TABLE ambiente (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
							nome VARCHAR(100) NOT NULL,
                            descricao BLOB NOT NULL,
                            lotacaoPessoas INT NOT NULL,
                            horarioInicio TIME NOT NULL,
                            horarioFim TIME NOT NULL,
                            severidade VARCHAR(45),
                            ativo BOOL NOT NULL);
                            
CREATE TABLE atividade (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
							nome VARCHAR(100) NOT NULL,
                            horarioInicio TIME NOT NULL,
                            horarioFim TIME NOT NULL,
                            ativo BOOL NOT NULL);
                            
CREATE TABLE atividadeAmbiente (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
									idAmbiente INT NOT NULL,
                                    idAtividade INT NOT NULL,
                                    FOREIGN KEY FK_AMBIENTE (idAmbiente) REFERENCES ambiente(id),
                                    FOREIGN KEY FK_ATIVIDADE (idAtividade) REFERENCES atividade(id));
                                    
CREATE TABLE pessoaAtividade (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
								idPessoa INT NOT NULL,
                                idAtividade INT NOT NULL,
                                FOREIGN KEY FK_PESSOA (idPessoa) REFERENCES pessoa(id),
								FOREIGN KEY FK_ATIVIDADE_PESSOA (idAtividade) REFERENCES atividade(id));
                                
CREATE TABLE visita (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        idPessoa INT NOT NULL,
                        idPreso INT NOT NULL,
                        horaInicio TIME NOT NULL,
                        duracao TIME NOT NULL,
                        FOREIGN KEY FK_VISITA_PESSOA (idPessoa) REFERENCES pessoa(id),
						FOREIGN KEY FK_VISITA_PRESO (idPreso) REFERENCES preso(id));
                        
CREATE TABLE crime (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(100) NOT NULL,
                        descricao BLOB NOT NULL);
                        
CREATE TABLE presoCrime (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
							idPreso INT NOT NULL,
                            idCrime INT NOT NULL,
                            FOREIGN KEY FK_CRIME (idCrime) REFERENCES crime(id),
							FOREIGN KEY FK_PRESO_CRIME (idPreso) REFERENCES preso(id));
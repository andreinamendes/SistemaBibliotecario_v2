CREATE OR REPLACE FUNCTION DEBITO(data_devo DATE) RETURNS REAL AS
	$body$
	DECLARE
	dias integer;
	dia_atual date;
	dia_devo date;
	debito real;
	BEGIN
		SELECT NOW() INTO dia_atual;
		dia_devo := $1;
		dias := dia_atual - dia_devo;
		
		IF(dias > 0) THEN
			debito := dias * 0.30;
		ELSE
			debito := 0.0;
		END IF;
		RETURN debito;
	END;
	$body$
	LANGUAGE 'plpgsql';
--DROP FUNCTION DEBITO;

CREATE TABLE usuario(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nasc DATE NOT NULL,
    rua VARCHAR(30) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL
);

CREATE TABLE telefone(
    id_usr INTEGER NOT NULL,
	ddd CHAR(2) NOT NULL,
    telefone VARCHAR(9) NOT NULL,
    FOREIGN KEY(id_usr) REFERENCES usuario(id)
);

CREATE TABLE servidor(
    siape INTEGER PRIMARY KEY,
    id_usr INTEGER NOT NULL,
    nivel_acc INTEGER NOT NULL,
    FOREIGN KEY(id_usr) REFERENCES usuario(id)
);

CREATE TABLE aluno(
    matricula INTEGER PRIMARY KEY,
    id_usr INTEGER NOT NULL,
    curso VARCHAR(30) NOT NULL,
    FOREIGN KEY(id_usr) REFERENCES usuario(id)
);

CREATE TABLE livro(
    num_acv INTEGER PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    edicao INTEGER NOT NULL,
    ano_lan VARCHAR(4) NOT NULL,
    qtd INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE unidade(
    num_reg INTEGER PRIMARY KEY,
    num_acv INTEGER NOT NULL,
    FOREIGN KEY(num_acv) REFERENCES livro(num_acv)
);

CREATE TABLE emprestimo(
	num_reg INTEGER NOT NULL PRIMARY KEY,
	matricula INTEGER NOT NULL,
    data_emp DATE NOT NULL,
    data_devo DATE NOT NULL,
    qtd_reno INTEGER NOT NULL DEFAULT 0,
    FOREIGN KEY(matricula) REFERENCES aluno(matricula),
    FOREIGN KEY(num_reg) REFERENCES unidade(num_reg)
);

CREATE TABLE reserva(
    matricula INTEGER NOT NULL,
    num_acv INTEGER NOT NULL,
    data_rsv DATE NOT NULL,
    FOREIGN KEY(matricula) REFERENCES aluno(matricula),
    FOREIGN KEY(num_acv) REFERENCES livro(num_acv),
    PRIMARY KEY(matricula, num_acv, data_rsv)
);

CREATE OR REPLACE VIEW debitos AS
SELECT num_reg, matricula, data_emp, data_devo, qtd_reno, DEBITO(data_devo) FROM emprestimo;
--DROP VIEW debitos;

CREATE OR REPLACE FUNCTION insertQtdAcv() RETURNS TRIGGER AS
	$body$
	DECLARE
	qtdAcv integer;
	BEGIN
		SELECT COUNT(new.num_acv) INTO qtdAcv 
		FROM unidade 
		WHERE num_acv = new.num_acv;
		
		UPDATE livro SET qtd = qtdAcv WHERE num_acv = new.num_acv;
		RETURN new;
	END;
	$body$
	LANGUAGE 'plpgsql';
--DROP FUNCTION insertQtdAcv;

CREATE TRIGGER trig_insQtdAcv
AFTER INSERT ON unidade
FOR EACH ROW EXECUTE PROCEDURE insertQtdAcv();
--DROP TRIGGER trig_insQtdAcv ON unidade;

CREATE OR REPLACE FUNCTION deleteQtdAcv() RETURNS TRIGGER AS
	$body$
	DECLARE
	qtdAcv integer;
	BEGIN
		SELECT COUNT(old.num_acv) INTO qtdAcv 
		FROM unidade 
		WHERE num_acv = old.num_acv;
		
		UPDATE livro SET qtd = qtdAcv WHERE num_acv = old.num_acv;
		RETURN old;
	END;
	$body$
	LANGUAGE 'plpgsql';
--DROP FUNCTION deleteQtdAcv;

CREATE TRIGGER trig_delQtdAcv
AFTER DELETE ON unidade
FOR EACH ROW EXECUTE PROCEDURE deleteQtdAcv();
--DROP TRIGGER trig_delQtdAcv ON unidade;

--INSERT DE DADOS--

--USUÁRIOS--

INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Maria Mendonca','1234','maria@gmail.com','12345678910','1987-06-28','Rua Pinto Damasceno','2255','Caninde','Ceara')
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Gregorio Neto','1234','gregorio@gmail.com','12345678911','1999-05-17','Avenida Bosques de Cabral','124','Crato','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Maria Emilia','1234','emilia@gmail.com','12345678912','2000-04-03','Rua Joao Pinto','36','Reboussas','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Ricado Alberto','1234','ricardo@gmail.com','12345678913','2001-05-06','Rua Aroldo Lopez','1258A','Sobral','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Roger Maciel','1234','roger@gmail.com','12345678914','1995-07-09','Rua Lucas Rosse','965','Quixada','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Gabriel Medeiros','1234','gabriel@gmail.com','12345678915','1976-02-10','Rua Sao Braz','645','Impueiras','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Galena Gonsalez','1234','galena@gmail.com','12345678916','1994-03-20','Rua Milho Assado','621','Fortaleza','Ceara');
INSERT INTO usuario (nome, senha, email, cpf, data_nasc, rua, numero, cidade, estado) VALUES ('Constantino Lopes','1234','constantino@gmail.com','12345678917','1993-09-27','Rua Mao de Vaca','879','Caridade','Ceara');

--ALUNOS--

INSERT INTO aluno (matricula, id_usr, curso) VALUES (001, 2, 'Engenharia de Computacao');
INSERT INTO aluno (matricula, id_usr, curso) VALUES (002, 3, 'Engenharia de Software');
INSERT INTO aluno (matricula, id_usr, curso) VALUES (003, 4, 'Ciencia da Computacao');
INSERT INTO aluno (matricula, id_usr, curso) VALUES (004, 5, 'Design Digital');
INSERT INTO aluno (matricula, id_usr, curso) VALUES (005, 7, 'Redes de Computadores');
INSERT INTO aluno (matricula, id_usr, curso) VALUES (006, 8, 'Sistemas de Informacao');

--SERVIDORES--
INSERT INTO servidor (siape, id_usr, nivel_acc) VALUES (001, 1, 3);
INSERT INTO servidor (siape, id_usr, nivel_acc) VALUES (002, 6, 3);


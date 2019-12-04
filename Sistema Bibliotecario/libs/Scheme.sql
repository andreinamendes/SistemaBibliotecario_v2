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
    telefone VARCHAR(20) NOT NULL,
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
    num_acv SERIAL PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    edicao INTEGER NOT NULL,
    ano_lan INTEGER NOT NULL,
    qtd INTEGER NOT NULL
);

CREATE TABLE unidade(
    num_reg VARCHAR(50) PRIMARY KEY,
    num_acv INTEGER NOT NULL,
    matricula INTEGER NOT NULL,
    data_emp DATE NOT NULL,
    data_devo DATE NOT NULL,
    qtd_reno INTEGER NOT NULL,
    FOREIGN KEY(num_acv) REFERENCES livro(num_acv),
    FOREIGN KEY(matricula) REFERENCES aluno(matricula)
);

CREATE TABLE reserva(
    matricula INTEGER NOT NULL,
    num_acv INTEGER NOT NULL,
    data_rsv DATE NOT NULL,
    FOREIGN KEY(matricula) REFERENCES aluno(matricula),
    FOREIGN KEY(num_acv) REFERENCES livro(num_acv),
    PRIMARY KEY(matricula, id_livro, data_rsv)
);

CREATE TABLE manipula(
    id SERIAL PRIMARY KEY,
    id_livro INTEGER NOT NULL,
    siape INTEGER NOT NULL,
    acao VARCHAR(200) NOT NULL,
    FOREIGN KEY(num_acv) REFERENCES livro(num_acv),
    FOREIGN KEY(siape) REFERENCES servidor(siape)
);
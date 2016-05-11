CREATE TABLE Professor
(
	idProf INTEGER NOT NULL AUTO_INCREMENT,
	nomeProf VARCHAR(60) NOT NULL,
    usuario VARCHAR(60) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    email VARCHAR(60) NOT NULL,
    PRIMARY KEY (idProf)
);

CREATE TABLE Aluno
(
	idAluno INTEGER NOT NULL AUTO_INCREMENT,
	nomeAluno VARCHAR(60) NOT NULL,
    CPF VARCHAR(20) NOT NULL,
    RA VARCHAR(20) NOT NULL,
    curso VARCHAR(35) NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    orientador INTEGER NOT NULL,
    PRIMARY KEY (idAluno),
    FOREIGN KEY (orientador) REFERENCES Professor(idProf)
);

CREATE TABLE TCC
(
	idTrabalho INTEGER NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(60) NOT NULL,
    resumo VARCHAR(500) NOT NULL,
    dataEntrega VARCHAR(20) NOT NULL,
    dataDefesa VARCHAR(35) NOT NULL,
    nota VARCHAR(20) NOT NULL,
    autor INTEGER NOT NULL,
    orientador INTEGER NOT NULL,
    PRIMARY KEY (idTrabalho),
    FOREIGN KEY (autor) REFERENCES Aluno(idAluno),
	FOREIGN KEY (orientador) REFERENCES Professor(idProf)
);


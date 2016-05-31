INSERT INTO Professor(nomeProf,usuario,senha,email) VALUES("Fabio Barros", "fabiobarros","1234","fbarros640@gmail.com" );
INSERT INTO Professor(nomeProf,usuario,senha,email) VALUES("João César", "jcesar","1234","jcesar@gmail.com" );
INSERT INTO Aluno(nomeAluno, CPF, RA, curso, periodo, orientador) VALUES ("José Silva","12313","21313","Eng. Computação","2",1);
INSERT INTO Aluno(nomeAluno, CPF, RA, curso, periodo, orientador) VALUES ("Pedro Souza","12313112","2133313","Engenharia de Computação","9",2);
SELECT * from Professor;
SELECT * from Aluno;
SELECT * from TCC;

DELETE FROM Professor;
DELETE FROM Aluno;
DELETE FROM TCC;

UPDATE Aluno SET nomeAluno="José Souza" WHERE idAluno = 1;
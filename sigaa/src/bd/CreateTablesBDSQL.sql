create schema sigaa;

create table curso (
codigoCurso int not null unique,
nome varchar(100),
primary key (codigoCurso));

create table fase (
codigoFase int not null unique,
ano int,
semestre int,
codigoCurso int,
primary key (codigoFase),
foreign key (codigoCurso) references curso(codigoCurso));

create table disciplina (
codigoDisciplina int not null unique,
nome varchar(30),
cargaHoraria int,
codigoFase int,
primary key (codigoDisciplina),
foreign key (codigoFase) references fase(codigoFase));

create table turma (
codigoTurma int not null unique,
dataInicio date,
situacaoTurma varchar(45),
codigoDisciplina int,
primary key (codigoTurma),
foreign key (codigoDisciplina) references disciplina(codigoDisciplina));

create table aluno (
matricula int not null unique,
nome varchar(100),
primary key (matricula));

create table professor (
registro int not null unique, 
nome varchar(100),
primary key (registro));

create table aula (
codigoAula int not null unique,
dataAula date,
cargaHoraria int,
codigoTurma int,
registro int,
primary key (codigoAula),
foreign key (codigoTurma) references turma(codigoTurma),
foreign key (registro) references professor(registro));

create table avaliacao (
codigoAvaliacao int not null unique,
dataAvaliacao date,
codigoTurma int,
registro int,
primary key (codigoAvaliacao),
foreign key (codigoTurma) references turma(codigoTurma),
foreign key (registro) references professor(registro));

create table alunoTurma (
codigoTurma int,
matricula int,
situacaoAluno varchar(20),
foreign key (codigoTurma) references turma(codigoTurma),
foreign key (matricula) references aluno(matricula));

create table alunoAula (
matricula int,
codigoAula int, 
compareceu int,
foreign key (matricula) references aluno(matricula),
foreign key (codigoAula) references aula(codigoAula));

create table alunoAvaliacao (
matricula int,
codigoAvaliacao int, 
nota double,
foreign key (matricula) references aluno(matricula),
foreign key (codigoAvaliacao) references avaliacao(codigoAvaliacao));

create table professorTurma (
codigoTurma int,
registro int,
foreign key (codigoTurma) references turma(codigoTurma),
foreign key (registro) references professor(registro));
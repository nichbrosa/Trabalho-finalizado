create database aplicacao;
use aplicacao;
select*from login;

create table login(
id integer not null auto_increment,
usuario varchar(50) not null,
senha varchar(50), 
primary key (id));

create table produtos(
id integer not null auto_increment,
nome varchar(20) not null,
qntd integer,
primary key (id));

insert into login (usuario, senha) values("Nicholas", 123);

insert into produtos (nome, qntd) values("Paracetamol", 15),
("Dopamina", 20),
("Estrogenio", 10),
("Barra de proteina", 5);



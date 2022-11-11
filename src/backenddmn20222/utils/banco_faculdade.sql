create database banco_faculdade ;
use banco_faculdade;

create table usuario( 
id int auto_increment primary key not null,
login varchar(25),
senha varchar(25), 
status_usuario varchar(25),
tipo varchar(25)
);

create table pessoa( 
id int auto_increment primary key not null,
nome varchar(50),
rg varchar(15),
cpf varchar(15)
);

create table usuario_pessoa( 
id int auto_increment primary key not null, 
id_usuario int, 
id_pessoa int,
observacao varchar(25),
CONSTRAINT fk_usuarioPessoa_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id),
CONSTRAINT fk_usuarioPessoa_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa (id)
);

create table logradouro( 
id int auto_increment primary key not null, 
endereco varchar(80), 
cep varchar(8),
numero int,
complemento varchar(25)
);

create table logradouro_pessoa( 
id int auto_increment primary key not null, 
id_logradouro int, 
id_pessoa int,
observacao varchar(25),
CONSTRAINT fk_logradouroPessoa_logradouro FOREIGN KEY (id_logradouro) REFERENCES logradouro (id),
CONSTRAINT fk_logradouroPessoa_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa (id)
);

create table contato( 
id int auto_increment primary key not null,
telefone varchar(13),
email varchar(50)
);

create table contato_pessoa( 
id int auto_increment primary key not null, 
id_contato int, 
id_pessoa int,
observacao varchar(25),
CONSTRAINT fk_contatoPessoa_contato FOREIGN KEY (id_contato) REFERENCES contato (id),
CONSTRAINT fk_contatoPessoa_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa (id)
);

select * from usuario;
select * from pessoa;
select * from usuario_pessoa;
select * from logradouro;
select * from logradouro_pessoa;
select * from contato;
select * from contato_pessoa;

insert into usuario (id, login, senha, status_usuario, tipo) VALUES (1, 'JHUS', 'ABC', 'Ativo', 'Admin');
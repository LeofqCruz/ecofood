create table cliente (
codigo int primary key,
nome varchar(255) not null,
email varchar(255) not null unique,
telefone varchar(20),
senha varchar(255) not null
);

create table produtor (
codigo int primary key,
nomeProdutor varchar(255) not null,
emailProdutor varchar(255) not null unique,
telefoneProdutor varchar(20),
senhaProdutor varchar(255) not null,
certificado varchar(255)
);

create table produto (
codigo int primary key,
nomeProduto varchar(255) not null,
preco float not null,
unidadeDeMedida varchar(50),
peso float not null,
qtde int not null,
codProdutor int,
foreign key (codProdutor) references produtor (codigo)
);

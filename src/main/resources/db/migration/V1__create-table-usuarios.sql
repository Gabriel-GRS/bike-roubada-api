create table usuarios(

    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null unique,
    numero_telefone varchar(20) not null,
    endereco varchar(255),
    cpf varchar(14) not null unique,
    idade int,
    sexo char(1) not null,

    primary key(id)

);
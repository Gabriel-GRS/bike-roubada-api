create table usuarios_login(

    id bigint not null auto_increment,
    login varchar(255) not null,
    senha varchar(255) not null unique,

    primary key(id)

);
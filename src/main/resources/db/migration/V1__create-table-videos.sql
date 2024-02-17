create table videos(

    id bigint not null auto_increment,
    titulo varchar(300) not null,
    descricao varchar(100) not null unique,
    url varchar(300) not null unique,

    primary key(id)

);
CREATE TABLE usuarios(
    id INTEGER not null auto_increment,
    login varchar(100) not null unique,
    senha varchar(255) not null,
    primary key(id)
);
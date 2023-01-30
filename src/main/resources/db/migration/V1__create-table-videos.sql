CREATE TABLE videos(
    id INTEGER not null,
    titulo varchar(255) not null,
    descricao varchar(255) not null,
    url varchar(700) not null unique,

    primary key(id)
);
create table game (
    id serial primary key,
    title varchar(300) not null unique,
    platform varchar(50) not null,
    finished boolean not null,
    rating smallint not null,
    genre varchar(50) not null,
    creation_date timestamp not null,
    updated_at timestamp not null
);

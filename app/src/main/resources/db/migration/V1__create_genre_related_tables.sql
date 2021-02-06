create table genre (
    id serial primary key,
    name varchar(50) not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);

create table rel_game_genre(
    id serial primary key,
    game_id bigint not null,
    genre_id bigint not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    constraint game_fk foreign key (game_id) references game(id),
    constraint genre_fk foreign key (genre_id) references genre(id)
);

insert into genre (name) values ('ACTION');
insert into genre (name) values ('ADVENTURE');
insert into genre (name) values ('RPG');
insert into genre (name) values ('SHOOTER');
insert into genre (name) values ('PUZZLE');
insert into genre (name) values ('RACING');
insert into genre (name) values ('SIMULATOR');

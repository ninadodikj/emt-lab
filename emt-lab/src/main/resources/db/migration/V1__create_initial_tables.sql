create table countries (
    id bigserial primary key,
    name varchar(255) not null,
    continent varchar(255) not null
);
create table authors(
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    country_id bigint references countries(id)
);
create table books(
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    category varchar(50) not null,
    author_id bigint references authors(id),
    state varchar(255) not null,
    available_copies integer not null
);
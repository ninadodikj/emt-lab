create table book_rent_activity(
    id bigserial primary key,
    book_id bigint not null,
    book_name varchar(255) not null,
    rented_at timestamp not null ,
    event_type varchar(255) not null
);


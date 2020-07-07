drop table if exists users cascade;
drop table if exists messages cascade;

create table users
(
    id   serial primary key,
    name varchar(255) not null
);

create table messages
(
    id   serial primary key,
    user_id  integer not null references users (id),
    text varchar(255) not null,
    created_at timestamp not null
);





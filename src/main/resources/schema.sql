drop table if exists users cascade;

create table users
(
    id   serial primary key,
    name varchar(255) not null
);





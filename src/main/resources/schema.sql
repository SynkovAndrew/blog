drop table if exists users cascade;
drop table if exists topics cascade;

create table users
(
    id   serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) not null,
    birthday date,
    created_at timestamp not null
);

create table topics
(
    id   serial primary key,
    user_id  integer not null references users (id),
    title varchar(100) not null,
    text varchar(255) not null,
    created_at timestamp not null
);





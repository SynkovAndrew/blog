drop table if exists authors cascade;
drop table if exists topics cascade;
drop table if exists comments cascade;
drop table if exists users cascade;
drop table if exists roles cascade;

create table users
(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);

create table roles
(
    id serial primary key,
    username varchar(50) not null,
    role varchar(50) not null,
    constraint fk_roles_users foreign key(username) references users(username)
);

create unique index ix_auth_username on roles (username, role);

create table authors
(
    id   serial primary key,
    username  varchar(50) not null references users (username),
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) not null,
    birthday date,
    created_at timestamp not null
);

create table topics
(
    id   serial primary key,
    author_id  integer not null references authors (id),
    title varchar(100) not null,
    text varchar(255) not null,
    created_at timestamp not null
);

create table comments
(
    id   serial primary key,
    author_id  integer not null references authors (id),
    topic_id  integer not null references topics (id),
    text varchar(255) not null,
    created_at timestamp not null
);



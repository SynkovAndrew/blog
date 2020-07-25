insert into users (username, password, enabled)
values ('morty', '$2y$12$X3p1fWZ/MCSfnFKBJxj.aeSbgJuZBWoepEMzBiwCUI7jl5rK6SIjK', true),
        ('rich', '$2y$12$X3p1fWZ/MCSfnFKBJxj.aeSbgJuZBWoepEMzBiwCUI7jl5rK6SIjK', true),
        ('mah', '$2y$12$X3p1fWZ/MCSfnFKBJxj.aeSbgJuZBWoepEMzBiwCUI7jl5rK6SIjK', true);

insert into roles (username, role)
values ('morty', 'REGISTERED_USER_ROLE'),
        ('rich', 'REGISTERED_USER_ROLE'),
        ('mah', 'REGISTERED_USER_ROLE');

insert into authors (id, username, first_name, last_name, email, birthday, created_at)
values (1, 'morty', 'Morty', 'Razen', 'mora@gmail.com', '1991-01-01', '2019-01-08 00:05:06'),
        (2, 'rich', 'Richard', 'Vagner','rivas@gmail.com', '1946-02-01', '2013-01-08 04:00:06'),
        (3, 'mah', 'Mahart', 'Towad', 'masdfg@gmail.com', '1992-03-03', '2016-01-08 00:00:01');

insert into topics (id, author_id, title, text, created_at)
values (1, 1, 'Hello everyone!', 'This is my first message here!', '2017-01-08 04:05:06'),
        (2, 1, 'Awesome!', 'Oh my god, how good it is!', '2018-01-08 15:05:06'),
        (3, 2, 'My first', 'Interesting site', '2019-01-08 13:05:12'),
        (4, 2, 'Weather','The weather is horrible', '2019-01-08 15:05:06');

insert into comments (id, author_id, topic_id, text, created_at)
values (1, 2, 1, 'Hi! Good to see you here!', '2019-01-08 04:05:06'),
        (2, 3, 1, 'Good boys!!!', '2018-01-08 15:01:06');
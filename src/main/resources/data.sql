insert into users (id, name)
values (1, 'morty'),
        (2, 'vagner');

insert into messages (id, user_id, text, created_at)
values (1, 1, 'This is my first message here!', '2017-01-08 04:05:06'),
        (2, 1, 'Oh my god, how good it is!', '2018-01-08 15:05:06'),
        (3, 2, 'Interesting site', '2019-01-08 13:05:12'),
        (4, 2, 'The weather is horrible', '2019-01-08 15:05:06');
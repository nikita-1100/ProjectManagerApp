INSERT INTO app_user(id, password, username)
VALUES (1, '$2a$12$.kEEDM293xIg.mNqEGbHd.WRv6OkGOZts5/eQY.uIX8isA8fsNavS', 'user'),
       (2, '$2a$12$.kEEDM293xIg.mNqEGbHd.WRv6OkGOZts5/eQY.uIX8isA8fsNavS', 'admin');

INSERT INTO user_role(user_id, role)
VALUES (1, 'USER'),(2,'ADMIN');

INSERT INTO projects( description, name, parent_id)
VALUES ('Develop application for Romashka company', 'Develop Romashka-CMS', null),
       ('Business logic development for Romashka company', 'Business logic development', 1),
       ('Technical implementation', 'Technical implementation', 1),
       ('Develop mobile application for Romashka company', 'Develop mobile application', 1);

INSERT INTO tasks(create_date, implementer_type, message, modify_date, status, author_id, project_id)
VALUES ('2023-04-11 20:00:11', 'MANAGER', 'To arrange meet with customers.', '2023-04-11 20:00:11', 'DONE', 1, 1),
       ('2023-04-11 20:01:11', 'MANAGER', 'To book meeting room', '2023-04-11 20:01:11', 'PROGRESS', 1, 1),
       ('2023-04-11 20:02:11', 'MANAGER', 'To invite customers', '2023-04-11 20:02:11', 'NEW', 1, 1),
       ('2023-04-11 20:03:11', 'MANAGER', 'To book meeting room', '2023-04-11 20:03:11', 'PROGRESS', 1, 1),
       ('2023-04-11 20:04:11', 'MANAGER', 'To ask customer for documentation.', '2023-04-11 20:04:11', 'NEW', 1, 2),
       ('2023-04-11 20:05:11', 'MANAGER', 'To change command for this project', '2023-04-11 20:05:11', 'NEW', 1, 2),
       ('2023-04-11 20:06:11', 'ENGINEER', 'To calculate system requirements', '2023-04-11 20:06:11', 'NEW', 1, 3),
       ('2023-04-11 20:07:11', 'ENGINEER', 'To change stack of technologies', '2023-04-11 20:07:11', 'DONE', 1, 3),
       ('2023-04-11 20:08:11', 'ENGINEER', 'To calculate amount of data', '2023-04-11 20:08:11', 'PROGRESS', 1, 3),
       ('2023-04-11 20:09:11', 'MANAGER', 'To find UX designer', '2023-04-11 20:09:11', 'DONE', 1, 4),
       ('2023-04-11 20:10:11', 'ENGINEER', 'To determine the feasibility of using Flutter', '2023-04-11 20:10:11', 'PROGRESS', 1, 4);



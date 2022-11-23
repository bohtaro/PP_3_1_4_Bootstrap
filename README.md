# PP_3_1_4_Bootstrap
INSERT INTO roles(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO users(id, age, email, first_name, last_name, password)   
VALUES (1, 45, 'admin@mail.ru', 'Admin', 'Adminov', '$2a$12$xP/1sbbo.GlHNyyniYkJIuUWEMP3qWgUVqo77vpvC5WQHYVQI4cAu'),
(2, 45, 'user@mail.ru', 'User', 'Userov', '$2a$12$xP/1sbbo.GlHNyyniYkJIuUWEMP3qWgUVqo77vpvC5WQHYVQI4cAu');

INSERT INTO users_roles(users_id, roles_id)
VALUES (1, 2),
(1, 1),
(2, 1);

login: admin@mail.ru password: 123
login: user@mail.ru password: 123

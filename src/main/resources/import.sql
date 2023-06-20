-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (2, '111.111.111-11', 'RM', 'rm', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (3, '222.222.222-22', 'Jin', 'jin', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (4, '333.333.333-33', 'Suga', 'suga', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (5, '444.444.444-44', 'J-Hope', 'jhope', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (6, '555.555.555-55', 'Jimin', 'jimin', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (7, '666.666.666-66', 'V', 'v', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

INSERT INTO usuario (id, cpf, nome, login, senha, sexo)
VALUES (8, '777.777.777-77', 'Jungkook', 'jungkook', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2); 

-- TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==

insert into estado (IdEstado, nomeEstado) values( 1,'Tocantins');
insert into estado (Idestado, nomeEstado) values( 2,'Goiás');
insert into estado (Idestado, nomeEstado) values( 3,'São Paulo');
insert into estado (Idestado, nomeEstado) values( 4,'Rio de Janeiro');
insert into estado (Idestado, nomeEstado) values( 5,'Pará');


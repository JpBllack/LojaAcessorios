-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into pessoa (nome) values('Michael Jackson');
insert into pessoa (nome) values('The Weekend');

insert into pessoafisica(id, cpf, sexo) values (1, '111.111.111-11', 1);
insert into pessoafisica(id, cpf) values (2, '222.222.222-22');


insert into usuario (login, senha, id_pessoa_fisica) values('Michael Jackson', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1);
insert into usuario (login, senha, id_pessoa_fisica) values('The Weekend', 'GU5e4piE62AOdQr2e5/r0In9A7OJ89TjYO0SxgzZysU5HyEtOo2uzOiH3xUqXEQXEWXQCTkB/LQeiS4m0bFs7w==', 2);

insert into estado (IdEstado, nomeEstado) values( 1,'Tocantins');
insert into estado (Idestado, nomeEstado) values( 2,'Goiás');
insert into estado (Idestado, nomeEstado) values( 3,'São Paulo');
insert into estado (Idestado, nomeEstado) values( 4,'Rio de Janeiro');
insert into estado (Idestado, nomeEstado) values( 5,'Pará');


insert into perfis (id_usuario, perfil) values (1, 'Admin');
insert into perfis (id_usuario, perfil) values (1, 'User');
insert into perfis (id_usuario, perfil) values (2, 'User');


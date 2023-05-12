-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into pessoa (nome) values('Michael Jackson');
insert into pessoa (nome) values('The Weekend');

insert into pessoafisica(id, cpf, sexo) values (1, '111.111.111-11', 1);
insert into pessoafisica(id, cpf) values (2, '222.222.222-22');




insert into estado (IdEstado, nomeEstado) values( 1,'Tocantins');
insert into estado (Idestado, nomeEstado) values( 2,'Goiás');
insert into estado (Idestado, nomeEstado) values( 3,'São Paulo');
insert into estado (Idestado, nomeEstado) values( 4,'Rio de Janeiro');
insert into estado (Idestado, nomeEstado) values( 5,'Pará');


insert into perfis (id_usuario, perfil) values (1, 'Admin');
insert into perfis (id_usuario, perfil) values (1, 'User');
insert into perfis (id_usuario, perfil) values (2, 'User');


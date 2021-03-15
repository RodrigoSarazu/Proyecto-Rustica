create database delivery_rustica;
use delivery_rustica;
select*from comida;
CREATE TABLE rol_rustica (
  id int(11) NOT NULL AUTO_INCREMENT primary key,
  user_id int(11) NOT NULL,
  rol varchar(45) NOT NULL,
  foreign key(user_id)references userrustica(user_id)
);
delete from comida where idcom=9;
INSERT INTO rol_rustica VALUES (1,1,'ROLE_USER'),
(2,2,'ROLE_USER'),(3,2,'ROLE_ADMIN');

use delivery_rustica;
select*from userrustica;
CREATE TABLE userrustica (
  user_id int(11) NOT NULL AUTO_INCREMENT ,
  username varchar(45) NOT NULL,
  password varchar(60) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY `username_UNIQUE` (username)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `userrustica` VALUES (1,'user','123'),(2,'admin','123');
/*Aqui se esta implementando los nuevos usuarios administradores*/

/*create table rol(
idrolusu int(11)not null primary key ,
nombre varchar(20)not null);

alter table rol_usuario
modify idrolusu int(11)not null auto_increment,auto_increment=5;
alter table rol_usuario
 add  column idusu int(11) not null;*/
 

use delivery_rustica;
select u.email,r.nombre from rol_usuario  r inner join usuario u on  r.idusu=u.idusu where u.email ="rodrigo@gmail.com";
use delivery_rustica;
select*from usuario;
select*from rol_usuario;

select idusu,email,password,fecha from usuario where idusu=1;

create table usuario(
idusu int(11) not null primary key,
email varchar(50) not null,
password varchar(200)not null,
fecha datetime not null,
UNIQUE KEY `email_UNIQUE` (email)
);
ALTER TABLE usuario
  MODIFY idusu int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

select*from usuario;
insert into usuario values(1,"rodrigo@gmail.com",123,current_timestamp());
insert into usuario values(2,"antonio@gmail.com",123,current_timestamp());

select*from usuario;
create table comida(
idcom int(11)not null primary key,
nombre varchar(50)not null,
precio double not null,
fecha datetime not null  
);
ALTER TABLE comida
MODIFY idcom int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
select*from comida;
insert into comida values (1,"Frejol con seco",20,current_timestamp());
insert into comida values (2,"Carapulcra con sopa seca",25,current_timestamp());
insert into comida values (3,"Arroz con pato",30,current_timestamp());
insert into comida values (4,"Lasana",45,current_timestamp());
insert into comida values (5,"Dúo Ravioles y salde tomate",60,current_timestamp());
insert into comida values (6,"Rocoto Relleno con pastel de papa",60,current_timestamp());
select*from comida;
/*
create table carrito(
idcarrito int(11)not null primary key,
idusu int(11) not null,
idcom int(11)not null,
cantidad int(11)not null,
foreign key(idusu)references usuario(idusu),
foreign key(idcom)references comida(idcom)
);


ALTER TABLE carrito
  MODIFY idcarrito int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
*/
/* esto va a ir a cambio del carrito*/

create table ticket(
idticket int(11) not null primary key, 
idusu int(11) not null,
idcom int(11) not null,
cantidad int(11) not null,
fechaped datetime not null,
fechaent datetime not null,
foreign key(idusu)references usuario(idusu),
foreign key(idcom)references comida(idcom)
);
ALTER TABLE ticket
  MODIFY idticket int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;




create table domicilio(
iddomicilio int(11)not null primary key,
idusu int(11)not null,
calle varchar(50)not null,
estado varchar(50)not null,
ciudad varchar(50)not null,
distrito varchar(30)not null,
foreign key(idusu)references usuario(idusu)
);
alter table domicilio
modify distrito varchar(30)not null;

ALTER TABLE domicilio
  MODIFY iddomicilio int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
select*from domicilio;

create table metodo_pago(
idmep int(11)not null primary key,
metodopago varchar(50)not null 
);
alter table metodo_pago
modify idmep int(11)not null auto_increment, auto_increment=5;

alter table metodo_pago change column nombre metodopago varchar(50);

insert into metodo_pago values(101,"credito");
insert into metodo_pago values(102,"paypal");
insert into metodo_pago values(103,"efectivo");
insert into metodo_pago values(104,"yape");
insert into metodo_pago values(105,"otro");
select*from metodo_pago;

create table orden_pago(
idord int(11)not null primary key,
idusu int(11)not null,
idmep int(11)not null,
total double not null,
iddomicilio int(11)not null,
foreign key(idusu)references usuario(idusu),
foreign key(idmep)references metodo_pago(idmep),
foreign key(iddomicilio)references domicilio(iddomicilio)
);
alter table orden_pago
modify idord int(11)not null auto_increment, auto_increment=5;

create table orden_detalle(
idordeta int(11)not null primary key,
idord int(11)not null,
idcom int(11)not null,
cantidad int(11)not null,
precio double not null,
foreign key(idord)references orden_pago(idord),
foreign key(idcom)references comida(idcom)
);
alter table orden_detalle
modify idordeta int(11)not null auto_increment, auto_increment=5;
select*from orden_detalle;
select*from usuario;
select*from carrito;

ALTER TABLE orden_detalle
  ADD CONSTRAINT orden_detalle_ibfk_1 FOREIGN KEY (idord) REFERENCES orden_pago (idord);
  
/*Alter table orden_detalle drop foreign key orden_detalle_ibfk_1;*/


create table compras(
idcomp int(11)not null AUTO_INCREMENT primary key,
idprov int(11)not null,
descripcion varchar(30)not null,
cantidad int(5)not null,
foreign key(idprov)references proveedor(idprov)
);
insert into compras values (1,1,"Paquete Arroz Costeña",4);
select*from compras;
alter table compras
change  descripción descripcion varchar(30);
create table detalle_compra(
iddetcomp int(11)not null AUTO_INCREMENT primary key,
idcomp int(11)not null ,
idcom int(11)not null ,
foreign key(idcomp)references compras(idcomp),
foreign key(idcom)references comida(idcom)
);

create table proveedor(
idprov int(11)not null AUTO_INCREMENT primary key,
nomprove varchar(50),
nombrecontac varchar(50),
telefono char(7),
direccion varchar(60),
codpostal char(5)
);
alter table proveedor 
rename column  codpostak to codpostal ;
select*from proveedor;
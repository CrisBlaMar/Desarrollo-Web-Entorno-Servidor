CREATE TABLE clinica(
identificador number(10),
direccion varchar2 (30),
nombre varchar2(15),
CONSTRAINT pk_clinica primary key (identificador)
);

CREATE TABLE cliente(
dni varchar2(9),
nombre varchar2(15) NOT NULL,
apellidos varchar2(30),
telefono varchar2(9),
direccion varchar2(30),
idClinica number(10),
CONSTRAINT pk_cliente primary key (dni),
CONSTRAINT fk_cliente foreign key (idClinica) references clinica (identificador)
);

CREATE TABLE mascota(
chip number(15),
nombre varchar2(10) NOT NULL,
raza varchar2(15),
pelaje varchar2(10),
sexo varchar2(1) default 'M',
dniCliente varchar2(9),
CONSTRAINT pk_mascota primary key (chip),
CONSTRAINT fk_mascota foreign key (dniCliente) references cliente (dni),
CONSTRAINT ck_mascota check ( sexo in ('H', 'M') )
);

CREATE TABLE veterinario(
dni varchar2(9),
nombre varchar2(15) NOT NULL,
apellidos varchar2(30),
telefono varchar2(9),
idenClinica number(10),
CONSTRAINT pk_veterinario primary key (dni),
CONSTRAINT fk_veterinario foreign key (idenClinica) references clinica (identificador)
);

---INSERT, UPDATE Y DELETE

---INSERT
---Insertamos una clínica de la franquicia
INSERT INTO clinica (identificador, nombre) values (12345, 'Canitas');


---Insertamos 5 clientes:
INSERT INTO cliente values ('12345678A', 'Carla', 'Ramos Remo', '623441523', 'Calle Amapola', 12345);
INSERT INTO cliente values ('12345678B', 'Juan', 'Caballero Martín', '658774539', 'Calle Manuel Ruiz', 12345);
INSERT INTO cliente values ('12345678C', 'Carlos', 'Vilches Caro', '600084956', 'Calle Tamarindo', 12345);
INSERT INTO cliente values ('12345678D', 'Andrea', 'Maestre Sánchez', '645309865', 'Calle Luis Tovar', 12345);
INSERT INTO cliente values ('12345678E', 'Miguel', 'Gea Conde', '643209908', 'Calle Tulipán', 12345);


---Insertamos 5 mascotas:
INSERT INTO mascota values (19284756, 'Rooney', 'mestizo', 'marrón', 'M', '12345678C');
INSERT INTO mascota values (19283333, 'Loli', 'yorksire', 'blanco', 'H', '12345678A');
---en este caso estamos probando que nos coja el valor por defecto en el sexo de la mascota:
INSERT INTO mascota (chip, nombre, raza, pelaje, dniCliente) values (23456896, 'Loki', 'mestizo', 'marrón', '12345678B');
INSERT INTO mascota values (23885938, 'Sami', 'siames', 'canela', 'H', '12345678D');
INSERT INTO mascota values (98746352, 'Drogo', 'pastor alemán', 'marrón', 'M', '12345678E');
INSERT INTO mascota values (23948585, 'Troy', 'pastor alemán', 'marrón', 'M', '12345678E');


---Insertamos 3 veterinarios:
INSERT INTO veterinario values ('11111111A', 'Cristina', 'Blanco Martín', '634885823', 12345);
INSERT INTO veterinario values ('11111111B', 'Adara', 'Santos Tora', '638556489', 12345);
INSERT INTO veterinario values ('11111111C', 'Mario', 'Rionegro López', '684557685', 12345);


---UPDATE
---Vamos a modificar el nombre de uno de los clientes:
update cliente set nombre='Cristina' where dni='12345678A';
---También modificaremos el número de teléfono de un veterinario:
update veterinario set telefono='655555555' where dni='11111111A';
--Vamos a modificar el nombre de una de la mascotas:
update mascota set nombre='Lola' where chip=19283333;
--Vamos a cambiar de propiertario a una de las mascotas:
update mascota set dniCliente='12345678C' where nombre='Lola';


---DELETE
---Vamos a borrar a un veterinario:
delete from veterinario where dni='11111111C';

commit;
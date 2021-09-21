---Ver el DNI de todos los clientes:
select distinct dni from CLIENTE;

---Nombre y apellidos de todos los clientes:
select nombre, apellidos from CLIENTE;

---Nombre de las mascotas con sexo 'H':
select nombre from MASCOTA where SEXO='H';

---Cantidad de mascotas con sexo 'M':
select count(chip) from MASCOTA where sexo='M';

---Nombre de la mascota con código 23885938:
select nombre from MASCOTA where CHIP=23885938;

---Mascotas que pertenecen al dni 12345678E:
select * from MASCOTA where DNICLIENTE='12345678E';
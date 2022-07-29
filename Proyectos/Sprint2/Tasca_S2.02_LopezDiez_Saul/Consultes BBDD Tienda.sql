/*BBDD Tienda. Consultes de 1 a la 17*/
SELECT nombre FROM tienda.producto;
SELECT nombre, precio FROM tienda.producto;
SELECT * FROM tienda.producto;
SELECT nombre, precio, precio*1.01 FROM tienda.producto;
SELECT nombre as 'nom de producto', precio as 'euros', precio*1.01 as 'dòlars' FROM tienda.producto;
SELECT upper(nombre) , precio FROM tienda.producto;
SELECT lower(nombre) , precio FROM tienda.producto;
SELECT nombre, upper(substring(nombre,1,2)) FROM tienda.fabricante;
SELECT nombre, round(precio) FROM tienda.producto;
SELECT nombre, truncate(precio,0) FROM tienda.producto;
SELECT a.codigo FROM tienda.fabricante a, tienda.producto b where a.codigo=b.codigo_fabricante
SELECT distinct a.codigo FROM tienda.fabricante a, tienda.producto b where a.codigo=b.codigo_fabricante
SELECT nombre FROM tienda.fabricante order by nombre ASC;
SELECT nombre FROM tienda.fabricante order by nombre desc;
SELECT nombre, precio FROM tienda.producto order by nombre asc, precio desc;
SELECT * FROM tienda.fabricante limit 5;
SELECT * FROM tienda.fabricante limit 2 offset 3;

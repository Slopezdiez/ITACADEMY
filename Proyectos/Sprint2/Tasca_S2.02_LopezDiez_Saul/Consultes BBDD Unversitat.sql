/*BBDD universidad, consultes 1er apartat. Consultes de 1 a la 7*/
SELECT apellido1, apellido2, nombre FROM universidad.persona where tipo='alumno' order by apellido1 asc, apellido2 asc, nombre asc;
SELECT apellido1, apellido2, nombre, telefono FROM universidad.persona where tipo='alumno' and telefono is null;
SELECT * FROM universidad.persona where tipo='alumno' and fecha_nacimiento between '1999-01-01' and '1999-12-31';
SELECT * FROM universidad.persona where tipo='profesor' and nif like '%K';
SELECT * FROM universidad.asignatura where cuatrimestre=1 and curso=3 and id_grado=7;
SELECT a.apellido1, a.apellido2, a.nombre, b.nombre  FROM universidad.persona a, universidad.departamento b, universidad.profesor c where a.tipo='profesor' and a.id=c.id_profesor order by a.apellido1 asc, a.apellido2 asc, a.nombre asc;
SELECT distinct a.nombre, d.anyo_inicio, d.anyo_fin FROM universidad.asignatura a, universidad.persona b, universidad.alumno_se_matricula_asignatura c, universidad.curso_escolar d where b.nif='26902806M' and b.id=c.id_alumno and d.id=c.id_curso_escolar;
/*consultes utilitzant les clàusules LEFT JOIN i RIGHT JOIN. Consultes de 1 a la 5*/
SELECT  universidad.departamento.nombre, a.apellido1, a.apellido2, a.nombre  from universidad.persona a left join universidad.profesor  on a.id = universidad.profesor.id_profesor left join universidad.departamento on universidad.profesor.id_departamento = universidad.departamento.id order by universidad.departamento.nombre asc, a.apellido1 asc, a.apellido2 asc, a.nombre asc;
SELECT  universidad.departamento.nombre, a.apellido1, a.apellido2, a.nombre  from universidad.persona a left join universidad.profesor  on a.id = universidad.profesor.id_profesor left join universidad.departamento on universidad.profesor.id_departamento = universidad.departamento.id  where universidad.departamento.nombre is null order by universidad.departamento.nombre asc, a.apellido1 asc, a.apellido2 asc, a.nombre asc;
SELECT  a.nombre, universidad.profesor.id_profesor  from universidad.departamento a left join universidad.profesor  on a.id = universidad.profesor.id_departamento where universidad.profesor.id_profesor is null;
select a.nombre from universidad.persona a left join universidad.asignatura on a.id = universidad.asignatura.id_profesor where a.tipo = 'profesor'and universidad.asignatura.nombre is null;
select * from universidad.asignatura a where a.id_profesor is null;
/*Consultes resum. Consultes de 1 a la 11 */
SELECT  count(a.nombre) as 'nombre Alumnes' from universidad.persona a where a.tipo='alumno';
SELECT  count(a.nombre) as 'nombre Alumnes' from universidad.persona a where a.tipo='alumno' and a.fecha_nacimiento between '1999-01-01' and '1999-12-31';
SELECT  universidad.departamento.nombre, count(a.nombre) from universidad.persona a left join universidad.profesor  on a.id = universidad.profesor.id_profesor left join universidad.departamento on universidad.profesor.id_departamento = universidad.departamento.id where universidad.departamento.nombre is not null  group by universidad.departamento.nombre order by universidad.departamento.nombre desc;
SELECT  a.nombre, count(universidad.profesor.id_profesor) as 'nombre professors' from universidad.departamento a left join universidad.profesor  on a.id = universidad.profesor.id_departamento group by a.nombre;
SELECT a.nombre, count(universidad.asignatura.nombre) FROM universidad.grado a join universidad.asignatura on a.id=universidad.asignatura.id_grado group by a.nombre;
SELECT a.nombre, count(universidad.asignatura.nombre) as 'assignatures' FROM universidad.grado a join universidad.asignatura on a.id=universidad.asignatura.id_grado group by a.nombre having count(universidad.asignatura.nombre)>40;
SELECT a.nombre, universidad.asignatura.tipo, sum(universidad.asignatura.creditos) as creditos FROM universidad.grado a join universidad.asignatura on a.id=universidad.asignatura.id_grado group by a.nombre, universidad.asignatura.tipo ;
SELECT  b.anyo_inicio, count(a.id_alumno) as 'alumnos' FROM universidad.alumno_se_matricula_asignatura a join universidad.curso_escolar b  on a.id_curso_escolar=b.id   group by a.id_curso_escolar ;
select a.id, a.nombre, a.apellido1, a.apellido2, count(b.id_profesor) as 'nombre assignatures' from universidad.persona a left join  universidad.asignatura b on a.id=b.id_profesor where a.tipo='profesor' group by a.id order by count(b.id_profesor) desc;
SELECT nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, MIN(universidad.persona.fecha_nacimiento) as fecha_nacimiento , sexo, tipo FROM universidad.persona where tipo='alumno' order by MIN(universidad.persona.fecha_nacimiento);
SELECT * FROM universidad.persona a left join universidad.profesor b on a.id=b.id_profesor left join universidad.asignatura c on b.id_profesor=c.id_profesor where a.tipo='profesor'and c.nombre is null;

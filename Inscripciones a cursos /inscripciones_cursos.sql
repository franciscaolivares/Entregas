INSERT INTO estudiantes (nombre, edad)
VALUES			        ('Federico Silva', 20),
                        ('Javiera Diaz',19),
                        ('Manuel Arcos', 22),
                        ('Paula Gandia', 20),
                        ('Matías Fernandez', 21);
                        
INSERT INTO cursos (nombre, duracion)
VALUES             ('Etica', '2 semestres'),
				   ('Inglés', '4 semestres'),
                   ('Matemáticas', '6 semestres'),
                   ('Filosofía', '2 semestres');
                   

INSERT INTO cursos_has_estudiantes (estudiantes_id_estudiantes, cursos_id_cursos)
VALUES                             (1,1),
								   (1,3),
                                   (2,4),
                                   (2,2),
                                   (3,1),
                                   (3,2),
                                   (4,4),
                                   (4,3);
     
     
SELECT estudiantes.nombre AS Nombre, cursos.nombre AS Curso
FROM estudiantes 
LEFT JOIN cursos_has_estudiantes 
ON estudiantes_id_estudiantes = id_estudiantes 
LEFT JOIN cursos
ON cursos_id_cursos = id_cursos;

SELECT estudiantes.nombre AS Nombre, cursos.nombre AS Curso
FROM estudiantes
JOIN cursos_has_estudiantes 
ON estudiantes_id_estudiantes = id_estudiantes 
JOIN cursos
ON cursos_id_cursos = id_cursos
WHERE cursos.nombre = 'Etica';

SELECT estudiantes.nombre AS Nombre, cursos.nombre AS Curso
FROM estudiantes
JOIN cursos_has_estudiantes 
ON estudiantes_id_estudiantes = id_estudiantes 
JOIN cursos
ON cursos_id_cursos = id_cursos
WHERE estudiantes.nombre = 'Manuel Arcos';

SELECT cursos.nombre AS Cursos, COUNT(cursos_has_estudiantes.estudiantes_id_estudiantes) AS cant_estudiantes
FROM cursos
LEFT JOIN cursos_has_estudiantes
ON id_cursos = cursos_id_cursos
GROUP BY cursos.nombre;


SELECT estudiantes.nombre AS Nombre
FROM estudiantes
LEFT JOIN cursos_has_estudiantes 
ON estudiantes_id_estudiantes = id_estudiantes 
WHERE cursos_has_estudiantes.cursos_id_cursos IS  null;









     

 



                                   
                                   
                                         

                        

                        
                        
                        
                        
                        
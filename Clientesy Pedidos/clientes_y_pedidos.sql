INSERT INTO clientes(nombre, direccion, telefono)
VALUES              ('María Alamos', 'Av Providencia 2263', 99922557),
					('Joaquín Perez', 'Cristobal Colon 3344', 944775592),
                    ('Julia Gomez', 'Vicuña Mackenna 8899', 933774688),
                    ('David Guzman', 'Av Grabriela 998', 932847294),
                    ('Victoria Villaroel', 'Av Macul', 97738462);
                    
INSERT INTO pedidos (clientes_id_clientes, fecha, total) 
VALUES              (1, '2025-09-01 10:00:00', 150.50),
                    (1, '2025-09-02 11:30:00', 200.00),
                    (2, '2025-09-01 09:15:00', 75.25),
                    (2, '2025-09-03 14:00:00', 180.40),
                    (3, '2025-09-04 12:10:00', 250.75),
                    (4, '2025-09-05 08:50:00', 90.00),
                    (4, '2025-09-06 10:30:00', 120.60),
                    (5, '2025-09-03 15:00:00', 60.00),
                    (5, '2025-09-04 17:45:00', 110.00);
                    
SELECT clientes.id_clientes, clientes.nombre, clientes.direccion, clientes.telefono, pedidos.id_ AS id_pedidos, pedidos.fecha, pedidos.total
FROM clientes 
JOIN pedidos  ON clientes.id_clientes = pedidos.clientes_id_clientes; 

SELECT *
FROM pedidos
WHERE clientes_id_clientes = 2;

SELECT clientes_id_clientes, clientes.nombre, SUM(pedidos.total) AS total_pedidos
FROM clientes
JOIN pedidos  ON clientes.id_clientes = pedidos.clientes_id_clientes
GROUP BY clientes.id_clientes, clientes.nombre ;

DELETE FROM pedidos
WHERE clientes_id_clientes = 2;
DELETE FROM clientes
WHERE id_clientes =2;

SELECT id_clientes, nombre, direccion, telefono, COUNT(pedidos.id_) AS cantidad_pedidos
FROM clientes 
JOIN pedidos  ON clientes.id_clientes = pedidos.clientes_id_clientes
GROUP BY clientes.id_clientes, clientes.nombre
ORDER BY cantidad_pedidos DESC
LIMIT 3;










                   
				
                    
                    
					
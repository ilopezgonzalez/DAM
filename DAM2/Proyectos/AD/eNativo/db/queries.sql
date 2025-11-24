-- Consultas útiles para la BD enativo_db (MariaDB)
-- 1) Personas con direcciones y teléfonos concatenados (una fila por persona)
-- Usa GROUP_CONCAT para agrupar los teléfonos en una sola columna.

SELECT p.ID,
       p.NOMBRE,
       p.EDAD,
       d.CALLE,
       d.CIUDAD,
       GROUP_CONCAT(t.NUMERO ORDER BY t.ID SEPARATOR ', ') AS TELEFONOS
FROM PERSONA p
LEFT JOIN DIRECCION d ON p.DIRECCION_ID = d.ID
LEFT JOIN TELEFONO  t ON t.PERSONA_ID = p.ID
GROUP BY p.ID, p.NOMBRE, p.EDAD, d.CALLE, d.CIUDAD
ORDER BY p.ID;

-- 2) Variante: incluir el ID de dirección en el GROUP BY si lo deseas
-- GROUP BY p.ID, p.NOMBRE, p.EDAD, d.ID, d.CALLE, d.CIUDAD

-- Nota: si la columna TELEFONOS aparece truncada, puedes aumentar
-- group_concat_max_len en MariaDB: SET SESSION group_concat_max_len = 10000;

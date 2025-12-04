-- ========================================
-- Base de datos: Reservas Baloncesto AGL
-- Versión completa para examen Tema 2
-- ========================================

DROP DATABASE IF EXISTS reservas_baloncesto;
CREATE DATABASE reservas_baloncesto CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE reservas_baloncesto;

-- ========================================
-- Tabla: socios
-- ========================================
CREATE TABLE socios (
    id_socio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15),
    fecha_alta DATE NOT NULL
) ENGINE=InnoDB;

-- ========================================
-- Tabla: partidos
-- ========================================
CREATE TABLE partidos (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    rival VARCHAR(100) NOT NULL,
    fecha_partido DATETIME NOT NULL,
    aforo_total INT NOT NULL DEFAULT 500,
    entradas_disponibles INT NOT NULL,
    precio_entrada DECIMAL(6,2) NOT NULL,
    CONSTRAINT chk_aforo CHECK (aforo_total > 0),
    CONSTRAINT chk_entradas CHECK (entradas_disponibles >= 0),
    CONSTRAINT chk_precio CHECK (precio_entrada >= 0)
) ENGINE=InnoDB;

-- ========================================
-- Tabla: reservas
-- ========================================
CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_socio INT NOT NULL,
    id_partido INT NOT NULL,
    num_entradas INT NOT NULL,
    fecha_reserva DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    confirmada BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_reserva_socio FOREIGN KEY (id_socio) REFERENCES socios(id_socio) ON DELETE CASCADE,
    CONSTRAINT fk_reserva_partido FOREIGN KEY (id_partido) REFERENCES partidos(id_partido) ON DELETE CASCADE,
    CONSTRAINT chk_num_entradas CHECK (num_entradas > 0 AND num_entradas <= 4)
) ENGINE=InnoDB;

-- ========================================
-- DATOS DE EJEMPLO
-- ========================================

-- Insertar socios
INSERT INTO socios (nombre, apellidos, email, telefono, fecha_alta) VALUES
('Juan', 'García López', 'juan.garcia@email.com', '666111222', '2023-09-15'),
('María', 'Fernández Ruiz', 'maria.fernandez@email.com', '666222333', '2023-10-20'),
('Carlos', 'Martínez Sánchez', 'carlos.martinez@email.com', '666333444', '2024-01-10'),
('Laura', 'González Pérez', 'laura.gonzalez@email.com', '666444555', '2024-02-14'),
('Pedro', 'Rodríguez Torres', 'pedro.rodriguez@email.com', '666555666', '2024-03-22'),
('Ana', 'López Moreno', 'ana.lopez@email.com', '666666777', '2024-05-18'),
('Miguel', 'Sánchez Navarro', 'miguel.sanchez@email.com', '666777888', '2024-06-30'),
('Elena', 'Romero Gil', 'elena.romero@email.com', '666888999', '2024-08-05'),
('Javier', 'Díaz Castro', 'javier.diaz@email.com', '666999000', '2024-09-12'),
('Isabel', 'Jiménez Vega', 'isabel.jimenez@email.com', '666000111', '2024-10-25');

-- Insertar partidos (algunos pasados, algunos futuros)
INSERT INTO partidos (rival, fecha_partido, aforo_total, entradas_disponibles, precio_entrada) VALUES
('CB Estudiantes', '2024-11-05 20:00:00', 500, 120, 12.00),
('Unicaja Málaga', '2024-11-10 19:30:00', 500, 0, 15.00),
('Real Madrid', '2025-11-18 21:00:00', 500, 450, 25.00),
('FC Barcelona', '2025-11-25 20:30:00', 500, 380, 30.00),
('Valencia Basket', '2025-12-02 19:00:00', 500, 500, 18.00),
('Baskonia', '2025-12-09 20:00:00', 500, 480, 20.00),
('Joventut Badalona', '2025-12-16 19:30:00', 500, 450, 16.00),
('Manresa', '2025-12-23 18:00:00', 500, 500, 14.00),
('Gran Canaria', '2026-01-06 20:00:00', 500, 470, 17.00),
('Breogán Lugo', '2026-01-13 19:30:00', 500, 500, 15.00);

-- Insertar reservas
INSERT INTO reservas (id_socio, id_partido, num_entradas, fecha_reserva, confirmada) VALUES
-- Reservas para el partido 1 (CB Estudiantes - pasado)
(1, 1, 2, '2024-10-28 10:30:00', TRUE),
(2, 1, 4, '2024-10-29 14:20:00', TRUE),
(3, 1, 3, '2024-11-01 09:15:00', TRUE),

-- Reservas para el partido 2 (Unicaja - pasado, entradas agotadas)
(1, 2, 3, '2024-11-02 11:00:00', TRUE),
(4, 2, 4, '2024-11-03 15:30:00', TRUE),
(5, 2, 2, '2024-11-04 10:45:00', TRUE),
(6, 2, 4, '2024-11-05 12:00:00', TRUE),
(7, 2, 1, '2024-11-06 16:20:00', TRUE),

-- Reservas para el partido 3 (Real Madrid - futuro)
(2, 3, 2, '2025-11-10 10:00:00', FALSE),
(8, 3, 4, '2025-11-11 14:30:00', TRUE),

-- Reservas para el partido 4 (FC Barcelona - futuro)
(1, 4, 3, '2025-11-12 09:45:00', TRUE),
(3, 4, 4, '2025-11-13 11:20:00', TRUE),
(9, 4, 2, '2025-11-14 16:00:00', FALSE),
(10, 4, 1, '2025-11-15 13:30:00', TRUE),

-- Reservas para el partido 6 (Baskonia - futuro)
(5, 6, 2, '2025-11-16 10:30:00', FALSE),
(7, 6, 4, '2025-11-17 15:00:00', TRUE),

-- Reservas para el partido 7 (Joventut - futuro)
(4, 7, 3, '2025-11-18 12:00:00', TRUE),
(6, 7, 2, '2025-11-19 14:45:00', FALSE),

-- Reservas para el partido 9 (Gran Canaria - futuro)
(8, 9, 2, '2025-11-20 11:30:00', TRUE),
(10, 9, 4, '2025-11-21 16:15:00', FALSE);

-- ========================================
-- PROCEDIMIENTO ALMACENADO
-- ========================================

DELIMITER //

CREATE PROCEDURE confirmar_reserva(
    IN p_id_reserva INT,
    OUT p_mensaje VARCHAR(200)
)
BEGIN
    DECLARE v_existe INT;
    DECLARE v_confirmada BOOLEAN;
    
    -- Verificar si existe la reserva
    SELECT COUNT(*), IFNULL(MAX(confirmada), FALSE) 
    INTO v_existe, v_confirmada
    FROM reservas 
    WHERE id_reserva = p_id_reserva;
    
    IF v_existe = 0 THEN
        SET p_mensaje = CONCAT('ERROR: No existe la reserva con ID ', p_id_reserva);
    ELSEIF v_confirmada = TRUE THEN
        SET p_mensaje = CONCAT('AVISO: La reserva ', p_id_reserva, ' ya estaba confirmada');
    ELSE
        UPDATE reservas 
        SET confirmada = TRUE 
        WHERE id_reserva = p_id_reserva;
        
        SET p_mensaje = CONCAT('OK: Reserva ', p_id_reserva, ' confirmada correctamente');
    END IF;
END //

DELIMITER ;

-- ========================================
-- CONSULTAS DE VERIFICACIÓN (COMENTADAS)
-- ========================================

-- Ver todos los socios
-- SELECT * FROM socios;

-- Ver todos los partidos
-- SELECT * FROM partidos ORDER BY fecha_partido;

-- Ver todas las reservas
-- SELECT r.id_reserva, s.nombre, s.apellidos, p.rival, p.fecha_partido, 
--        r.num_entradas, r.fecha_reserva, r.confirmada
-- FROM reservas r
-- INNER JOIN socios s ON r.id_socio = s.id_socio
-- INNER JOIN partidos p ON r.id_partido = p.id_partido
-- ORDER BY r.fecha_reserva DESC;

-- Ver partidos sin reservas
-- SELECT p.id_partido, p.rival, p.fecha_partido, p.entradas_disponibles
-- FROM partidos p
-- LEFT JOIN reservas r ON p.id_partido = r.id_partido
-- WHERE r.id_reserva IS NULL;

-- Ver socios con número de entradas reservadas
-- SELECT s.id_socio, s.nombre, s.apellidos, s.email, 
--        COALESCE(SUM(r.num_entradas), 0) as total_entradas
-- FROM socios s
-- LEFT JOIN reservas r ON s.id_socio = r.id_socio
-- GROUP BY s.id_socio
-- ORDER BY total_entradas DESC;

-- Probar procedimiento almacenado
-- CALL confirmar_reserva(1, @mensaje);
-- SELECT @mensaje;

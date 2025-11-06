/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procedimientos;

/**
 *
 * @author damt209
 */
public class CrearProcedimiento {

    DELIMITER $$
    CREATE PROCEDURE

    ActualizarStockProducto(
            IN p_nombre
    VARCHAR(40),
    IN p_cantidad_cambio INT,
    OUT p_nuevo_stock INT,
    OUT p_mensaje VARCHAR(100)
)
BEGIN
    DECLARE v_stock_actual INT DEFAULT 0;
    DECLARE v_existe INT DEFAULT 0;
    
    -- Verificar si el producto existe SELECT

    COUNT(
    *), COALESCE(cantidad, 0) 
    INTO v_existe, v_stock_actual
    FROM productos 
    WHERE nombre = p_nombre;
    
    IF v_existe = 0 THEN SET p_mensaje  =  
     
    'Producto no encontrado';
        SET p_nuevo_stock = -1;
    ELSE
    -- Calcular nuevo stock SET p_nuevo_stock  = v_stock_actual + p_cantidad_cambio;

    -- Verificar que no sea negativo IF p_nuevo_stock< 0 THEN SET p_mensaje  =  
     
    'Error: Stock insuficiente';
            SET p_nuevo_stock = v_stock_actual;
    ELSE
    -- Actualizar el stock UPDATE productos SET cantidad  = p_nuevo_stock 
    WHERE nombre = p_nombre;

    SET p_mensaje =  
     
    'Stock actualizado correctamente';
        END IF;
    END IF;
    END$$ DELIMITER;

}

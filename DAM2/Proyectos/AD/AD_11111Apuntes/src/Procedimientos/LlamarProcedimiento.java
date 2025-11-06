/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procedimientos;

/**
 *
 * @author damt209
 */
public class LlamarProcedimiento {
    
    public static void actualizarStockProducto(String nombreProducto, int cambioStock) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String contraseña = "password";
        
        // Sintaxis de llamada a procedimiento almacenado
        String sql = "{CALL ActualizarStockProducto(?, ?, ?, ?)}";
        
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             CallableStatement cstmt = conexion.prepareCall(sql)) {
             
            // Establecer parámetros IN
            cstmt.setString(1, nombreProducto);    // p_nombre
            cstmt.setInt(2, cambioStock);          // p_cantidad_cambio
            
            // Registrar parámetros OUT
            cstmt.registerOutParameter(3, Types.INTEGER); // p_nuevo_stock
            cstmt.registerOutParameter(4, Types.VARCHAR); // p_mensaje
            
            // Ejecutar el procedimiento
            cstmt.execute();
            
            // Obtener valores de retorno
            int nuevoStock = cstmt.getInt(3);
            String mensaje = cstmt.getString(4);
            
            // Mostrar resultados
            System.out.println("Resultado: " + mensaje);
            if (nuevoStock >= 0) {
                System.out.println("Nuevo stock de " + nombreProducto + ": " + nuevoStock);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al ejecutar procedimiento: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        actualizarStockProducto("manzanas", 10);  // Añadir 10 unidades
        actualizarStockProducto("naranjas", -5);  // Reducir 5 unidades
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transacciones;

/**
 *
 * @author damt209
 */
public class TransaccionCommit {
    
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:empresa.db")) {
    
    // Desactivamos autocommit para iniciar control manual de transacciones
    conn.setAutoCommit(false);
    
    try (PreparedStatement ps1 = conn.prepareStatement("UPDATE cuentas SET saldo = saldo - ? WHERE id = ?");
         PreparedStatement ps2 = conn.prepareStatement("UPDATE cuentas SET saldo = saldo + ? WHERE id = ?")) {
         
        // Primera operación: retirar dinero de cuenta origen
        ps1.setDouble(1, 1000.0);
        ps1.setInt(2, 1);
        ps1.executeUpdate();
        
        // Segunda operación: ingresar dinero en cuenta destino
        ps2.setDouble(1, 1000.0);
        ps2.setInt(2, 2);
        ps2.executeUpdate();
        
        // Si todo va bien, confirmamos la transacción
        conn.commit();
        System.out.println("Transferencia completada con éxito");
        
    } catch (SQLException e) {
        // Si hay error, deshacemos todos los cambios
        conn.rollback();
        System.out.println("Error: Transacción cancelada - " + e.getMessage());
        throw e;
    } finally {
        // Reactivamos el autocommit para operaciones futuras
        conn.setAutoCommit(true);
    }
}

}

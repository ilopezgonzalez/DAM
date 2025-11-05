/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transacciones;

/**
 *
 * @author damt209
 */
public class TransaccionStartTransaction {


try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/empresa", "usuario", "password");
     Statement stmt = conn.createStatement()) {
     
    // Iniciamos la transacción manualmente
    stmt.execute("START TRANSACTION");
    
    // Ejecutamos varias operaciones que deben ser atómicas
    stmt.executeUpdate("UPDATE cuentas SET saldo = saldo - 1000 WHERE id = 1");
    stmt.executeUpdate("UPDATE cuentas SET saldo = saldo + 1000 WHERE id = 2");
    
    // Si todo va bien, confirmamos la transacción
    stmt.execute("COMMIT");
    System.out.println("Transferencia realizada con éxito");
    
} catch (SQLException e) {
    try (Connection rollbackConn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/empresa", "usuario", "password");
         Statement rollbackStmt = rollbackConn.createStatement()) {
         
        // Si hay error, deshacemos la transacción
        rollbackStmt.execute("ROLLBACK");
        System.out.println("Error: Transacción cancelada - " + e.getMessage());
        
    } catch (SQLException rollbackEx) {
        System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
    }
}

    
}

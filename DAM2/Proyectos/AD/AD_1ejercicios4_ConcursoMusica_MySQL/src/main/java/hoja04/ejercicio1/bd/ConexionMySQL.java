/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ConexionMySQL {

    private static final Logger LOG = Logger.getLogger(ConexionMySQL.class.getName());
    private static final String DB_PATH = "concursomusica.db"; // archivo en el servidor SQL
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_PATH;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la base de datos: " + URL, e);
            return null;
        }
    }
}



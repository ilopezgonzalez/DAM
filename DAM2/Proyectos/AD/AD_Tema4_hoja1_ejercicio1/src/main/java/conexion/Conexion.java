/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class Conexion {
    
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());

    private static final String DB_PATH = "concursomusica"; // archivo en el servidor SQL
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_PATH;
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            
            Properties properties=new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASS);
            properties.setProperty("useSSL", "false");
            return DriverManager.getConnection(URL, properties);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la base de datos: " + URL, e);
            return null;
        }
    
}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cic
 */
public class ConexionSQLite {

    private static final Logger LOG = Logger.getLogger(ConexionSQLite.class.getName());
    // Ajusta la ruta si pones heroes.db en otro sitio. Por defecto, en la raíz del módulo.
    private static final String DB_PATH = "heroes.db"; // archivo en la carpeta del proyecto
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la base de datos: " + URL, e);
            return null;
        }
    }
}

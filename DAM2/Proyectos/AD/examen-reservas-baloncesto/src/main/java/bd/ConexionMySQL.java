/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ConexionMySQL {
    private static Connection conn=null;
    private static final Logger LOG=Logger.getLogger(ConexionMySQL.class.getName());
    private static final String DB_PATH="reservas_baloncesto";
    private static final String URL="jdbc:mysql://localhost:3306/"+DB_PATH;
    private static final String USER="root";
    private static final String PASS="";

    public ConexionMySQL() {
    }
    
   
    
    
   
    public static Connection getConnection(){
        try {
            Properties properties=new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASS);
            properties.setProperty("useSSL", "false");
            conn=(Connection)DriverManager.getConnection(URL, properties);
            if (conn==null) {
                System.out.println("Error de conexion");
            }else{
                System.out.println("Conexion realizada");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la BBDD"+URL, e);
        } 
        return conn;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package lite.ejemplosqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cic
 */
public class EjemploSQLite {

    public static void main(String[] args) {

        Connection conexion = conexion();

        if (conexion != null) {
            crearTablas(conexion());
            insertarDatos(conexion());
            mostrarDatos(conexion());
        }
    }

    //devuelve el objeto de conexión o nulo si falla
    public static Connection conexion() {
        Connection con = null;
        // importante: busca el archivo en el proyecto y crea la bd si falta el archivo
        final String URL = "jdbc:sqlite:C:\\Users\\cic\\Documents\\Curso25-26\\2526AD\\FuentesAD2526\\Tema2\\BDSQLite\\ejemplo.db";
        try {
            con = DriverManager.getConnection(URL);
            System.out.println("Conexión OK con la bd ejemplo.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return con;
        }
    }

    public static void crearTablas(Connection conn) {
        // en String tabla codigo sql con el create table
        String tabla = "CREATE TABLE productos(\n"
                + "  id INTEGER NOT NULL ,\n"
                + "  nombre TEXT NOT NULL,\n"
                + "  cantidad INTEGER NOT NULL,\n"
                + "  PRIMARY KEY (`id` AUTOINCREMENT)\n"
                + ")";

        try (Statement sentencia = conn.createStatement();) {
            int resul = sentencia.executeUpdate(tabla);
            System.out.println("Tabla producto creada con éxito!!");
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de la tabla " + ex.getMessage());
        }
    }

    public static void insertarDatos(Connection conn) {

        try (Statement sentencia = conn.createStatement();) {
            // dentro de executeUpdate codigo del insert, update o delete
            String inserta = "INSERT INTO productos"
                    + "(nombre,cantidad)"
                    + "VALUES ('manzanas',18),"
                    + "('kiwis',22),('naranjas',23)";
            int resul = sentencia.executeUpdate(inserta);
            if (resul == 3) {
                System.out.println("Filas afectadas: " + resul);
            } else {
                throw new Exception("error no se han insertado todos los registros");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la inserción de datos " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void mostrarDatos(Connection conn) {
        // dentro de executeQuery Codigo de la select
        String sql = "select id,nombre,cantidad from productos";
        try (
                Statement sentencia = conn.createStatement(); ResultSet rs = sentencia.executeQuery(sql);) {
            while (rs.next()) {
                //cada columna se indica, el tipo en el get, y que posicion o 
                //que nombre tiene en el argumento
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString("nombre") + " ");
                System.out.println(rs.getInt(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        }
    }
}

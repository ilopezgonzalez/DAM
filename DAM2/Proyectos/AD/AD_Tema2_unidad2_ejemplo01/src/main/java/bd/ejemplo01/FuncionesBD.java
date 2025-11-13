/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd.ejemplo01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author cic
 */
public class FuncionesBD {
    // otros métodos

    public static void crearTablas() {
        // en String tabla codigo sql con el create table
        String tabla = "create table productos(\n"
                + "  id smallint NOT NULL AUTO_INCREMENT,\n"
                + "  nombre varchar(40) NOT NULL,\n"
                + "  cantidad int NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ";
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try (Statement sentencia = conn.createStatement();) {
            int resul = sentencia.executeUpdate(tabla);
            System.out.println("Tabla producto creada con éxito!!");
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de la tabla " + ex.getMessage());
        }
    }

    // insertar información en la tabla
    public static void insertarDatos() {
        Statement sentencia = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try {
            sentencia = conn.createStatement();
            // dentro de executeUpdate codigo del insert, update o delete
            String inserta = "INSERT INTO productos"
                    + "(nombre,cantidad)"
                    + "VALUES ('melocotones',8),"
                    + "('platanos',12),('peras',3)";
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
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
    }
// otra forma realizando en el try el cierre automático. No incluimos la conexión 

    public static void insertarDatos2() {

        Connection conn = AccesoBaseDatos.getInstance().getConn();
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

    // muestra los datos de una tabla
    public static void mostrarDatos() {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery Codigo de la select
            String sql = "select id,nombre,cantidad from productos";
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                //cada columna se indica, el tipo en el get, y que posicion o 
                //que nombre tiene en el argumento
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString("nombre") + " ");
                System.out.println(rs.getInt(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
    }
    // otra forma de realizarlo indicar en el try las operaciones que queremos se cierren automaticamente
    // ponemos esas sentencias entre paréntesis

    public static void mostrarDatos2() {
        // dentro de executeQuery Codigo de la select
        String sql = "select id,nombre,cantidad from productos";
        Connection conn = AccesoBaseDatos.getInstance().getConn();
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

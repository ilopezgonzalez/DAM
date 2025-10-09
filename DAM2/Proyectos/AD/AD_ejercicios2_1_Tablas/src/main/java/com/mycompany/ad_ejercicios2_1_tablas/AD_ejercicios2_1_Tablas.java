/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios2_1_tablas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author damt209
 */
public class AD_ejercicios2_1_Tablas {

    public static void main(String[] args) {
        consulta(establecerconexion());
    }

    public static Connection establecerconexion() {
        Connection conexion = null;
        String url = "jdbc:sqlite:D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\AD\\AD_ejercicios2_1_Tablas\\misrutas.db";
        try {
            conexion = DriverManager.getConnection(url);
            if (conexion != null) {
                System.out.println("Conexion establecida");

            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
        

    }

    public static void consulta(Connection conn) {
        String url = "jdbc:sqlite:D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\AD\\AD_ejercicios2_1_Tablas\\misrutas.db";
        try {
            conn = DriverManager.getConnection(url);
            String sql = "select * from rutas";
            Statement sentencia = conn.createStatement();
            boolean esConsulta = sentencia.execute(sql);
            if (esConsulta) {
                ResultSet rs = sentencia.getResultSet();
                while (rs.next()) {
                    System.out.println("IDRuta: " + rs.getInt(1));
                    System.out.println("Nombre Ruta: " + rs.getString(2));
                    System.out.println("Circular: " + rs.getInt(3));
                    System.out.println("Inico: " + rs.getString(4));
                    System.out.println("Final: " + rs.getString(5));
                    System.out.println("Fecha: " + rs.getString(6));
                }
            } else {
                int filasAfectadas = sentencia.getUpdateCount();
            }
        } catch (Exception e) {
        }
    }
}

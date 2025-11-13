/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_ejercicios2_2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author damt209
 */
public class Conexion_SINGLETON {

    private Connection conn = null;
    private static final String URL = "jdbc:sqlite:D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\AD\\AD_ejercicios2_1_Tablas\\misrutas.db";

    private Conexion_SINGLETON() {

        try {

            conn = (Connection) DriverManager.getConnection(URL);
            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static Conexion_SINGLETON getInstance() {
        return ConexionHolder.INSTANCE;
    }

    private static class ConexionHolder {

        private static final Conexion_SINGLETON INSTANCE = new Conexion_SINGLETON();
    }

    // método obtener la conexión
    public Connection getConexion() {
        return conn;
    }

    // método para cerrar la conexión a la bd
    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                siCerrada = true;
            }
        } catch (SQLException sqe) {
            System.out.println("Se produjo un error en el cierre" + sqe.getMessage());
        }
        return siCerrada;
    }

//    public static Connection getConnection() {
//        Connection conn=null;
//        try {
//            conn = (Connection)DriverManager.getConnection(URL);
//            if (conn != null) {
//                System.out.println("Conexion establecida");
//
//            } else {
//                System.out.println("No se ha podido conectar");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
}

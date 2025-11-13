/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_ejercicios2_2;

import com.mycompany.ad_ejercicios2_2.Conexion_SINGLETON;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class Operaciones {

    public Operaciones() {
    }

    public static void consultarRuta() throws SQLException {
        Connection conn= Conexion_SINGLETON.getInstance().getConexion();
        String sql = "select tituloruta, inicio from rutas";
        Statement sentencia = conn.createStatement();
        boolean funciona = sentencia.execute(sql);
        if (funciona) {
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                System.out.println("Nombre de la ruta: " + rs.getString(1));
                System.out.println("Inicio de la ruta: " + rs.getString(2));
            }
        }

    }

    public static void insertarRuta() throws Exception {
        Connection conn=Conexion_SINGLETON.getInstance().getConexion();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre de la ruta: ");
        String nombreRuta = teclado.nextLine();
        System.out.print("Introduce si la ruta es circular SI=1, NO=0: ");
        int circular = Integer.parseInt(teclado.nextLine());
        System.out.print("Introduce el punto de inicio de la ruta: ");
        String pinicio = teclado.nextLine();
        System.out.print("Introduce el punto final de la ruta: ");
        String pfinal = teclado.nextLine();
        System.out.print("Introduce la fecha de la ruta: ");
        String fecha = teclado.nextLine();
        String sql = "insert into rutas (tituloruta, circular, inicio, final, fecha) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreRuta);
            ps.setInt(2, circular);
            ps.setString(3, pinicio);
            ps.setString(4, pfinal);
            ps.setString(5, fecha);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                System.out.println("Inserccion correcta");
            } else {
                throw new Exception("Error, no se ha realizado la inserccion");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la ejecucion de la sentencia " + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

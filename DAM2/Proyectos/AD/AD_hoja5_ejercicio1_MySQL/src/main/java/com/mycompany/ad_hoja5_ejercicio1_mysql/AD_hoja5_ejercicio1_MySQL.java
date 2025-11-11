/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_hoja5_ejercicio1_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class AD_hoja5_ejercicio1_MySQL {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero de id del grupo:");
        int idGrupo = Integer.parseInt(teclado.nextLine());

        String sql = "Select numCancion, grupo, duracion, titulo, total_votos from canciones inner join grupos on grupo=codgrupo where codgrupo=?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concursomusica", "root", "")) {
            PreparedStatement ps = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ps.setInt(1, idGrupo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                rs.getInt("numCancion");
                rs.getString("grupo");
                rs.getTime("duracion");
                rs.getString("titulo");
                rs.getInt("total_votos")
                        ;
            }

        } catch (Exception e) {
        }

    }
}

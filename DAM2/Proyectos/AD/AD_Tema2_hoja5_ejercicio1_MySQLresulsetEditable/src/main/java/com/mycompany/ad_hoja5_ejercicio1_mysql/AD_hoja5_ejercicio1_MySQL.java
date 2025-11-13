/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_hoja5_ejercicio1_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class AD_hoja5_ejercicio1_MySQL {

    Scanner teclado = new Scanner(System.in);
    public static int nuevosVotos;
    public static ResultSet rs;

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
            rs = ps.executeQuery();
            while (rs.next()) {
                int numCancion = rs.getInt("numCancion");
                String grupo = rs.getString("grupo");
                Time duracion = rs.getTime("duracion");
                String titulo = rs.getString("titulo");
                int total_votos = rs.getInt("total_votos");
                System.out.println("Cancion:");
                System.out.println("----------------------------------");
                System.out.println("Numero de cancion: " + numCancion + "\nnombre del grupo: " + grupo + "\nDuracion de la cancion: " + duracion + "\nTitulo de la cancion: " + titulo + "\nTotal de votos:" + total_votos);
                System.out.println("----------------------------------");
                System.out.println("Deseas cambiar los votos de la cancion??");
                String campo = teclado.nextLine();
                if (campo.trim().toUpperCase().equals("S") || campo.trim().toUpperCase().equals("SI")) {
                    System.out.println("Introduce el nuevo numero de votos:");
                    try {
                        nuevosVotos = Integer.parseInt(teclado.nextLine());
                        if (nuevosVotos < 0) {
                            System.out.println("El número de votos no puede ser negativo");
                            continue; // pasa a la siguiente canción
                        }
                        rs.updateInt("total_votos", nuevosVotos);
                        rs.updateRow();
                        System.out.println("Fila modicada con exito");

                    } catch (NumberFormatException e) {
                        System.out.println("Debes introducir solo numeros");
                    }
                } else {
                    continue;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

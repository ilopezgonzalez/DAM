package com.mycompany.ad_anadiruser;


import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class AnadirUser {

    private static final Logger LOG = Logger.getLogger(AnadirUser.class.getName());
    private static final String DB_PATH = "concursomusica"; // archivo en el servidor SQL
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_PATH;
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario:");
        String usuario = teclado.nextLine();
        System.out.print("Introduce el password:");
        String password = teclado.nextLine();
        int filas = userAdd(usuario, password);
        if (filas==1) {
            System.out.println("Usuario insertado correctamente");
        }

    }

    public static int userAdd(String user, String password) {
        String sql = "Insert into usuarios (user, password) values (?, MD5(?))";
        int filas = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, password);

            filas = ps.executeUpdate();

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Error: El usuario ya existe");
            } else {
                LOG.log(Level.SEVERE, "Error insertando el usuario", e);
            }
        }
        return filas;
    }
}

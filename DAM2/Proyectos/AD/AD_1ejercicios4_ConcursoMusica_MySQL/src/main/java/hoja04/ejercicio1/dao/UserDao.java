/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.dao;

import hoja04.ejercicio1.modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class UserDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(UserDao.class.getName());

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public int userAdd(String user, String password) {
        String sql = "Insert into usuarios (user, password) values (?, MD5(?))";
        int filas = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, password);
            filas = ps.executeUpdate();
            if (filas == 1) {
                System.out.println("Se han actualizado " + filas + " filas");

            } else {
                System.out.println("No se insertaron filas");
            }

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("El usuario ya existe");
            } else {
                LOG.log(Level.SEVERE, "Error en UserDao.userAdd", e);
            }
        }

        return filas;
    }

}

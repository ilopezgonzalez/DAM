/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Partido;
import modelo.Reserva;
import modelo.Socio;

/**
 *
 * @author alumno
 */
public class SocioDao {
    
    private final Connection conn;
    private static final Logger LOG = null;

    public SocioDao(Connection conn) {
        this.conn = conn;
    }
    
    public List<Socio> obtenerSociosReservas() {
        String sql = "select id_socio as socio, nombre, apellidos, email, telefono, fecha_alta, from socios as s inner join reservas as r on s.id_socio=r.id_socio";
        List<Socio> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio=new Socio(rs.getInt("socio"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_alta"));
                
                lista.add(socio);
            }
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la BBDD", e);
        }
        return lista;
    }
}

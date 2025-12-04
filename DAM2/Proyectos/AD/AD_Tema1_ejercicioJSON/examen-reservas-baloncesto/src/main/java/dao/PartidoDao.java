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

/**
 *
 * @author alumno
 */
public class PartidoDao {

    private final Connection conn;
    private static final Logger LOG = null;

    public PartidoDao(Connection conn) {
        this.conn = conn;
    }

    public List<Partido> obtenerTodosPartidos() {
        String sql = "select id_partido, rival, fecha_partido, aforo_total; entradas_disponibles, precio_entrada from partidos";
        List<Partido> lista = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partido partido = new Partido(
                        rs.getInt("id_partido"),
                        rs.getString("rival"),
                        rs.getDate("fecha_partido"),
                        rs.getInt("aforo_total"),
                        rs.getInt("entradas_disponibles"),
                        rs.getFloat("precio_entrada")
                );
                lista.add(partido);
            }
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo conectar a la BBDD", e);
        }
        return lista;
    }

}

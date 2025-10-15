/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.dao;

import hoja03.ejercicio1.modelo.PeliculaPersonajeActuacion;
import hoja03.ejercicio1.modelo.TituloPeliculaNumPersonajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class TituloPeliculaNumPersonajesDao {
    
    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(PeliculaDao.class.getName());

    public TituloPeliculaNumPersonajesDao(Connection conn) {
        this.conn = conn;
    }
    
    
    
    public List<TituloPeliculaNumPersonajes> encontrarTituloNumPersonajes() {
        String sql = "SELECT m.title as title, COUNT(a.character_id) as numChar FROM movies AS m JOIN acts AS a ON m.id = a.movie_id GROUP BY m.id, m.title ORDER BY m.title";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<TituloPeliculaNumPersonajes> lista = new ArrayList<>();
            while (rs.next()) {
                TituloPeliculaNumPersonajes tpnp = new TituloPeliculaNumPersonajes(
                        rs.getString("title"),
                        rs.getInt("numChar")
                );
                lista.add(tpnp);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PelucilaPerosnajeActuacionDao.findAll", e);
            return Collections.emptyList();
        }
    }
}

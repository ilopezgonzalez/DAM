/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.dao;

import hoja03.ejercicio1.modelo.PeliculaPersonajeActuacion;
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
 * @author ASUS
 */
public class PeliculaPersonajeActuacionDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(PeliculaPersonajeActuacionDao.class.getName());

    public PeliculaPersonajeActuacionDao(Connection conn) {
        this.conn = conn;
    }

    public List<PeliculaPersonajeActuacion> findAll() {
        String sql = "select m.title, m.year, c.name, a.actor from movies as m inner join acts as a on m.id = a.movie_id inner join characters as c on a.character_id=c.id";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<PeliculaPersonajeActuacion> lista = new ArrayList<>();
            while (rs.next()) {
                PeliculaPersonajeActuacion ppa = new PeliculaPersonajeActuacion(
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getString("name"),
                        rs.getString("actor")
                );
                lista.add(ppa);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PelucilaPerosnajeActuacionDao.findAll", e);
            return Collections.emptyList();
        }
    }

}

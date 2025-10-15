/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.dao;

import hoja03.ejercicio1.modelo.Pelicula;
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
 * @author cic
 */
public class PeliculaDao {
    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(PeliculaDao.class.getName());

    public PeliculaDao(Connection conn) {
        this.conn = conn;
    }

    public List<Pelicula> findAll() {
        String sql = "SELECT id, title, duration, year, producer FROM movies ORDER BY title";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Pelicula> lista = new ArrayList<>();
            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        (Integer) rs.getObject("duration"),
                        (Integer) rs.getObject("year"),
                        rs.getString("producer")
                );
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PeliculaDao.findAll", e);
            return Collections.emptyList();
        }
    }
    
    public List<Pelicula> obtenerPeliculasSinProductor() {
        String sql = "select * from movies where producer is null";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Pelicula> listaSinProductor = new ArrayList<>();
            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        (Integer) rs.getObject("duration"),
                        (Integer) rs.getObject("year"),
                        rs.getString("producer")
                );
                listaSinProductor.add(p);
            }
            return listaSinProductor;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PeliculaDao.encontrarPeliculasSinProductora", e);
            return Collections.emptyList();
        }
    }
}

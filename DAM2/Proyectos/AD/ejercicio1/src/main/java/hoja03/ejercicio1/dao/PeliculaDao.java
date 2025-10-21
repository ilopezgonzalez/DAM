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
import java.util.Optional;
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
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
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
        String sql = "select id, title, duration, year, producer from movies where producer is null or trim(producer)='' order by title";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Pelicula> listaSinProductor = new ArrayList<>();
            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("year"),
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

    public Optional<Pelicula> obtenerPeliculaMasAntigua() {
        String sql = "SELECT * from movies where year=(select min(year) from movies)";
        Optional<Pelicula> peli = Optional.empty();
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Pelicula pel = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("year"),
                        rs.getString("producer")
                );
                peli = Optional.of(pel);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PeliculaDao.obtenerPeliculaMasantigua", e);
        }
        return peli;
    }

    public List<Pelicula> obtenerPeliculasPorActor(String actor) {
        String sql = "select m.id, m.title, m.duration, m.year, m.producer from movies as m inner join acts as a on m.id=a.movie_id where a.actor like ?";
        List<Pelicula> peliculas = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%"+actor+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("year"),
                        rs.getString("producer")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PeliculaDao.obtenerPeliculasPorActor", e);

        }
        return peliculas;
    }
    
    public List<Pelicula> obtenerPeliculasSinActuaciones() { //where not exist(select 1 from acts as a where a.movie_id=m.id)order by title.
        //String sql = "SELECT m.id, m.title, m.duration, m.year, m.producer FROM movies AS m LEFT JOIN acts AS a ON m.id = a.movie_id WHERE a.movie_id IS NULL";
        String sql = "SELECT m.id, m.title, m.duration, m.year, m.producer FROM movies where not exist(select 1 from acts as a where a.movie_id=m.id)order by title";
        List<Pelicula> peliculas = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("year"),
                        rs.getString("producer")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PeliculaDao.obtenerPeliculasSinActuaciones", e);

        }
        return peliculas;
    }
    
}

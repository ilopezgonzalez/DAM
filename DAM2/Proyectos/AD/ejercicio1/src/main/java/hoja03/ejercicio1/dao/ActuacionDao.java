/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.dao;

import hoja03.ejercicio1.modelo.Actuacion;
import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.Personaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ActuacionDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(ActuacionDao.class.getName());

    public ActuacionDao(Connection conn) {
        this.conn = conn;
    }

    public List<Actuacion> obtenerPersonajesDePeliculas() {
        String sql = """
                     select a.id as act_id, a.minutes_in_movie, a.main_character, a.actor,
                     m.id as movie_id, m.title, m.duration, m.year, m.producer,
                     c.id as char_id, c.name, c.powers, c.company, c.origin, c.isHeroe
                     from acts as a inner join movies as m on a.movie_id=m.id
                     inner join characters as c on a.character_id=c.id
                     """;
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Actuacion> lista = new ArrayList<>();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getInt("year"),
                        rs.getString("producer"));
                Personaje personaje = new Personaje(rs.getInt("char_id"),
                        rs.getString("name"),
                        rs.getString("powers"),
                        rs.getString("company"),
                        rs.getString("origin"),
                        rs.getBoolean("isHeroe"));
                Actuacion act = new Actuacion(rs.getInt("act_id"),
                        personaje,
                        pelicula,
                        rs.getInt("minutes_in_movie"),
                        rs.getBoolean("main_character"),
                        rs.getString("actor")
                );
                lista.add(act);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en ActuacionDao.personajesDePeliculas", e);
            return Collections.emptyList();
        }
    }

    public Map<String, Integer> obtenerActuacionesPorPelicula() {
        String sql = """
                     SELECT m.id, m.title AS title, COUNT(a.id) AS numAct FROM movies AS m JOIN 
                     acts AS a ON m.id = a.movie_id GROUP BY m.id, m.title ORDER BY m.title
                     """;
        try (PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()){
            Map<String, Integer> mapa= new LinkedHashMap<>();
            while (rs.next()) {
                mapa.put(rs.getInt("id")+" - "+rs.getString("title"), rs.getInt("numAct"));
            }
            return mapa;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en ActuacionDao.actuacionesPorPeliculas", e);
            return Collections.emptyMap();
        }
    }
}

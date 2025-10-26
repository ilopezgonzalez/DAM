/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.dao;

import com.google.protobuf.Internal;
import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
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
public class CancionDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(CancionDao.class.getName());

    public CancionDao(Connection conn) {
        this.conn = conn;
    }

    public List<Cancion> obtenerCanciones() {
        String sql = "select g.codgrupo, g.nombre, g.localidad, g.estilo, g.esgrupo, g.annoGrab, g.fechaEstreno, g.compania, c.numCancion, c.grupo, c.duracion, c.titulo, c.total_votos from grupos as g inner join canciones as c on codgrupo=grupo";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Cancion> lista = new ArrayList<>();
            while (rs.next()) {
                Grupo grupo = new Grupo(
                        rs.getInt("codgrupo"),
                        rs.getString("nombre"),
                        rs.getString("localidad"),
                        rs.getString("estilo"),
                        rs.getBoolean("esgrupo"),
                        rs.getInt("annoGrab"),
                        rs.getDate("fechaEstreno"),
                        rs.getString("estilo")
                );
                Cancion cancion = new Cancion(
                        rs.getInt("numCancion"),
                        grupo,
                        rs.getTime("duracion"),
                        rs.getString("titulo"),
                        rs.getInt("total_votos")
                );

                lista.add(cancion);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en CancionDao.obtenerCanciones", e);
            return Collections.emptyList();
        }
    }

    public List<Cancion> obtenerCancionesDeGrupo(String nombreGrupo) {
        String sql = "select numCancion, grupo, duracion, titulo, total_votos, codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from canciones inner join grupos on grupo=codgrupo where nombre=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreGrupo);
            ResultSet rs = ps.executeQuery();
            List<Cancion> lista = new ArrayList<>();
            while (rs.next()) {
                Grupo grupo = new Grupo(
                        rs.getInt("codgrupo"),
                        rs.getString("nombre"),
                        rs.getString("localidad"),
                        rs.getString("estilo"),
                        rs.getBoolean("esgrupo"),
                        rs.getInt("annoGrab"),
                        rs.getDate("fechaEstreno"),
                        rs.getString("compania")
                );
                Cancion cancion = new Cancion(
                        rs.getInt("numCancion"),
                        grupo,
                        rs.getTime("duracion"),
                        rs.getString("titulo"),
                        rs.getInt("total_votos")
                );
                lista.add(cancion);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en CancionDao.obtenerCancionesDeGrupo", e);
            return Collections.emptyList();
        }
    }
    public List<Cancion> cancionesMasVotadas(){
        String sql="select numCancion, grupo, duracion, titulo, total_votos, codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from canciones inner join grupos on grupo=codgrupo order by total_votos desc limit 5";
        try (PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()){
            List<Cancion> lista= new ArrayList<>();
            while (rs.next()) {      
                Grupo grupo=new Grupo(
                        rs.getInt("codgrupo"),
                        rs.getString("nombre"),
                        rs.getString("localidad"),
                        rs.getString("estilo"),
                        rs.getBoolean("esgrupo"),
                        rs.getInt("annoGrab"),
                        rs.getDate("fechaEstreno"),
                        rs.getString("compania")
                );
                Cancion cancion=new Cancion(
                        rs.getInt("numCancion"),
                        grupo,
                        rs.getTime("duracion"),
                        rs.getString("titulo"),
                        rs.getInt("total_votos")
                );
                lista.add(cancion);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en ActuacionDao.personajesDePeliculas", e);
            return Collections.emptyList();
        }
    }
}

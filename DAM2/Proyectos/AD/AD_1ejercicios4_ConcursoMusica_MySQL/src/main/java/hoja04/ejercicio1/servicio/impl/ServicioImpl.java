/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.servicio.impl;

import hoja04.ejercicio1.bd.ConexionMySQL;
import hoja04.ejercicio1.dao.CancionDao;
import hoja04.ejercicio1.dao.GrupoDao;
import hoja04.ejercicio1.dao.VotoDao;
import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Resultado;
import hoja04.ejercicio1.modelo.Voto;
import hoja04.ejercicio1.servicio.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ServicioImpl implements Servicio {

    private static final Logger LOG = Logger.getLogger(ServicioImpl.class.getName());

    @Override
    public Resultado<List<Grupo>> obtenerGrupos() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            GrupoDao dao = new GrupoDao(c);
            List<Grupo> lista = dao.obtenerGrupos();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener grupos", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<List<Cancion>> obtenerCanciones() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            CancionDao dao = new CancionDao(c);
            List<Cancion> lista = dao.obtenerCanciones();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener canciones", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<Map<String, Integer>> obtenerGruposConNumeroCanciones() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            GrupoDao dao = new GrupoDao(c);
            Map<String, Integer> mapa = dao.obtenerGruposConNumeroCanciones();
            return Resultado.ok(mapa);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener personajes de peliculas", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<List<Cancion>> obtenerCancionesDeGrupo(String nombreGrupo) {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            CancionDao dao = new CancionDao(c);
            List<Cancion> lista = dao.obtenerCancionesDeGrupo(nombreGrupo);
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener canciones", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<List<Cancion>> obtenerCancionesMasVotadas() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            CancionDao dao = new CancionDao(c);
            List<Cancion> lista = dao.cancionesMasVotadas();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener canciones", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<List<Grupo>> obtenerGruposSinCancines() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            GrupoDao dao = new GrupoDao(c);
            List<Grupo> lista = dao.obtenerGruposSinCanciones();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener grupos sin canciones", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }

    }

    @Override
    public Resultado<List<Voto>> obtenerCincoUltimosVotos() {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            VotoDao dao = new VotoDao(c);
            List<Voto> lista = dao.obtenerCincoUltimosVotos();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener votos", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<String> borrarVotosCancionesGrupo(String nombreGrupo) {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            VotoDao dao = new VotoDao(c);
            String resultado = dao.borrarVotosCancionesGrupo(nombreGrupo);
            return Resultado.ok(resultado);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener votos", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<String> borrarCancionesGrupo(String nombreGrupo) {
        Connection conn = ConexionMySQL.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            CancionDao dao = new CancionDao(c);
            String resultado = dao.borrarCancionesGrupo(nombreGrupo);
            return Resultado.ok(resultado);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener votos", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }
}



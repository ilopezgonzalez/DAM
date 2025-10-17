/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.servicio.impl;

import hoja03.ejercicio1.bd.ConexionSQLite;
import hoja03.ejercicio1.dao.ActuacionDao;
import hoja03.ejercicio1.dao.PeliculaDao;
import hoja03.ejercicio1.dao.PersonajeDao;
import hoja03.ejercicio1.modelo.Actuacion;
import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.Personaje;
import hoja03.ejercicio1.modelo.Resultado;
import hoja03.ejercicio1.servicio.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cic
 */
public class ServicioImpl implements Servicio{
    private static final Logger LOG = Logger.getLogger(ServicioImpl.class.getName());
     @Override
    public Resultado<List<Pelicula>> obtenerPeliculas() {
        Connection conn = ConexionSQLite.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            PeliculaDao dao = new PeliculaDao(c);
            List<Pelicula> lista = dao.findAll();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener peliculas", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<List<Personaje>> obtenerPersonajes() {
        Connection conn=ConexionSQLite.getConnection();
        if (conn==null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c=conn){
            PersonajeDao dao=new PersonajeDao(c);
            List<Personaje> lista=dao.findAll();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener personajes", e );
            return Resultado.fail("Error acceddiendo a la base de datos");
        }
        
        
    }

    @Override
    public Resultado<Optional<Personaje>> encontarPorID(int id) {
        Connection conn=ConexionSQLite.getConnection();
        if (conn==null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c=conn){
            PersonajeDao dao=new PersonajeDao(c);
            Optional<Personaje> personaje=dao.encontrarPorID(id);
            return Resultado.ok(personaje);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener personajes", e );
            return Resultado.fail("Error acceddiendo a la base de datos");
        }
        
    }


    @Override
    public Resultado<List<Pelicula>> obtenerPeliculasSinProductor() {
        Connection conn = ConexionSQLite.getConnection();
        if (conn == null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c = conn) {
            PeliculaDao dao = new PeliculaDao(c);
            List<Pelicula> lista = dao.obtenerPeliculasSinProductor();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener peliculas", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }


    @Override
    public Resultado<Optional<Pelicula>> obtenerPeliculaMasantigua() {
        Connection conn=ConexionSQLite.getConnection();
        if (conn==null) {
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c=conn){
            PeliculaDao dao=new PeliculaDao(c);
            Optional<Pelicula> pelicula=dao.obtenerPeliculaMasAntigua();
            return Resultado.ok(pelicula);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener la pelicula", e );
            return Resultado.fail("Error acceddiendo a la base de datos");
        }
        
    }

    @Override
    public Resultado<List<Actuacion>> obtenerPersonajesDePeliculas() {
        Connection conn=ConexionSQLite.getConnection();
        if(conn==null){
            return Resultado.fail("No se pudo conectar a la base de datos");
        }
        try (Connection c=conn){
            ActuacionDao dao=new ActuacionDao(c);
            List<Actuacion> lista=dao.obtenerPersonajesDePeliculas();
            return Resultado.ok(lista);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener personajes de peliculas", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    @Override
    public Resultado<Map<String, Integer>> obtenerActuacionesPorPeliculas() {
        Connection conn=ConexionSQLite.getConnection();
        if (conn==null) {
            return Resultado.fail("No se pudo conectar a la base de datos"); 
        }
        try (Connection c=conn){
            ActuacionDao dao=new ActuacionDao(c);
            Map<String, Integer> mapa=dao.obtenerActuacionesPorPelicula();
            return Resultado.ok(mapa);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener personajes de peliculas", e);
            return Resultado.fail("Error accediendo a la base de datos");
        }
    }

    
    

    
    
}

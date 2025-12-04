/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicioImpl;

import bd.ConexionMySQL;
import dao.PartidoDao;
import dao.SocioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Partido;
import modelo.Resultado;
import modelo.Socio;
import servicio.Servicio;

/**
 *
 * @author alumno
 */
public class ServicioImpl implements Servicio {

    private static final Logger LOG = null;

    @Override
    public Resultado<List<Partido>> obtenerTodosPartidos() {
        PartidoDao dao;
        List<Partido> lista=null;
        Connection conn = ConexionMySQL.getConnection();
        {
            if (conn == null) {
                return Resultado.fail("Error al conectar a la base de datos.");
            }
            try (Connection c = conn) {
                dao = new PartidoDao(c);
                lista = dao.obtenerTodosPartidos();
            } catch (SQLException e) {
                LOG.log(Level.SEVERE, "No se pudo conectar a la BBDD", e);

            }
        }
        return Resultado.ok(lista);

    }

    @Override
    public Resultado<List<Socio>> obtenerSociosReserva() {
        SocioDao dao;
        List<Socio> lista=null;
        Connection conn = ConexionMySQL.getConnection();
        {
            if (conn == null) {
                return Resultado.fail("Error al conectar a la base de datos.");
            }
            try (Connection c = conn) {
                dao = new SocioDao(c);
                lista = dao.obtenerSociosReservas();
            } catch (SQLException e) {
                LOG.log(Level.SEVERE, "No se pudo conectar a la BBDD", e);

            }
        }
        return Resultado.ok(lista);

        
    }

}

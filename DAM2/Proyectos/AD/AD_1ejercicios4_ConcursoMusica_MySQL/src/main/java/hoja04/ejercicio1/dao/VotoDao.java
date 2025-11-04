/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.dao;

import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Resultado;
import hoja04.ejercicio1.modelo.User;
import hoja04.ejercicio1.modelo.Voto;
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
 * @author ASUS
 */
public class VotoDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(GrupoDao.class.getName());

    public VotoDao(Connection conn) {
        this.conn = conn;
    }

    public List<Voto> obtenerCincoUltimosVotos() {
        String sql = "select v.usuario, v.fecha, v.cancion,"
                + " c.numCancion, c.grupo, c.duracion, c.titulo, c.total_votos,"
                + " g.codgrupo, g.nombre, g.localidad, g.estilo, g.esgrupo, g.annoGrab, g.fechaEstreno, g.compania"
                + " u.user, u.password, u.numero_votos"
                + " from votos as v inner join canciones as c on cancion=numCancion inner join grupos as g on grupo=codgrupo inner join usuarios on v.usuario=u.user order by fecha desc limit 5";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Voto> lista = new ArrayList<>();
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
                User usuario= new User(
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getInt("numero_votos"));
                Voto voto = new Voto(
                        usuario,
                        rs.getDate("fecha"),
                        cancion
                );
                lista.add(voto);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en ActuacionDao.personajesDePeliculas", e);
            return Collections.emptyList();
        }
    }

    public Resultado<Integer> borrarVotosCancionesGrupo(String grupo) {
        int filasAfectadas = 0;
        String sql = "Delete from votos where cancion in (select c.numCancion from canciones as c inner join grupos as g on c.grupo=g.codgrupo where nombre=?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, grupo);
            filasAfectadas = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en VotoDao.borrarVotos", e);

        }
        return Resultado.ok(filasAfectadas);
    }

   

}

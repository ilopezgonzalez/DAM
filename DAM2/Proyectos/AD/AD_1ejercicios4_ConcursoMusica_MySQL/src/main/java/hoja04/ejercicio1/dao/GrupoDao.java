/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.dao;

import com.google.protobuf.Internal;
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
public class GrupoDao {
    
    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(GrupoDao.class.getName());

    public GrupoDao(Connection conn) {
        this.conn = conn;
    }
    
    public List<Grupo> obtenerGrupos(){
        String sql ="Select codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from grupos order by codgrupo";
        try (PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()){
            List<Grupo> lista= new ArrayList<>();
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
                lista.add(grupo);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en GrupoDao.obtenerGrupos", e);
            return Collections.emptyList();
        }
        
    
    }
    
}

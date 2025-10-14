/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.dao;

import hoja03.ejercicio1.modelo.Personaje;
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
 * @author damt209
 */
public class PersonajeDao {

    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(PersonajeDao.class.getName());

    public PersonajeDao(Connection conn) {
        this.conn = conn;
    }

    public List<Personaje> findAll() {
        String sql = "Select id, name, powers, company, origin, isHeroe FROM characters order by name";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Personaje> lista = new ArrayList<>();
            while (rs.next()) {
                Personaje p = new Personaje(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("powers"),
                        rs.getString("company"),
                        rs.getString("origin"),
                        rs.getBoolean("isHeroe")
                );
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PersonajeDao.findAll", e);
            return Collections.emptyList();
        }
    }

    public Optional<Personaje> encontrarPorID(int id) {
        String sql = "Select id, name, powers, company, origin, isHeroe FROM characters where id=?";
        Optional<Personaje> p = Optional.empty();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Personaje personaje=new Personaje(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("powers"),
                        rs.getString("company"),
                        rs.getString("origin"),
                        rs.getInt("isHeroe") == 1
                );
                p=Optional.of(personaje);
            }
           

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error en PersonajeDao.encontrarPorID", e);

        }
      return p;  
    }
    
    
}



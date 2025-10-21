/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.dao;

import java.sql.Connection;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ComponenteDao {
    
    private final Connection conn;
    private static final Logger LOG = Logger.getLogger(ComponenteDao.class.getName());

    public ComponenteDao(Connection conn) {
        this.conn = conn;
    }
    
}

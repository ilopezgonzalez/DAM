/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios2_2;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author damt209
 */
public class AD_ejercicios2_2 {

    public static void main(String[] args) throws SQLException, Exception {
        
        Operaciones.consultarRuta();
        Operaciones.insertarRuta();
        Operaciones.consultarRuta();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_tema3_hoja1_hibernate_tradicional;

import com.mycompany.ad_tema3_hoja1_hibernate_tradicional.modelo.Direccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author damt209
 */
public class AD_Tema3_hoja1_Hibernate_Tradicional {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();

        try (SessionFactory sf = cfg.buildSessionFactory(); Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            
            Direccion d=new Direccion("Calle Falsa 123", "Springfield");
            session.persist(d);
            tx.commit();
        } catch (Exception e) {
        }
    }
}

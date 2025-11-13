/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_tema3_hoja1_hibernate;

import Modelo.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author damt209
 */
public class AD_Tema3_hoja1_Hibernate {

    public static void main(String[] args) {
        try (EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hoja01"); EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Direccion d1 = new Direccion("Calle Falsa 678", "Springfield");
            em.persist(d1);
            Direccion d2 = new Direccion("Calle Falsa 689", "Springfield");
            em.persist(d2);
            em.getTransaction().commit();
            System.out.println("Persistido: " + d1);
            System.out.println("Persistido" + d2);
        }
    }
}

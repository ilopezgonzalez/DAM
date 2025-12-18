/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ad_tema3_ejercicio2;

import Modelo.Empleado;
import Modelo.Sueldo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

/**
 *
 * @author ilopezgonzalez
 */
public class AD_Tema3_ejercicio2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("ejercicio2"); EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            
            Empleado emp1=em.find(Empleado.class, 1);
            Empleado emp2=em.find(Empleado.class, 2);
            
            Sueldo sueldo1=new Sueldo();
            sueldo1.setSalario(1000);
            sueldo1.setComision(3);
            em.persist(sueldo1);
            
            Sueldo sueldo2=new Sueldo();
            sueldo2.setSalario(2000);
            sueldo2.setComision(2);
            em.persist(sueldo2);
            
            
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}

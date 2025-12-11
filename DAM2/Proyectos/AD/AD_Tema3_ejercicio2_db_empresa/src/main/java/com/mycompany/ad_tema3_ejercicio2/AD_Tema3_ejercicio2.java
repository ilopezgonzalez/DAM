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
            Empleado emp1=new Empleado("Nacho", "Estudiante", new Sueldo(1000, 10));
            em.persist(emp1);
            Empleado emp2=new Empleado("Juan", "Mecanico", new Sueldo(2000, 11));
            em.persist(emp2);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}

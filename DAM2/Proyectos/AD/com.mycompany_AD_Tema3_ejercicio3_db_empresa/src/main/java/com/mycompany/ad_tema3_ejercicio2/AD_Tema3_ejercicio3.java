/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ad_tema3_ejercicio2;

import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Sueldo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ilopezgonzalez
 */
public class AD_Tema3_ejercicio3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("ejercicio3"); EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Departamento d1= new Departamento(1, "Software", "Santander");
            Departamento d2= new Departamento(2, "Hardware", "Madrid");
            em.persist(d1);
            em.persist(d2);
            
            Empleado emp1=new Empleado("Nacho", "Estudiante", new Sueldo(1000, 10), d1);            
            Empleado emp2=new Empleado("Juan", "Mecanico", new Sueldo(2000, 11), d2);
            em.persist(emp1);
            em.persist(emp2);
            em.getTransaction().commit();
            
            var query=em.createQuery("Select e from Empleado e", Empleado.class);
            List<Empleado> empleados=query.getResultList();
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}

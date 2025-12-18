/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ad_tema3_ejercicio4;

import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Estudio;
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
public class AD_Tema3_ejercicio4 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("ejercicio3"); EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            
            Estudio estudio1=new Estudio();
            estudio1.setEstudio_id(1);
            estudio1.setCodEstudio("ABCDE");
            estudio1.setNombre("LibreSoftware");
            
//            Departamento d1= new Departamento(1, "Software", "Santander");
//            Departamento d2= new Departamento(2, "Hardware", "Madrid");

            Departamento d1=em.find(Departamento.class, 1);
            Departamento d2=em.find(Departamento.class, 2);
            em.persist(d1);
            em.persist(d2);
            
            Empleado emp1=new Empleado();            
            Empleado emp2=new Empleado();
            em.persist(emp1);
            em.persist(emp2);
            em.getTransaction().commit();
            
            emp1.addEstudio(estudio1);
            emp2.addEstudio(estudio1);
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

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
                = Persistence.createEntityManagerFactory("ejercicio4"); EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            
           
//            Departamento d1= new Departamento();
            Departamento d1= em.find(Departamento.class, 1);

//            d1.setDepartamento_id(1);
//            d1.setNombre("Software");
//            d1.setLocalidad("Santander");            
            Departamento d2= em.find(Departamento.class, 2);
            d2.setNombre("Hardware");
            d2.setLocalidad("Madrid");
            
            
            Sueldo sueldo1=new Sueldo();
            sueldo1.setSalario(1000);
            sueldo1.setComision(5);
            Sueldo sueldo2=new Sueldo();
            sueldo2.setSalario(2000);
            sueldo2.setComision(3);
            
            Estudio estudio1=new Estudio();
            estudio1.setNombre("NombreEstudio");
            estudio1.setCodEstudio("AAAAA");
            em.persist(estudio1);
          
            
            Empleado emp1=em.find(Empleado.class, 1);
//            emp1.setNombre("Juan");
//            emp1.setOficio("Pintor");
//            emp1.setSueldo(sueldo1);
//            emp1.setDepartamento(d1);
            Empleado emp2=em.find(Empleado.class, 2);
//            emp2.setNombre("Nacho");
//            emp2.setOficio("Desarrollador");
//            emp2.setSueldo(sueldo2);
//            emp2.setDepartamento(d2);

            emp1.addEstudio(estudio1);
            emp2.addEstudio(estudio1);
            
          
           
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

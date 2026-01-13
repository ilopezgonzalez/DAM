/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package eje.ejemplo;

import eje.ejemplo.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author cic
 */
public class Ejemplo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        try (emf) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Empleado emp = new Empleado();
                emp.setNombre("Ana");
                emp.setEdad(30);
                em.persist(emp);
                em.getTransaction().commit();
                // recuperar el empleado por su id
                System.out.println("empleado generado Id " + emp.getId());
                Empleado emp2 = em.find(Empleado.class, emp.getId());
                if (emp2 != null) {
                    System.out.println(emp.toString());
                }
                //modificar el recuperado 
                em.getTransaction().begin();
                emp2.setEdad(31);
                em.merge(emp2);
                em.getTransaction().commit();
                System.out.println("cambiada la edad " + emp.toString());

                // finalmente borramos el recuperado
//                em.getTransaction().begin();
//                em.remove(emp2);
//                em.getTransaction().commit();
//                // compruebo 
                Empleado emp3 = em.find(Empleado.class, emp.getId());
                if (emp3 == null) {
                    System.out.println("ha sido borrado el empleado");
                }

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }
    }
}

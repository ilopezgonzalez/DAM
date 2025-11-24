/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejemplo.ejpa;


import ejemplo.ejpa.modelo.Telefono;
import ejemplo.ejpa.modelo.Persona;
import ejemplo.ejpa.modelo.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EJPA {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("miPU"); EntityManager em = emf.createEntityManager()) {
            
            em.getTransaction().begin();
            
            Direccion d = new Direccion("Calle Falsa 678", "Springfield");
            em.persist(d);
            
            Persona p = new Persona("Maria", 33);
            p.setDireccion(d);
            Telefono t1 = new Telefono("600111255");
            Telefono t2 = new Telefono("600333455");
            p.addTelefono(t1);
            p.addTelefono(t2);
            
            em.persist(p);
            
            em.getTransaction().commit();
            
           System.out.println("Persistido: " + p); 
           
            
        }
    }
}

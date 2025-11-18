/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejemplo.enativo;

/**
 *
 * @author cic
 */
import ejemplo.enativo.modelo.Direccion;
import ejemplo.enativo.modelo.Persona;
import ejemplo.enativo.modelo.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ENativo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        // No usamos anotaciones, los mappings HBM están en src/main/resources
        // Usamos try-with-resources también para SessionFactory (implementa AutoCloseable)
        try (SessionFactory sf = cfg.buildSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();

            Direccion d = new Direccion("Calle Falsa 123", "Springfield");
            session.persist(d);

            Persona p = new Persona("Juan", 40);
            p.setDireccion(d);
            Telefono t1 = new Telefono("600111222");
            Telefono t2 = new Telefono("600333444");
            p.addTelefono(t1);
            p.addTelefono(t2);

            session.persist(p);

            tx.commit();
            System.out.println("Persistido: " + p);
        }
    }
}

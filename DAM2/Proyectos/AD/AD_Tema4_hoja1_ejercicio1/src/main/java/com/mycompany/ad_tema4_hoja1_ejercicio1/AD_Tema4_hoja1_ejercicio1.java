/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ad_tema4_hoja1_ejercicio1;

import modelo.Grupo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class AD_Tema4_hoja1_ejercicio1 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hoja01");
        EntityManager em=emf.createEntityManager();
        
        
        Scanner teclado= new Scanner (System.in);
        int opcion=0;
        
        
        do {
            
            System.out.println("""
                           1. Añadir grupos
                           2. Añadir Canciones
                           3. Obtener datos de grupo
                           4. Asignar contacto
                           5. Eliminar canciones
                           6. Obtener datos de cancion
                           7. Modificar grupo de canción
                           8. Modificar mail
                           0. Salir
                           """);
            opcion=Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1:
                    anadirGrupos(em);
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                default:
                    System.out.println("Introduce una opcion correcta");
            }
        } while (opcion!=0);
    }
    
    private static void anadirGrupos(EntityManager em){
        try (Connection con=conexion.Conexion.getConnection();
                Statement st=con.createStatement();
                ResultSet rs= st.executeQuery("select * from grupos")){
            
            em.getTransaction().begin();
            em.createQuery("delete from Grupo").executeUpdate();
            em.getTransaction().commit();
            
            while (rs.next()) {
                int id=rs.getInt("codgrupo");
                String nombre=rs.getString("nombre");
                boolean esGrupo=rs.getBoolean("esGrupo");
                String estilo=rs.getString("estilo");
                String localidad=rs.getString("localidad");
                int fechaFund=rs.getInt("annoGrab");
                
                
                
                Grupo g =em.find(Grupo.class, id);
                
                if (g!=null) {
                    System.out.println("El grupo ya existe y no se ha anadido");
                }else{
                    Grupo nuevoGrupo=new Grupo();
                    nuevoGrupo.setIdGrupo(id);
                    nuevoGrupo.setNombre(nombre);
                    nuevoGrupo.setEsGrupo(esGrupo);
                    nuevoGrupo.setEstilo(estilo);
                    nuevoGrupo.setLocalidad(localidad);
                    nuevoGrupo.setYearFundacion(fechaFund);
                    
                    em.getTransaction().begin();
                    em.persist(nuevoGrupo);
                    em.getTransaction().commit();
                }   
            }
            System.out.println("===============================");
            System.out.println("|Grupos cargados correctamente|");
            System.out.println("===============================");
            
        } catch (Exception e) {
            System.out.println("Error al anadir grupos");
            e.printStackTrace();
        }
    }
    
    public static void anadirCanciones(EntityManager em){
        try (Connection con=conexion.Conexion.getConnection();
                Statement st=con.createStatement();
                ResultSet rs= st.executeQuery("select * from grupos")){
            
            
        } catch (Exception e) {
            System.out.println("Error al anadir grupos");
            e.printStackTrace();
        }
    
    }
}

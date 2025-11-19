/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja3_MunicipiosYComarcas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author ilopezgonzalez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int control = 0;

        while (true) {
            System.out.println("""
                               Elige una de las opciones:
                               1. Añadir municipio al fichero de objetos.
                               2. Listar muncipios del fichero de objetos.
                               3. Obtener datos de municipio del fichero de obejtos.
                               4. Modificar el numero de localidades de municipio.
                               5. Eliminar municipio.
                               6. Añadir al fichero de comarcas los municipios.
                               7. Listar el fichero de comarcas.
                               0. Salir.
                               Opcion:
                               """);

            switch (control) {
                case 1:

                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Debes escoger una opcion válida.");
                    ;
            }
        }

    }

    public static void leerMunicipios() {
        File ficheroMuni = new File("municipios.csv");
        File ficheroComar = new File("comarcas.csv");
        HashMap<Integer, Comarca> mapaComarcas = new HashMap<>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroComar))) {
            br.readLine();
            while ((linea = br.readLine()) != null) {                
                StringTokenizer st = new StringTokenizer(linea, ",");
                int codigo = Integer.parseInt(st.nextToken());
                String nombre = st.nextToken();
                Comarca comarca = new Comarca(codigo, nombre);
                mapaComarcas.put(codigo, comarca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader br=new BufferedReader(new FileReader(ficheroMuni))){
            br.readLine();
            while ((linea=br.readLine())!=null) {                
                StringTokenizer st=new StringTokenizer(linea, ",");
            }
        } catch (Exception e) {
        }
    }

}

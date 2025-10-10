/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class AD_ejercicios1_3 {

    private static final String CSV_FILE = "municipios.csv";
    private static final String BIN_FILE = "municipios.dat";

    public static void main(String[] args) {
            
            mostrarMunicipios(leerCSVConStringTokenizer());

//        int control = 0;
//
//        do {
//            Scanner input = new Scanner(System.in);
//            System.out.println("""
//                               Elige una de las opciones:
//                               1. Añadir municipio al fichero de objetos.
//                               2. Listar minicipios del fichero de objetos.
//                               3. Obtener datos de municipio del fichero de objetos.
//                               4. Modificar numero de localidades de municipio.
//                               5. Eliminar municipio.
//                               6. Añadir al fichero de comarcas los municipios.
//                               7. Listar le fichero de comarcas.
//                               0. SALIR""");
//            control = Integer.parseInt(input.nextLine());
//
//            switch (control) {
//                case 1:
//                    File fichero = new File("municipios.csv");
//                    escribirDatos(fichero);
//                    break;
//                case 2:
//                    listarMunicipios();
//                default:
//                    throw new AssertionError();
//            }
//
//        } while (control != 0);
    }

    public static void escribirDatos(File fichero) {
    
    }

    public static void listarMunicipios() {
       
    }

    private static ArrayList<Municipio> leerCSVConStringTokenizer() {
        ArrayList<Municipio> lista = new ArrayList<>();

        try (
            FileInputStream fis = new FileInputStream(CSV_FILE);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"))
        ) {
            String linea = br.readLine(); // Saltamos la cabecera

            while ((linea = br.readLine()) != null) {
                //Esta linea hace que si hay lineas en blanco las omita y no de error
                if (linea.trim().isEmpty()) continue;

                // Tokenizamos por comas
                StringTokenizer st = new StringTokenizer(linea, ",");

                // Leemos los campos en orden
                st.nextToken(); // id (lo ignoramos)
                int codigo = Integer.parseInt(st.nextToken());
                String nombre = st.nextToken();
                float extension = Float.parseFloat(st.nextToken());
                int habitantes = Integer.parseInt(st.nextToken());
                st.nextToken(); // url_bandera (lo ignoramos)
                int codigoComarca = Integer.parseInt(st.nextToken());
                int numLocalidades = Integer.parseInt(st.nextToken());

                // Creamos los objetos
                Comarca comarca = new Comarca(codigoComarca, "");
                Municipio municipio = new Municipio(codigo, nombre, extension, habitantes, numLocalidades, comarca);

                lista.add(municipio);
            }

            System.out.println("CSV leído correctamente con StringTokenizer.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    private static void mostrarMunicipios(ArrayList<Municipio> lista) {
        System.out.println("\n--- Municipios cargados desde CSV ---");
        for (Municipio m : lista) {
            System.out.println(m);
        }
    }

}

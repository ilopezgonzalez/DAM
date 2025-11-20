/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja3_MunicipiosYComarcas;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Main {

    private static Scanner teclado = new Scanner(System.in);

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
            control=Integer.parseInt(teclado.nextLine());

            switch (control) {
                case 1:
                    escribirDatos(leerMunicipios());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Debes escoger una opcion válida.");
                    ;
            }
        }

    }

    public static ArrayList<Municipio> leerMunicipios() {
        File ficheroMuni = new File("municipios.csv");
        File ficheroComar = new File("comarcas.csv");
        HashMap<Integer, Comarca> mapaComarcas = new HashMap<>();
        ArrayList<Municipio> listaMunicipios = new ArrayList<>();
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
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroMuni))) {
            br.readLine();

            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                st.nextToken();
                int codigo = Integer.parseInt(st.nextToken());
                String nombre = st.nextToken();
                float extension = Float.parseFloat(st.nextToken());
                int habitantes = Integer.parseInt(st.nextToken());
                st.nextToken().trim();
                int codComarca = Integer.parseInt(st.nextToken());
                Comarca com = mapaComarcas.get(codComarca);
                if (com == null) {
                    System.out.println("Error, comarca no encontrada.");
                }
                int numLocalidades = Integer.parseInt(st.nextToken());
                Municipio municipio = new Municipio(codigo, nombre, extension, habitantes, com, numLocalidades);
                listaMunicipios.add(municipio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMunicipios;
    }

    public static void escribirDatos(ArrayList<Municipio> lista) {
        Municipio muni = null;
        int codigoMuni = 0;
        boolean existeArchivo = new File("municipios.obj").exists();
        boolean comprobadoCSV = false;
        System.out.println("Introduce el codigo del municipio que quieres añadir al fichero de objetos.");
        codigoMuni = Integer.parseInt(teclado.nextLine());
        for (Municipio municipio : lista) {
            if (municipio.getCodigo() == codigoMuni) {
                muni = municipio;
                comprobadoCSV=true;
            }
        }
        if (!comprobarExisteMunicipio(codigoMuni)) {
            try (FileOutputStream fos = new FileOutputStream("municipios.obj", true)) {
                ObjectOutputStream oos;
                if (!existeArchivo) {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(muni);
                } else {
                    oos = new MiObjectOutputStream(fos);
                    oos.writeObject(muni);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El municipo ya se encuentra en el fichero de objetos");
        }
        if (!comprobadoCSV) {
            System.out.println("El municipio no se encuentra en el archivo CSV");
        }
    }

    private static boolean comprobarExisteMunicipio(int codigoBuscar) {
        boolean salida = false;
        try {
            FileInputStream fis = new FileInputStream("municipios.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    Municipio munBuscar = (Municipio) ois.readObject();
                    if (munBuscar.getCodigo() == codigoBuscar) {
                        salida = true;
                        System.out.println("El municipio ya se encuentra en el archivo");
                    }

                } catch (EOFException e) {
                    System.out.println("Fin del archivo de objetos alcanzado sin encontrar dicho municipio.");
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!salida) {
                System.out.println("Se escribira el municipio");
            }
        } catch (IOException e) {
        }

        return salida;
    }
}

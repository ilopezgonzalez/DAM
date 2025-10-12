/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_3;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */

public class AD_ejercicios1_3 {


    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        mostrarMunicipiosObjetos();

        int control = 0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                               Elige una de las opciones:
                               1. Añadir municipio al fichero de objetos.
                               2. Listar minicipios del fichero de objetos.
                               3. Obtener datos de municipio del fichero de objetos.
                               4. Modificar numero de localidades de municipio.
                               5. Eliminar municipio.
                               6. Añadir al fichero de comarcas los municipios.
                               7. Listar le fichero de comarcas.
                               0. SALIR""");
            control = Integer.parseInt(input.nextLine());

            switch (control) {
                case 1:
                    escribirDatos(leerCSVMunicipiosConStringTokenizer());
                    break;
                case 2:
                    mostrarMunicipiosObjetos();
                    break;
                case 3:
                    mostrarMunicipiosObjetosPorCodigo();
                    break;
                case 4:
                    tecladoCodigoModificar();
                case 5:
                    tecladoCodigoBorrar();
                case 6:
                    combinarListas();

            }

        } while (control != 0);
    }
    
    public static void escribirDatos(ArrayList<Municipio> lista) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        boolean comprobadoCSV = false;
        Municipio muni = null;
        boolean existeArchivo = new File("municipios.obj").exists();
        System.out.println("Introduce el codigo del municipio que quiere copiar al archivo: ");
        int codigoMuni = Integer.parseInt(teclado.nextLine());
        for (Municipio municipio : lista) {
            if (municipio.getCodigo() == codigoMuni) {
                muni = municipio;
                comprobadoCSV = true;
                break;
            }
        }

        if (!comprobarExisteMunicipio(codigoMuni)) {
            try (FileOutputStream fos = new FileOutputStream("municipios.obj", true);) {
                ObjectOutputStream oos;
                if (!existeArchivo) {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(muni);

                    System.out.println("Municipio escrito como objeto");
                } else {
                    oos = new MiObjectOutputStream(fos);
                    oos.writeObject(muni);
                    System.out.println("Municipio escrito como objeto");

                }
            } catch (Exception e) {
            }
        } else {
            System.out.println("El municipio ya estaba en el archivo de objetos");
        }
        if (comprobadoCSV) {
            System.out.println("Municipio encontrado en el CSV");
        } else {
            System.out.println("Municipio No encontrado en el CSV");
        }
    }

    private static void mostrarMunicipiosObjetos() {
        try (FileInputStream fis = new FileInputStream("municipios.obj"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Municipio muni = null;
            while (true) {
                try {
                    muni = (Municipio) ois.readObject();
                    System.out.println(muni.toString());
                } catch (EOFException e) {
                    e.getMessage();
                    break;
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void mostrarMunicipiosObjetosPorCodigo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el codigo que quieras buscar en el archivo de objetos:");
        int codigoMuni = Integer.parseInt(teclado.nextLine());
        boolean encontrado = true;
        try (FileInputStream fis = new FileInputStream("municipios.obj"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Municipio muni = null;
            while (true) {
                try {
                    muni = (Municipio) ois.readObject();
                    if (muni.getCodigo() == codigoMuni) {
                        System.out.println(muni.toString());
                    } else {
                        encontrado = false;
                    }
                } catch (EOFException e) {
                    e.getMessage();
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se ha encontrado el municipio en el archivo de objetos");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void tecladoCodigoModificar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el codigo que quieras buscar en el archivo de objetos:");
        int codigoMuni = Integer.parseInt(teclado.nextLine());
        boolean encontrado = true;
        ArrayList<Municipio>lista=new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("municipios.obj"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Municipio muni = null;
            while (true) {
                muni=(Municipio)ois.readObject();
                lista.add(muni);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo()==codigoMuni) {
                System.out.println("¿Cuantas localidades quieres que tenga ahora?:");
                int nuevasLocalidades=Integer.parseInt(teclado.nextLine());
                lista.get(i).setNum_localidades(nuevasLocalidades);                
            }
        }
        try (FileOutputStream fos=new FileOutputStream("municipios.obj");
                ObjectOutputStream oos=new ObjectOutputStream(fos)) {
                for (Municipio municipio : lista) {
                oos.writeObject(municipio);
            }
            
        } catch (Exception e) {
        }
    }
    
    private static void tecladoCodigoBorrar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el codigo que quieras buscar en el archivo de objetos:");
        int codigoMuni = Integer.parseInt(teclado.nextLine());
        boolean encontrado = true;
        ArrayList<Municipio>lista=new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("municipios.obj"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Municipio muni = null;
            while (true) {
                muni=(Municipio)ois.readObject();
                lista.add(muni);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo()==codigoMuni) {
                lista.remove(i);
            }
        }
        try (FileOutputStream fos=new FileOutputStream("municipios.obj");
                ObjectOutputStream oos=new ObjectOutputStream(fos)) {
                for (Municipio municipio : lista) {
                oos.writeObject(municipio);
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void combinarListas(){
        ArrayList<String> al=new ArrayList<>();
        Scanner teclado=new Scanner(System.in);
        
        for (Comarca comarca : leerCSVComarcasConStringTokenizer()) {
            System.out.println(comarca.toString());
        }
        System.out.println("Elige un codigo de comarca: ");
        int numComarca=Integer.parseInt(teclado.nextLine());
        
        for (Comarca comarca : leerCSVComarcasConStringTokenizer()) {
            for (Municipio municipio : leerCSVMunicipiosConStringTokenizer()) {
                if (numComarca==comarca.getCodigoComarca()&&comarca.getCodigoComarca()==municipio.getC().getCodigoComarca()) {    
                    al.add(municipio.getNombre());
                }
            }
        }
        for (String string : al) {
            System.out.println(string);
        }
    }
    

    

   
    private static ArrayList<Municipio> leerCSVMunicipiosConStringTokenizer() {
        ArrayList<Municipio> listaMunicipios = new ArrayList<>();

        try (
                FileReader fr = new FileReader("municipios.csv"); BufferedReader br = new BufferedReader(fr)) {
            String linea = br.readLine(); // Saltamos la cabecera

            while ((linea = br.readLine()) != null) {
                //Esta linea hace que si hay lineas en blanco las omita y no de error
                if (linea.trim().isEmpty()) {
                    continue;
                }

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

                listaMunicipios.add(municipio);
            }

            System.out.println("CSV leído correctamente con StringTokenizer.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaMunicipios;
    }
    private static ArrayList<Comarca> leerCSVComarcasConStringTokenizer() {
        ArrayList<Comarca> listaComarcas = new ArrayList<>();

        try (
                FileReader fr = new FileReader("comarcas.csv"); BufferedReader br = new BufferedReader(fr)) {
            String linea = br.readLine(); // Saltamos la cabecera

            while ((linea = br.readLine()) != null) {
                //Esta linea hace que si hay lineas en blanco las omita y no de error
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Tokenizamos por comas
                StringTokenizer st = new StringTokenizer(linea, ",");

                // Leemos los campos en orden
                int codigoComarca = Integer.parseInt(st.nextToken());
                String nombre = st.nextToken();
                

                // Creamos los objetos
                Comarca comarca = new Comarca(codigoComarca, nombre);

                listaComarcas.add(comarca);
            }

            System.out.println("CSV leído correctamente con StringTokenizer.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaComarcas;
    }

    private static boolean comprobarExisteMunicipio(int codigoBuscar) throws IOException, ClassNotFoundException {
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
                    } else {
                        System.out.println("Se escribira el municipio");
                    }
                } catch (EOFException e) {
                    System.out.println("Fin del archivo alcanzado.");
                    break;
                }
            }

        } catch (Exception e) {
        }

        return salida;
    }

}

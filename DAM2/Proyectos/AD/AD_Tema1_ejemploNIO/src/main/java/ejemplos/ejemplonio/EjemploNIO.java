/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejemplos.ejemplonio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author cic
 */
public class EjemploNIO {

    public static void main(String[] args) {
        //EJEMPLO 1: Comprobar existencia de un fichero por su Path.
        Path rutaEj = Paths.get("D:\\MiCarpeta\\ejemplo1.txt");
        if (Files.notExists(rutaEj)) {
            System.out.println("No existe el fichero");
        } else {
            System.out.println("Existe el fichero");
        }

        //EJEMPLO 2: Crear fichero, si no existe, en carpeta de trabajo actual
        Path ruta = Paths.get("ejemplo5.txt");
        if (Files.notExists(ruta)) {
            System.out.println("La ruta no existe");
            try {
                Files.createFile(ruta);
            } catch (IOException e) {
                System.err.println("Error de E/S al crear el fichero");
            }
        }

        /*EJEMPLO 3: Un fichero NO regular podrá ser un enlace simbólico o un directorio.
        Comprobar el tipo de elemento que corresponde al Path ruta*/
        if (Files.isRegularFile(ruta)) {
            System.out.println("El fichero " + ruta.toString() + " es regular");
        } else {
            if (Files.isDirectory(ruta)) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("Es un enlace simbólico (Linux)");
            }
        }
        /*EJEMPLO 4: Comprobar permiso de escritura*/
        Path ruta2 = Paths.get("ejemplo5.txt");
        if (Files.isWritable(ruta2)) {
            System.out.println("Tenemos permisos para escribir");
        }
        /*EJEMPLO 5: Comprobar si dos path ruta y ruta2 corresponden al mismo fichero*/
        try {
            if (Files.isSameFile(ruta, ruta2)) {
                System.out.println("Son el mismo fichero");
            }
        } catch (IOException e) {
            System.err.println("Error de E/S al comparar los dos ficheros");
        }
        /*EJEMPLO 6: listar el contenido de un directorio*/
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:\\Users\\cic\\Documents\\Curso24-25"));
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }

        } catch (IOException ex) {
            System.err.println("Error");
        }

    }
}

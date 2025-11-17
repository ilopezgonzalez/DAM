package psp_hoja4_12_leerjar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSP_hoja4_1_ZLeerJar {

   public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1) Especificar la ruta completa del JAR que queremos ejecutar
        // ------------------------------------------------------------
        // Nota: ajusta esta ruta a donde esté tu archivo .jar
        String rutaJar = "C:\\Users\\ASUS\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\PSP_hoja4_1_SalidaJAR\\dist\\PSP_hoja4_12_SalidaJAR.jar";

        // ------------------------------------------------------------
        // 2) Crear el comando con ProcessBuilder
        //    - "java" -> ejecuta la JVM
        //    - "-jar" -> indica que vamos a ejecutar un archivo JAR
        //    - rutaJar -> ruta del archivo JAR a ejecutar
        // ------------------------------------------------------------
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", rutaJar);

        try {
            // ------------------------------------------------------------
            // 3) Iniciar el proceso
            // ------------------------------------------------------------
            Process proceso = pb.start();

            // ------------------------------------------------------------
            // 4) Leer la salida estándar del proceso (stdout)
            //    - Esto captura todo lo que el JAR imprime normalmente
            // ------------------------------------------------------------
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) { // leer línea por línea hasta EOF
                    System.out.println("[JAR] " + linea); // mostrar en consola con prefijo
                }
            }

            // ------------------------------------------------------------
            // 5) Leer la salida de errores del proceso (stderr)
            //    - Esto captura errores que el JAR pueda generar
            // ------------------------------------------------------------
            try (BufferedReader brErr = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
                String linea;
                while ((linea = brErr.readLine()) != null) {
                    System.err.println("[ERROR JAR] " + linea); // mostrar errores con prefijo
                }
            }

            // ------------------------------------------------------------
            // 6) Esperar a que el proceso termine
            //    - waitFor() devuelve el código de salida del proceso
            //      0 normalmente significa éxito, cualquier otro valor indica error
            // ------------------------------------------------------------
            int resultado = proceso.waitFor();
            System.out.println("El proceso terminó con código: " + resultado);

        } catch (IOException | InterruptedException e) {
            // ------------------------------------------------------------
            // Captura de excepciones si falla la ejecución del JAR
            // IOException -> problemas al iniciar el proceso
            // InterruptedException -> si el waitFor() es interrumpido
            // ------------------------------------------------------------
            e.printStackTrace();
        }
    }
}
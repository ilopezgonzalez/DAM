/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_convertirenmayusculas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ConvierteMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1) Pedimos al usuario una cadena desde la consola
        // ------------------------------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una palabra para convertirla a MAYUSCULAS:");
        // Leemos la línea introducida y aplicamos trim() para quitar espacios al inicio/fin
        String entrada = input.nextLine().trim();

        // ------------------------------------------------------------
        // 2) Preparamos y lanzamos el proceso externo (convMayus.exe)
        //    - En Windows: "cmd /c convMayus.exe" ejecuta el programa convMayus.exe
        //    - El proceso arrancará y permitirá interacción a través de sus streams
        // ------------------------------------------------------------
        try {
            // comando como array de Strings: cada elemento es un token del comando
            String[] comando = {"cmd", "/c", "convMayus.exe"};

            // ProcessBuilder crea la descripción del proceso; start() lo inicia
            Process p = new ProcessBuilder(comando).start();

            // ------------------------------------------------------------
            // 3) Enviar datos AL PROCESO hijo (entrada estándar del proceso)
            //    - p.getOutputStream() nos da el stream para escribir en stdin del proceso
            //    - Envolvemos en OutputStreamWriter/BufferedWriter para escribir Strings cómodamente
            // ------------------------------------------------------------
            try (OutputStream os = p.getOutputStream();
                 OutputStreamWriter osw = new OutputStreamWriter(os);
                 BufferedWriter bw = new BufferedWriter(osw)) {

                // Escribimos la cadena que queremos pasar al programa externo
                bw.write(entrada);
                // Añadimos un salto de línea: muchos programas leen hasta '\n'
                bw.newLine();
                // Forzamos que los datos salgan inmediatamente al proceso hijo
                bw.flush();

                // ------------------------------------------------------------
                // 4) Leer la salida DEL PROCESO hijo (su stdout)
                //    - p.getInputStream() nos da lo que el proceso escribe en stdout
                //    - Envolvemos en InputStreamReader/BufferedReader para leer líneas
                // ------------------------------------------------------------
                InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                // Leemos la primera línea de la salida (si el programa devuelve varias, podrías leer en bucle)
                String salida = br.readLine();
                System.out.println("Salida proceso hijo: " + salida);

                // NOTA: br no se cierra explícitamente aquí (podrías cerrarlo con try-with-resources).
                // Al salir del try-with-resources anterior se cerrará el OutputStream y se liberarán recursos,
                // pero sería más completo usar try-with-resources también para 'br'.

            } catch (IOException e) {
                // ------------------------------------------------------------
                // Captura de excepciones al escribir en stdin o leer stdout del proceso
                // Aquí sería recomendable informar del error; ahora está vacío.
                // ------------------------------------------------------------
                System.err.println("Error al comunicarse con el proceso: " + e.getMessage());
            }
        } catch (IOException e) {
            // ------------------------------------------------------------
            // Captura de excepciones al iniciar el proceso (por ejemplo, si convMayus.exe no existe)
            // ------------------------------------------------------------
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }

        // IMPORTANTE: el Scanner 'input' queda abierto; cerrarlo al final es buena práctica:
        input.close();
    }

}
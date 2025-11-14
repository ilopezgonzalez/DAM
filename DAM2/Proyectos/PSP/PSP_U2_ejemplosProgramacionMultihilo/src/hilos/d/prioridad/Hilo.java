/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.d.prioridad;

public class Hilo extends Thread {

    /**
     * ************************************************************************
     * constructor por defecto
     */
    public Hilo() {
        //hereda la prioridad del hilo padre
    }

    /**
     * ************************************************************************
     * constructor personalizado
     */
    public Hilo(int prioridad) {

        //establece la prioridad indicada
        this.setPriority(prioridad);
    }

    /**
     * ************************************************************************
     * ejecuta una tarea pesada
     */
    @Override
    public void run() {

        //cadena
        String strCadena = "";

        //agrega 20000 caracteres a una cadena vacía
        for (int i = 0; i < 20000; ++i) {
            //imprime el valor en la Salida
            strCadena += "A";
            Thread.yield();
            //yield()sugiere al planficador Java que puede seleccionar otro hilo,

        }

        System.out.println("Hilo de prioridad " + this.getPriority()
                + " termina ahora");
    }
}

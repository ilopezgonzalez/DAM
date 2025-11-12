/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.e.egoistas;



public class Main {

    public static void main(String[] args) {
        //se crean dos hilos: hrojo y hazul
        Color hrojo = new Color("Rojo");
        Color hazul = new Color("Azul");
        //se inician los hilos para su ejecución
        hrojo.start();
        hazul.start();
    }
}

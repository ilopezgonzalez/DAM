/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.b.estados;


public class Hilo_Auxiliar extends Thread {
//código del hilo

    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + ",");
        }
    }
}

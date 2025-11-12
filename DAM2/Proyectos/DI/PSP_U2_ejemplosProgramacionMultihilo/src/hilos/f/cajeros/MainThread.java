package hilos.f.cajeros;

/**
 *
 * @author Richard
 */
public class MainThread {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CajeroThread cajera1 = new CajeroThread("Cajera 1", cliente1, initialTime);
		CajeroThread cajera2 = new CajeroThread("Cajera 2", cliente2, initialTime);

		cajera1.start();
		cajera2.start();
	}
}
package ejemplos.logger;

import java.util.logging.Logger;

public class ServicioPedidos {
    
    public static final Logger logger = Logger.getLogger("AppLogger");

    private int stock = 5;

    public void procesarPedido(int cantidad) {

        logger.info("Procesando pedido. Cantidad solicitada: " + cantidad);

        if (cantidad <= stock) {
            stock -= cantidad;
            logger.info("Pedido procesado correctamente. Stock restante: " + stock);
        } else if (stock > 0) {
            logger.warning("Stock insuficiente. Disponible: " + stock);
        } else {
            logger.severe("Error crítico: no queda stock disponible");
        }
    }
}

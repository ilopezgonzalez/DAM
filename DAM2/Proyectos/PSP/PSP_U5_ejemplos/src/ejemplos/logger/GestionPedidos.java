package ejemplos.logger;
import java.util.logging.Logger;

public class GestionPedidos {

    private static final Logger logger = Logger.getLogger(GestionPedidos.class.getName());

    public static void main(String[] args) {

        logger.info("Inicio del sistema de gestión de pedidos");

        int stockDisponible = 5;
        int cantidadSolicitada = 8;

        if (cantidadSolicitada <= stockDisponible) {
            logger.info("Pedido procesado correctamente. Cantidad: " + cantidadSolicitada);
        } else if (stockDisponible > 0) {
            logger.warning("Stock insuficiente. Disponible: " 
                           + stockDisponible + ", solicitado: " + cantidadSolicitada);
        } else {
            logger.severe("Error crítico: no hay stock disponible para procesar el pedido");
        }

        logger.info("Fin del proceso de pedidos");
    }
}

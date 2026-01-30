package ejemplos.logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GestionPedidosConFich {

    private static final Logger logger = Logger.getLogger(GestionPedidosConFich.class.getName());

    public static void main(String[] args) {

        configurarLogger();

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

    private static void configurarLogger() {
        try {
            // Crear handler para escribir en fichero
            FileHandler fileHandler = new FileHandler("pedidos.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            // Evita que se duplique el log en consola
            //logger.setUseParentHandlers(false);

        } catch (IOException e) {
            System.err.println("No se pudo configurar el logger: " + e.getMessage());
        }
    }
}

package ejemplos.logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GestionPedidosConFich2 {

    // Logger compartido por toda la aplicación
    public static final Logger logger = Logger.getLogger("AppLogger");

    public static void main(String[] args) {

        configurarLogger();

        logger.info("Aplicación iniciada");

        ServicioPedidos servicio = new ServicioPedidos();
        servicio.procesarPedido(3);
        servicio.procesarPedido(10);

        logger.info("Aplicación finalizada");
    }

    private static void configurarLogger() {
        try {
            FileHandler fileHandler = new FileHandler("aplicacion.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            //logger.setUseParentHandlers(false);

        } catch (IOException e) {
            System.err.println("Error configurando el logger: " + e.getMessage());
        }
    }
}

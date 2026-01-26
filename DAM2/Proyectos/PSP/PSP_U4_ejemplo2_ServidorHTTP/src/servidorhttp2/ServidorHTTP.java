package servidorhttp2;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServidorHTTP {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String ruta = exchange.getRequestURI().getPath();
                String respuesta;

                switch (ruta) {
                    case "/hola":
                        respuesta = "Hola desde el servidor";
                        break;
                    case "/fecha":
                        respuesta = java.time.LocalDateTime.now().toString();
                        break;
                    default:
                        respuesta = "Ruta no encontrada: " + ruta;
                }

                exchange.sendResponseHeaders(200, respuesta.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(respuesta.getBytes());
                os.close();
            }
        });

        server.start();
        System.out.println("Servidor escuchando en http://localhost:8080");
    }
}

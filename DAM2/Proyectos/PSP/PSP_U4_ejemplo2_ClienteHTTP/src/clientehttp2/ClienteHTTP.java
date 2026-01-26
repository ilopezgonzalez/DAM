package clientehttp2;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClienteHTTP {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce una ruta (/hola, /fecha, salir): ");
            String ruta = sc.nextLine();

            if (ruta.equalsIgnoreCase("salir")) {
                break;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080" + ruta))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código HTTP: " + response.statusCode());
            System.out.println("Respuesta: " + response.body());
            System.out.println("------------------------");
        }

        sc.close();
    }
}

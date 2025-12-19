import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0);

        server.createContext("/usuario", exchange -> {

            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String query = exchange.getRequestURI().getQuery();
            String id = getParam(query, "id");

            String response;

            if (id == null) {
                response = "{\"error\":\"falta parametro id\"}";
                exchange.sendResponseHeaders(400, response.length());
            } else {
                response = "{\"id\":" + id + ",\"username\":\"Usuario " + id + "\"}";
                exchange.sendResponseHeaders(200, response.length());
            }

            exchange.getResponseHeaders()
                    .add("Content-Type", "application/json");

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();
        System.out.println("Servidor Java en http://localhost:8080");
    }

    private static String getParam(String query, String key) {
        if (query == null)
            return null;

        String[] params = query.split("&");
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair.length == 2 && pair[0].equals(key)) {
                return pair[1];
            }
        }
        return null;
    }
}

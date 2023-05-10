import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {
    private int port;

    public TcpIpServer(int port) {
        this.port = port;
    }

    public void startListening() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.handleClient();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

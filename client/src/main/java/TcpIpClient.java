import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient {
    private String serverIp;
    private int serverPort;

    public TcpIpClient(String serverIp, int serverPort) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public String requestVehicleInsuranceOffers(String userId) {
        try (Socket socket = new Socket(serverIp, serverPort);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            output.println(userId);
            StringBuilder responseText = new StringBuilder();
            String line;
            while((line = input.readLine()) != null){
                responseText.append(line).append("\n");
            }
            return responseText.toString();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }
    }
}

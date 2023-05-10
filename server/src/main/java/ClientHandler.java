import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void handleClient() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            String userId = input.readLine();
            System.out.println("User id: " + userId);
            String response = DatabaseManager.getVehicleInsuranceOffers(userId);
            if(response.length() == 0){
                response = "User not found in the database or there is no data offers for you.";
            }
            output.println(response);
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TcpIpClient client = new TcpIpClient("127.0.0.1", 12345);
        Scanner scanner = new Scanner(System.in);
        int givenId;
        System.out.println("Please give yours id number: ");
        while (!scanner.hasNextInt()){
            System.out.println("The given value is not an integer!");
            System.out.println("Please enter a valid value: ");
            scanner.next();
        }
        String userId = Integer.toString(scanner.nextInt());
        String response = client.requestVehicleInsuranceOffers(userId);
        System.out.println("Received data:\n" + response);
    }
}

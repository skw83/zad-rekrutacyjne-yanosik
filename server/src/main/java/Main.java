public class Main {
    public static void main(String[] args) {
        TcpIpServer server = new TcpIpServer(12345);
        server.startListening();
    }
}

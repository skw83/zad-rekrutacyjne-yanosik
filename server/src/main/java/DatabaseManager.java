import java.sql.*;

public class DatabaseManager {

    private static final String DB_SERVER = "jdbc:mysql://localhost:3306/?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "DataStore1root@";
    private static final String query = "SELECT v.brand, v.model, io.insurer, io.price, io.insurance_options "
            + "FROM insurance_db.vehicles v "
            + "JOIN insurance_db.insurance_offers io ON v.id = io.vehicle_id "
            + "JOIN insurance_db.users u ON v.login = u.login "
            + "WHERE u.id = ?";

    public static String getVehicleInsuranceOffers(String userId) throws SQLException {


        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(DB_SERVER, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setLong(1, Long.parseLong(userId));

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.append("Brand: ").append(rs.getString("brand")).append(", ");
                    result.append("Model: ").append(rs.getString("model")).append(", ");
                    result.append("Insurer: ").append(rs.getString("insurer")).append(", ");
                    result.append("Insurer options: ").append(rs.getString("insurance_options")).append(", ");
                    result.append("Price: ").append(rs.getFloat("price")).append("\n");
                }
            }
        }

        return result.toString();
    }
}

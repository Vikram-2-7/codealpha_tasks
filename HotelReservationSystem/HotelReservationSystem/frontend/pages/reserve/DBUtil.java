package frontend.pages.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }

        String url = "jdbc:mysql://localhost:3306/hotel_db?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "valorous@123";

      
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("✅ Connected to MySQL successfully!");
        return conn;
    }
}

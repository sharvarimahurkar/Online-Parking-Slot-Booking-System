import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/parkingdb",
                    "root",
                    "your_password"
            );
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            return null;
        }
    }
}

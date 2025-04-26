package al.sda.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConfig {


        private static final String URL = "jdbc:mysql://localhost:3306/airbnb_sql";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public static void main(String[] args) {
            try (Connection conn = getConnection()) {
                if (conn != null) {
                    System.out.println("Connected to the database!");
                }
            } catch (SQLException e) {
                System.out.println(" Connection failed!");
                e.printStackTrace();
            }
        }
    }


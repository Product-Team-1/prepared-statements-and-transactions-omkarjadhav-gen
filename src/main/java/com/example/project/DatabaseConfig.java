package com.example.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }

    public static void initialiseDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE accounts (id INT PRIMARY KEY, name VARCHAR(50), balance DECIMAL)");
            stmt.execute("INSERT INTO accounts VALUES (1, 'Alice', 1000)");
            stmt.execute("INSERT INTO accounts VALUES (2, 'Bob', 1000)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

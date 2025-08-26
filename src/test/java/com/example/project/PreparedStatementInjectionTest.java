package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class PreparedStatementInjectionTest {

    @BeforeEach
    void setup() {
        DatabaseConfig.initialiseDatabase();
    }

    @Test
    void testPreparedStatementPreventsInjection() throws SQLException {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String maliciousName = "Eve'); DROP TABLE accounts; --";
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES (?, ?, ?)")) {
                ps.setInt(1, 3);
                ps.setString(2, maliciousName);
                ps.setDouble(3, 500);
                ps.executeUpdate();
            }

            ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM accounts");
            rs.next();
            int count = rs.getInt(1);
            assertEquals(3, count, "Accounts table should not be dropped.");
        }
    }
}

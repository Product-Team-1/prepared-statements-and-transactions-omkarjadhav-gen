package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionRollbackTest {

    @BeforeEach
    void setup() {
        DatabaseConfig.initialiseDatabase();
    }

    @Test
    void testTransactionRollbackOnFailure() throws SQLException {
        TransactionService service = new TransactionService();

        try {
            service.transferFunds(1, 2, 200, true);
            fail("Expected exception due to simulated failure");
        } catch (Exception ignored) {}

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT balance FROM accounts WHERE id=1")) {
            rs.next();
            double balance = rs.getDouble(1);
            assertEquals(1000.0, balance, "Balance should remain unchanged after rollback");
        }
    }
}

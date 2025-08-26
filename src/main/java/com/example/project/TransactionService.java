package com.example.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionService {

    public void transferFunds(int fromId, int toId, double amount, boolean triggerError) throws SQLException {
        try (Connection conn = DatabaseConfig.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement withdraw = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement deposit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

                withdraw.setDouble(1, amount);
                withdraw.setInt(2, fromId);
                withdraw.executeUpdate();

                if (triggerError) {
                    throw new RuntimeException("Simulated failure!");
                }

                deposit.setDouble(1, amount);
                deposit.setInt(2, toId);
                deposit.executeUpdate();

                conn.commit();
                System.out.println("Transaction committed successfully.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
                throw e;
            }
        }
    }
}

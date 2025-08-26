package com.example.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * TODOs:
 *  - Turn off auto-commit and start a transaction.
 *  - Withdraw 'amount' from 'fromId' using a PreparedStatement.
 *  - (If triggerError == true) throw an exception AFTER the withdraw and BEFORE the deposit.
 *  - Deposit 'amount' into 'toId' using a PreparedStatement.
 *  - Commit on success; rollback on any exception.
 *  - Print simple logs for: start, each SQL, commit, rollback.
 */
public class TransactionService {

    /**
     * @param fromId source account id
     * @param toId destination account id
     * @param amount amount to transfer
     * @param triggerError if true, simulate a failure mid-transaction to test rollback
     */
    public void transferFunds(int fromId, int toId, double amount, boolean triggerError) throws SQLException {
        // TODO: implement using a single DB transaction and PreparedStatement only.
        try (Connection conn = DatabaseConfig.getConnection()) {
            // TODO: conn.setAutoCommit(false);

            // TODO: try-with-resources for two PreparedStatements:
            //  UPDATE accounts SET balance = balance - ? WHERE id = ?
            //  UPDATE accounts SET balance = balance + ? WHERE id = ?

            // TODO: set parameters and executeUpdate for both statements

            // TODO: if (triggerError) throw new RuntimeException("Simulated failure!");

            // TODO: commit on success

            // TODO: on any exception -> rollback and rethrow
        }
    }
}
package com.example.project;

public class DatabaseApp {
    public static void main(String[] args) {
        DatabaseConfig.initialiseDatabase();

        // You can run manual experiments here:
        // new TransactionService().transferFunds(1, 2, 100, false);
        // new TransactionService().transferFunds(1, 2, 50, true);
    }
}

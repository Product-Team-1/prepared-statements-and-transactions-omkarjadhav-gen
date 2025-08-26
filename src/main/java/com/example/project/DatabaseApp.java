package com.example.project;

public class DatabaseApp {
    public static void main(String[] args) {
        DatabaseConfig.initialiseDatabase();
        TransactionService service = new TransactionService();

        try {
            service.transferFunds(1, 2, 100, false);
            service.transferFunds(1, 2, 50, true); // This will rollback
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

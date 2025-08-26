# Prepared Statements Lab (Starter)

This is the **starter** project. Your tasks:

1. Use `PreparedStatement` for all SQL operations in `TransactionService`.
2. Implement a transfer that uses a **single transaction**. On any error, **rollback**.
3. Add a **forced error path** (parameter `triggerError`) to simulate failure and verify rollback.
4. Print simple logs (`System.out.println(...)`) for: starting tx, executing SQL, commit, rollback.

> Run tests: `gradle -q test`

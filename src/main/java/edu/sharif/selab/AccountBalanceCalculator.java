package edu.sharif.selab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountBalanceCalculator {

    private static List<Transaction> transactionHistory = new ArrayList<>();

    public static int calculateBalance(List<Transaction> transactions) {
        int balance = 0;
        transactionHistory.clear();

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                balance += t.getAmount();
                transactionHistory.add(t);
            } else if (t.getType() == TransactionType.WITHDRAWAL) {
                if (balance - t.getAmount() >= 0) {
                    balance -= t.getAmount();
                    transactionHistory.add(t);
                }
            }
        }
        return balance;
    }

    public static List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(new ArrayList<>(transactionHistory));
    }

    public static void clearTransactionHistory() {
        transactionHistory.clear();
    }
}

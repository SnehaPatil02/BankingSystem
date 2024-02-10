package org.systemDesign;

import java.util.Optional;
import java.util.UUID;

public class TransactionRecord {

    String transactionId;
    BankAccount bankAccount;
    double amount;

    String type;

    String message;

    String toAccount;

    public TransactionRecord(BankAccount bankAccount, double amount, String type,String message) {
        this.transactionId = UUID.randomUUID().toString();
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.type = type;
        this.message = message;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String toString() {
        if (this.toAccount != null) {
            return "TransactionRecord{" +
                    "Transaction Id=" + transactionId + ", " +
                    "bankAccount=" + bankAccount.getAccountNumber() +
                    ", amount=" + amount +
                    ", type='" + type + '\'' +
                    ", message='" + message + '\'' +
                    ", To Account='" + toAccount + '\'' +
                    '}';

        } else {
            return "TransactionRecord{" +
                    "Transaction Id=" + transactionId + ", " +
                    "bankAccount=" + bankAccount.getAccountNumber() +
                    ", amount=" + amount +
                    ", type='" + type + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}

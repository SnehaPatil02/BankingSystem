package org.systemDesign;

import java.util.Optional;
import java.util.UUID;

public class TransactionRecord {

    String transactionId;
    Loan loan;
    double amount;

    String type;

    String message;

    String toAccount;

    public TransactionRecord( double amount, String type,String message) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.message = message;
    }

    public TransactionRecord(Loan loan, double amount, String type){
        this.transactionId = UUID.randomUUID().toString();
        this.loan = loan;
        this.amount = amount;
        this.type = type;
    }



    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String toString() {
        if (this.toAccount != null) {
            return "TransactionRecord{" +
                    "Transaction Id=" + transactionId + ", " +
                    ", amount=" + amount +
                    ", type='" + type + '\'' +
                    ", message='" + message + '\'' +
                    ", To Account='" + toAccount + '\'' +
                    '}';

        } else {
            return "TransactionRecord{" +
                    "Transaction Id=" + transactionId + ", " +
                    ", amount=" + amount +
                    ", type='" + type + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}

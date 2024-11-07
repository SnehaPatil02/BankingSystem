package org.systemDesign;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Loan {

    String loanId;
    CustomerDetails customerDetails;
    double amount;
    double dispatchedAmount;
    String date;
    String duration;
    String loanType;

    List<TransactionRecord> transactionRecords;

    public Loan() {
    }

    public Loan(double amount) {
        this.amount = amount;
        this.dispatchedAmount = 0;
        this.transactionRecords = new ArrayList<>();

    }

    public Loan( double amount, String duration) {
        this.loanId = UUID.randomUUID().toString();
        this.amount = amount;
        this.duration = duration;
        this.transactionRecords = new ArrayList<>();
    }

    public String getLoanId() {
        return loanId;
    }

    public double amountDispatching(double dispatchAmount) {
        double remainingAmount = this.amount - dispatchedAmount;
        if (remainingAmount > dispatchAmount) {
            dispatchedAmount += dispatchAmount;
            return dispatchAmount;
        }

        return 0;

    }

    public double payingAmount(double payingAmount){

        this.dispatchedAmount = this.dispatchedAmount - payingAmount;

        return this.dispatchedAmount;
    }

}

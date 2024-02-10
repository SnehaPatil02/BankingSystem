package org.systemDesign;

public class FixedDeposit extends BankAccount{

    double transferFees = 2.00;

    public FixedDeposit(double balance) {
        super(balance);
        this.accountType = "Fixed";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getTransferFees() {
        return transferFees;
    }
}

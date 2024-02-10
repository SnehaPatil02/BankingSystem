package org.systemDesign;

public class SavingsAccount extends BankAccount{

    double transferFees;

    public SavingsAccount( double balance) {
        super( balance);
        this.accountType = "Savings";
        this.transferFees = 1.00;
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

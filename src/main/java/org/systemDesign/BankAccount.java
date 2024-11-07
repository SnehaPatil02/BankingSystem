package org.systemDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BankAccount {
    String accountNumber;
    double balance;
    String accountType;

    double transferFees;

    List<TransactionRecord> transactionRecords;


    public BankAccount( double balance) {
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = balance;
        this.transactionRecords = new ArrayList<>();

    }

    public abstract  String getAccountNumber();

    public abstract double getBalance();

    public abstract String getAccountType();


    public void deposit(double amount){
       this.balance = balance + amount;
        System.out.println("AccountNumber: " + getAccountNumber() + " current balance is " + this.balance);
    }

    public void withdraw(double amount){
        this.balance = balance - amount;
        System.out.println("AccountNumber: " + getAccountNumber() +  " current balance is " + this.balance);
    }

    public double checkBalance(){
        System.out.println("AccountNumber: " + getAccountNumber() + " your balance is " + this.balance);
        return this.balance;
    }

    public double getTransferFees() {
        return transferFees;
    }


}

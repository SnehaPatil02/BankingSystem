package org.systemDesign;
public class Main {
    public static void main(String[] args) {

        BankingSystem bankingSystem = new BankingSystem();

        Record r1 = bankingSystem.createAccount("dummy1", "dummy address", "Fixed");
        System.out.println("Account is created successfully " + "\n" + r1.toString());


        bankingSystem.credit(r1.bankAccounts.get(0).getAccountNumber(), 25.00, "First deposit");
        bankingSystem.credit(r1.bankAccounts.get(0).getAccountNumber(), 25.00, "Second deposit");



        bankingSystem.debit(r1.bankAccounts.get(0).getAccountNumber(), 10.00, "ATM withdrawal");
        bankingSystem.debit(r1.bankAccounts.get(0).getAccountNumber(), 5.00, "Phonepe");

        bankingSystem.checkBalance(r1.bankAccounts.get(0).getAccountNumber());

        Record r2 = bankingSystem.createAccount("dummy2", "dummy address", "Savings");
        System.out.println("Account is created successfully " + "\n" + r2.toString());


        bankingSystem.transferAmount(r1.bankAccounts.get(0).getAccountNumber(), r2.bankAccounts.get(0).getAccountNumber(), 33.00, "To a friend", "For pizza");

        bankingSystem.checkBalance(r1.bankAccounts.get(0).getAccountNumber());
        bankingSystem.checkBalance(r2.bankAccounts.get(0).getAccountNumber());

       // bankingSystem.closeAccount(r1.bankAccount.getAccountNumber());



    }
}
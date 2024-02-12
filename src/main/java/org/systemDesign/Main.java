package org.systemDesign;
public class Main {
    public static void main(String[] args) {

        BankingSystem bankingSystem = new BankingSystem();

        Record r1 = bankingSystem.createAccount("customer 1", "customer 1 address", "Fixed");


        System.out.println("***************************************" + "\n");


        Record r2 = bankingSystem.createAccount("customer 1", "customer 1 address", "Savings");


        System.out.println("*************************************************");

        bankingSystem.credit(r1.bankAccounts.get(0).getAccountNumber(), 25.00, "First deposit");
        bankingSystem.credit(r1.bankAccounts.get(1).getAccountNumber(), 25.00, "First deposit");
        bankingSystem.credit(r1.bankAccounts.get(0).getAccountNumber(), 25.00, "Second deposit");



        bankingSystem.debit(r1.bankAccounts.get(0).getAccountNumber(), 10.00, "ATM withdrawal");
        bankingSystem.debit(r1.bankAccounts.get(0).getAccountNumber(), 5.00, "Phonepe");
        bankingSystem.debit(r1.bankAccounts.get(1).getAccountNumber(), 5.00, "Phonepe");


        System.out.println("\n" + "Another account ");

        Record record2 = bankingSystem.createAccount("customer 2", "customer 2 address", "Savings");



        bankingSystem.transferAmount(r1.bankAccounts.get(0).getAccountNumber(), r1.bankAccounts.get(1).getAccountNumber(), 8.00, "To a friend", "For pizza");

        bankingSystem.checkBalance(r1.bankAccounts.get(0).getAccountNumber());
        bankingSystem.checkBalance(r1.bankAccounts.get(1).getAccountNumber());

       // bankingSystem.closeAccount(r1.bankAccount.getAccountNumber());



    }
}
package org.systemDesign;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        BankingSystem bankingSystem = new BankingSystem();

        Record r1 = bankingSystem.createAccount("customer1", "customer1 address", "Fixed");


        System.out.println("***************************************" + "\n");


        Record r2 = bankingSystem.createAccount("customer1", "customer1 address", "Savings");


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


        Record loanRecord = bankingSystem.createLoan("customer1", "customer1 address", "Student Loan", 25000, "2 years");
        bankingSystem.dispatchAmount(loanRecord.getLoanList().get(0).getLoanId(),15000.00);
        System.out.println("First Dispatch " + loanRecord.getLoanList().get(0).dispatchedAmount);
        bankingSystem.loanPayment(loanRecord.getLoanList().get(0).getLoanId(),5000.00);
        System.out.println("Remaining amount " + loanRecord.getLoanList().get(0).dispatchedAmount);

       bankingSystem.dispatchAmount(loanRecord.loanList.get(0).getLoanId(),15000.00);
       System.out.println("Second Dispatch " + loanRecord.getLoanList().get(0).dispatchedAmount);

       bankingSystem.dispatchAmount(loanRecord.loanList.get(0).getLoanId(),5000.00);
       System.out.println("Third Dispatch " + loanRecord.getLoanList().get(0).dispatchedAmount);


        CustomerDetails cd = new CustomerDetails();
        cd.setName("abc");
        cd.setAddress("dummy address");

       
        try
            (FileOutputStream fileOutputStream = new FileOutputStream("/Users/snehapatil/Code/BankingSystem/src/main/resources/serialization");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cd);
            System.out.println("Serialized data is stored in BankingSystem/src folder");
        } catch (IOException e) {
          e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("/Users/snehapatil/Code/BankingSystem/src/main/resources/serialization");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
        CustomerDetails cDetails = (CustomerDetails)
        objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Deserialized Customer Details : ");
        System.out.println("Name: " + cDetails.getName());
        System.out.println("Address: " + cDetails.getAddress());
            
        } catch (IOException | ClassNotFoundException c) {
           c.printStackTrace();
        }
        


    }
}
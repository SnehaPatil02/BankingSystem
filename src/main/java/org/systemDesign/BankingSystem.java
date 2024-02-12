package org.systemDesign;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    List<Record> records;
    List<BankAccount> accountList;
    TransactionManager transactionManager;



    public BankingSystem() {
        this.accountList = new ArrayList<>();
        this.records = new ArrayList<>();
        this.transactionManager = new TransactionManager();

    }



    //createAccount will take customer details as input returns account.
    public Record createAccount(String name, String address, String accountType) {

        BankAccount ba ;

        if (accountType.equals("Savings")) {

            ba = new SavingsAccount(0.00);

        } else {
            ba = new FixedDeposit(0.00);
        }


        for (Record record : this.records) {
            if (record.getCustomerDetails().getName().equals(name) && record.getCustomerDetails().getAddress().equals(address)) {

                record.addBankAccount(ba);
                System.out.println("------Bank Account is created for a existing customer------ " + "\n" + record.toString());
                return record;

            }
        }


        CustomerDetails cd = new CustomerDetails(name, address);
            Record newrecord = new Record(cd, ba);
            this.records.add(newrecord);
        System.out.println("------A new Bank Account is created for a new customer------ " + "\n" + newrecord.toString());

            return newrecord;
        }


    public void closeAccount(String accountNumber) {
        Record r = null;

        for (Record record : this.records) {
            if (record.getBankAccounts().get(0).getAccountNumber().equals(accountNumber)) {
                r = record;
                break;
            }
        }

        if (r == null) {
            throw new RuntimeException("Not found");
        }

        this.records.remove(r);
        System.out.println("Successfully closed your account");

    }

    public TransactionRecord credit(String accountNumber, double amount, String msg){
        BankAccount ba = null;
        for(Record record : this.records){
            for (BankAccount bankAccount : record.getBankAccounts()){
                if(bankAccount.getAccountNumber().equals(accountNumber)){
                    ba = bankAccount;
                    break;
                }
            }

        }

        if (ba == null) {
            throw new RuntimeException("Not found");
        }

        TransactionRecord tr = this.transactionManager.creditExecuteTransaction(ba, amount, msg);

        System.out.println(tr.toString());

        ba.transactionRecords.add(tr);

        return tr;
    }

    public TransactionRecord debit(String accountNumber, double amount, String msg){
        BankAccount ba = null;
        for(Record record : this.records){
            for(BankAccount bankAccount : record.getBankAccounts()){
                if (bankAccount.getAccountNumber().equals(accountNumber)){
                    ba =bankAccount;
                    break;
                }
            }

        }
        if (ba == null){
            throw new RuntimeException("No such bank account");
        }


        TransactionRecord tr = this.transactionManager.debitExecuteTransaction(ba, amount, msg);

        System.out.println(tr.toString());

        ba.transactionRecords.add(tr);
        return tr;
    }


    public void checkBalance(String accountNumber){
        BankAccount ba=null;
       for (Record r : this.records){
           for (BankAccount bankAccount : r.getBankAccounts()){
               if(bankAccount.getAccountNumber().equals(accountNumber)){
                   ba = bankAccount;
               }
           }

       }

        if (ba == null){
            throw new RuntimeException("No such bank account");
        }

        ba.checkBalance();

    }

    public List<TransactionRecord> transferAmount(String accountNumber1, String accountNumber2, double amount, String msg1, String msg2){
        BankAccount ba1 = null;
        for(Record record : this.records){
            for (BankAccount bankAccount : record.getBankAccounts()){
                if(bankAccount.getAccountNumber().equals(accountNumber1)){
                    ba1 = bankAccount;
                }
            }

        }if(ba1 == null){
            throw new RuntimeException("No such account");
        }

        double fees = ba1.getTransferFees();


       if( ba1.checkBalance() < amount+fees){
           throw new RuntimeException("Not enough balance");
       }


        BankAccount ba2 = null;
        for(Record record : this.records){
            for(BankAccount bankAccount : record.getBankAccounts()){
                if(bankAccount.getAccountNumber().equals(accountNumber2)){
                    ba2 = bankAccount;
                }
            }

        }if(ba2 == null){
            throw new RuntimeException("No such account");
        }


        List<TransactionRecord> ltr = this.transactionManager.executeTransfer(ba1, ba2, amount, msg1, msg2);

        System.out.println(ltr.get(0).toString());
        System.out.println(ltr.get(1).toString());

        ba1.transactionRecords.add(ltr.get(0));
        ba2.transactionRecords.add(ltr.get(1));
        return ltr;

    }

}

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
        CustomerDetails cd = new CustomerDetails(name, address);
        BankAccount ba = null;
        if (accountType.equals("Savings")) {
            ba = new SavingsAccount(0.00);
        } else {
            ba = new FixedDeposit(0.00);
        }
        Record record = new Record(cd, ba);
        this.records.add(record);

        return record;
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
            if(record.getBankAccounts().get(0).getAccountNumber().equals(accountNumber)){
                ba = record.getBankAccounts().get(0);
                break;
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
            if (record.getBankAccounts().get(0).getAccountNumber().equals(accountNumber)){
                ba = record.getBankAccounts().get(0);
                break;
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
           if(r.getBankAccounts().get(0).getAccountNumber().equals(accountNumber)){
               ba = r.getBankAccounts().get(0);
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
            if(record.getBankAccounts().get(0).getAccountNumber().equals(accountNumber1)){
                ba1 = record.getBankAccounts().get(0);
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
            if(record.getBankAccounts().get(0).getAccountNumber().equals(accountNumber2)){
                ba2 = record.getBankAccounts().get(0);
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

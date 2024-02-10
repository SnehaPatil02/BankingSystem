package org.systemDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionManager {


    public TransactionRecord creditExecuteTransaction(BankAccount bankAccount, double amount, String msg){
         bankAccount.deposit(amount);

         TransactionRecord tr = new TransactionRecord(bankAccount, amount, "credit", msg);

         return tr;

    }

    public TransactionRecord debitExecuteTransaction(BankAccount bankAccount, double amount, String msg){
        bankAccount.withdraw(amount);
        return new TransactionRecord(bankAccount, amount, "debit", msg);
    }

    public List<TransactionRecord> executeTransfer(BankAccount account1, BankAccount account2, double amount, String msg1, String msg2){

        TransactionRecord tr1 = this.debitExecuteTransaction(account1, amount+ account1.getTransferFees(), msg1);
        tr1.setToAccount(account2.getAccountNumber());
        TransactionRecord tr2 = this.creditExecuteTransaction(account2, amount, msg2);

        List<TransactionRecord> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);

        return list;
    }
}

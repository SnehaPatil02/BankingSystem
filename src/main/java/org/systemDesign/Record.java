package org.systemDesign;

import java.util.ArrayList;
import java.util.List;

public class Record {

    CustomerDetails customerDetails;
    List<BankAccount> bankAccounts;

    public Record(CustomerDetails customerDetails, BankAccount bankAccount) {

        this.customerDetails = customerDetails;
        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(bankAccount);
    }



    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount){
        this.bankAccounts.add(bankAccount);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" ");

        System.out.println("It's a list of bank accounts" + "\n");
        System.out.println("Size of the list: " + this.bankAccounts.size());
        for(BankAccount bankAccount : this.bankAccounts){
            result.append("Record {" + "\n" + "Customer Id= ")
                    .append(customerDetails.customerId).append("\n")
                    .append("Customer Name= ").append(customerDetails.name)
                    .append("\n").append("Customer address= ")
                    .append(customerDetails.address).append("\n")
                    .append("Account number= ")
                    .append(bankAccount.getAccountNumber())
                    .append("\n").append("Account type= ")
                    .append(bankAccount.accountType).append("\n").
                    append("Balance= ").
                    append(bankAccount.balance).append('}').append("\n");
        }
        return result.toString();
    }
}

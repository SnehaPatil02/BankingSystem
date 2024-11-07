package org.systemDesign;

import java.util.ArrayList;
import java.util.List;

public class Record {

    CustomerDetails customerDetails;
    List<BankAccount> bankAccounts;
    List<Loan> loanList;

    public Record(CustomerDetails customerDetails, BankAccount bankAccount) {

        this.customerDetails = customerDetails;
        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(bankAccount);
        this.loanList = new ArrayList<>();
    }

    public Record(CustomerDetails customerDetails, Loan loan) {

        this.customerDetails = customerDetails;
        this.loanList = new ArrayList<>();
        this.bankAccounts = new ArrayList<>();
        this.loanList.add(loan);
    }



    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount){
        this.bankAccounts.add(bankAccount);
    }

    public void addLoan(Loan loan){
        this.loanList.add(loan);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" ");

        System.out.println("It's a list of bank accounts" + "\n");
        System.out.println("Size of the list: " + this.bankAccounts.size());
        for(BankAccount bankAccount : this.bankAccounts){
            result.append(" Record {" + "\n" + "Customer Id= ")
                    .append(customerDetails.getCustomerId()).append("\n")
                    .append("Customer Name= ").append(customerDetails.getName())
                    .append("\n").append("Customer address= ")
                    .append(customerDetails.getAddress()).append("\n")
                    .append("Account number= ")
                    .append(bankAccount.getAccountNumber())
                    .append("\n").append("Account type= ")
                    .append(bankAccount.accountType).append("\n")
                    .append("Balance= ")
                    .append(bankAccount.balance).append('}').append("\n")
                    .append("Loan lists= ")
                    .append(getLoanList());
        }
        return result.toString();
    }


}

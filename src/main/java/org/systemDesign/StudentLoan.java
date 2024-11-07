package org.systemDesign;

public class StudentLoan extends Loan{



    public StudentLoan(double amount){
        super(amount);
        this.loanType = "Student Loan";
    }

    public StudentLoan( double amount, String duration, String loanType) {
        super( amount, duration);
        this.loanType = loanType;

    }


}

package com.savneet;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //method to display account details
    public void showAccount() {
        System.out.println("Account Number:"+this.accountNumber + " has balance $" + this.balance);
    }

    //method to deposit money
    public void deposit(double amount) {
        double newBalance = this.balance + amount;
        setBalance(newBalance);
    }

    //method to withdraw money
    public void withdrawal(double amount) {

        if (this.balance >= amount) {
            double newBalance = this.balance - amount;
            setBalance(newBalance);
        } else {
            System.out.println("Less Balance.Transaction Failed.");
        }
    }
}

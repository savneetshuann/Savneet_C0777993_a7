package com.savneet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        try {
            // create 4 user BankAccount objects
            BankAccount user1 = new BankAccount("1111", 2000);
            BankAccount user2 = new BankAccount("2222", 3000);
            BankAccount user3 = new BankAccount("3333", 5000);
            BankAccount user4 = new BankAccount("4444", 6000);

            // writing the user balance to text files
            PrintWriter user1Balance = new PrintWriter("user1.txt");
            PrintWriter user2Balance = new PrintWriter("user2.txt");
            PrintWriter user3Balance = new PrintWriter("user3.txt");
            PrintWriter user4Balance = new PrintWriter("user4.txt");
            user1Balance.println(user1.getBalance());
            user2Balance.println(user2.getBalance());
            user3Balance.println(user3.getBalance());
            user4Balance.println(user4.getBalance());
            user1Balance.flush();
            user2Balance.flush();
            user3Balance.flush();
            user4Balance.flush();

            // array of username and passwords
            String[] userName = {"1111", "2222", "3333", "4444"}; //Using account number as username
            String[] password = {"user1", "user2", "user3", "user4"}; //passwords

            Scanner s = new Scanner(System.in);
            BankAccount user = null;
            System.out.print("Enter account number:");
            String inputUserName = s.nextLine();
            System.out.print("Enter password:");
            String inputPassword = s.nextLine();
            if (inputUserName.equals(userName[0]) && inputPassword.equals(password[0])) {
                user = user1;
            } else if (inputUserName.equals(userName[1]) && inputPassword.equals(password[1])) {
                user = user2;
            } else if (inputUserName.equals(userName[2]) && inputPassword.equals(password[2])) {
                user = user3;
            } else if (inputUserName.equals(userName[3]) && inputPassword.equals(password[3])) {
                user = user4;
            } else {
                System.out.println("Unauthorized access.Either Username or Password is incorrect.");
                System.exit(0);
            }

            while (true) {
                System.out.println("Choose one option from following:");
                System.out.println("1 - Check Balance");
                System.out.println("2 - Withdraw Money");
                System.out.println("3 - Deposit Money");
                System.out.println("4 - Exit");

                int mc = s.nextInt();

                if (mc == 1) {
                    user.showAccount();
                } else if (mc == 2) {
                    System.out.print("Enter withdraw amount: ");
                    double wd = s.nextDouble();
                    user.withdrawal(wd);
                    System.out.println("$" + user.getBalance() + " is your new account balance.");


                } else if (mc == 3) {
                    System.out.print("Enter deposit amount: ");
                    double dp = s.nextDouble();
                    user.deposit(dp);
                    System.out.println("$" + user.getBalance() + " is your new account balance.");
                } else if (mc == 4) {
                    System.exit(0);
                } else {
                    System.out.print("\nThat's not an option, please select an option listed below!\n");
                }

                // updating the balance in the files
                user1Balance.println(user1.getBalance());
                user2Balance.println(user2.getBalance());
                user3Balance.println(user3.getBalance());
                user4Balance.println(user4.getBalance());
                user1Balance.flush();
                user2Balance.flush();
                user3Balance.flush();
                user4Balance.flush();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

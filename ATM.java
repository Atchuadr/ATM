package newATM;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulate one account for demo
        Account account = new Account(12345, 1234, 1000.0);

        System.out.println("Welcome to the ATM!");

        // Login Step
        System.out.print("Enter Account Number: ");
        int enteredAccount = scanner.nextInt();

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredAccount == account.getAccountNumber() && account.checkPin(enteredPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposited successfully.");
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 4);
        } else {
            System.out.println("Incorrect account number or PIN.");
        }

        scanner.close();
    }
}


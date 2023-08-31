package sanjana_177;
import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private static ArrayList<String> transactionsHistory = new ArrayList<>();
    private static int balance = 0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System!");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        System.out.println("Login Successful!");
        showMainMenu();
    }

    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionsHistory();
                    break;
                case 2:
                    performWithdraw();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void showTransactionsHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionsHistory) {
            System.out.println(transaction);
        }
    }

    private static void performWithdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionsHistory.add("Withdraw: " + amount);
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount > 0) {
            balance += amount;
            transactionsHistory.add("Deposit: " + amount);
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter recipient's account number: ");
        String recipientAccount = scanner.nextLine();

        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionsHistory.add("Transfer: " + amount + " to " + recipientAccount);
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

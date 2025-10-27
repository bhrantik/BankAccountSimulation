import java.util.ArrayList;
import java.util.Scanner;

class Account {
    String name;
    String accountNumber;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    Account(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        history.add("Account created with balance: Rs." + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: Rs." + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: Rs." + amount);
            System.out.println("Withdrawal successful!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    void showHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String h : history) {
            System.out.println(h);
        }
        System.out.println("---------------------------\n");
    }
}

public class BankAccountSimulation
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to our Bank ===");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: Rs.");
        double balance = sc.nextDouble();

        Account acc = new Account(name, accNo, balance);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs.");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;

                case 3:
                    acc.checkBalance();
                    break;

                case 4:
                    acc.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

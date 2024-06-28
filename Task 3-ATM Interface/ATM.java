import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void start() {
        int enteredPin;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ATM!");
        System.out.print("Enter your PIN: ");
        enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            System.out.println("PIN is correct. Logging in...");
            menu(scanner);
        } else {
            System.out.println("Invalid PIN. Please try again.");
            start();
        }
    }

    private void menu(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdrawCash(Scanner scanner) {
        double amount;
        System.out.print("Enter the amount to withdraw: $");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    private void depositCash(Scanner scanner) {
        double amount;
        System.out.print("Enter the amount to deposit: $");
        amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000.0);
        atm.start();
    }
}
import java.util.Scanner;
class CustomerAccount {
        private double accountBalance;

        public CustomerAccount(double initialBalance) {
            this.accountBalance = initialBalance;
        }

        public boolean depositAmount(double amount) {
            if (amount > 0) {
                this.accountBalance += amount;
                return true;
            } else {
                return false;
            }
        }

        public boolean withdrawAmount(double amount) {
            if (amount > 0 && amount <= this.accountBalance) {
                this.accountBalance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public double checkAccountBalance() {
            return this.accountBalance;
        }
    }

    class AutomatedTellerMachine {
        private CustomerAccount userAccount;
        private Scanner userInputScanner;

        public AutomatedTellerMachine(CustomerAccount account) {
            this.userAccount = account;
            this.userInputScanner = new Scanner(System.in);
        }

        public void displayMainMenu() {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
        }

        public void runATM() {
            while (true) {
                displayMainMenu();
                System.out.print("Enter your choice (1-4): ");
                String userChoice = userInputScanner.nextLine();

                if (userChoice.equals("1")) {
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawalAmount = Double.parseDouble(userInputScanner.nextLine());
                    if (userAccount.withdrawAmount(withdrawalAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                } else if (userChoice.equals("2")) {
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(userInputScanner.nextLine());
                    if (userAccount.depositAmount(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                } else if (userChoice.equals("3")) {
                    System.out.println("Your current account balance is: " + userAccount.checkAccountBalance());
                } else if (userChoice.equals("4")) {
                    System.out.println("Exiting. Thank you!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }
    }

    // Example usage
    public class Atm{
        public static void main(String[] args) {
            CustomerAccount clientAccount = new CustomerAccount(1000);  // Starting balance of $1000
            AutomatedTellerMachine atmMachine = new AutomatedTellerMachine(clientAccount);
            atmMachine.runATM();
        }
    }



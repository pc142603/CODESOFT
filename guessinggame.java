import java.util.Random;
import java.util.Scanner;

    public class guessinggame {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 10;
            int totalRounds = 0;
            int totalAttempts = 0;

            System.out.println("Welcome to Number Guessing Game!!!!!");

            do {
                int targetNum = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int attempts = 0;

                System.out.println("\nRound " + (totalRounds + 1));
                System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userguess = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    if (userguess < lowerBound || userguess > upperBound) {
                        System.out.println("Please enter a valid guess within the specified range.");
                        continue;
                    }

                    attempts++;
                    totalAttempts++;

                    if (userguess == targetNum) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        break;
                    } else if (userguess < targetNum) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                }

                totalRounds++;

                System.out.print("Do you want to play again???(yes/no): ");
                String playAgain = sc.nextLine().toLowerCase();

                if (!playAgain.equals("yes")) {
                    break;
                }
            } while (true);

            System.out.println("\nGame Over. Your total score is: " + totalRounds + " rounds played with "
                    + totalAttempts + " total attempts.");
            sc.close();
        }
    }



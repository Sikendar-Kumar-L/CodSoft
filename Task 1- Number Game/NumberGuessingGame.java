// Task 1 NUMBER GAME
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public NumberGuessingGame() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Number Guessing Game\n");
        int totalRounds = 0;
        int totalTries = 0;
        String response;
        do {
            int numberOfTries = playRound(scanner);
            totalTries += numberOfTries;
            ++totalRounds;
            System.out.println("Do you want to play another round? (yes/no)");
            response = scanner.next();
        } while(response.equalsIgnoreCase("yes"));

        System.out.println("You played " + totalRounds + " rounds ");
    }

    public static int playRound(Scanner scanner) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int numberOfTries = 0;
        System.out.println("DIFFICULTY LEVELS");
        System.out.println("1. Difficult level(default 6 tries)");
        System.out.println("2. Easy level (unlimited tries)");
        int option = getOption(scanner);
        int maxTries;
        if (option == 1) {
            maxTries = 6;
        } else {
            maxTries = Integer.MAX_VALUE;
        }

        System.out.println("Guess a number between 1 and 100:");

        do {
            int guess = getGuess(scanner);
            ++numberOfTries;
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You found the number in " + numberOfTries + " tries.");
                return numberOfTries;
            }

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low. Try again!");
            } else {
                System.out.println("Your guess is too high. Try again!");
            }
        } while(numberOfTries < maxTries);
        System.out.println("You ran out of tries! The correct answer was " + numberToGuess);
        return numberOfTries;
    }

    public static int getOption(Scanner scanner) {
        while(true) {
            try {
                int option = scanner.nextInt();
                if (option == 1 || option == 2) {
                    return option;
                }
                System.out.println("Invalid option. Please enter 1 or 2.");
            } catch (InputMismatchException var3) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public static int getGuess(Scanner scanner) {
        while(true) {
            try {
                int guess = scanner.nextInt();
                if (guess >= 1 && guess <= 100) {
                    return guess;
                }
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            } catch (InputMismatchException var3) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}

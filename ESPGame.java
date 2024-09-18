import java.util.Scanner;
import java.util.Random;

/*
 * Class: CMSC203 
 * Instructor: Prof. Tarek
 * Description: This program tests the user's extrasensory perception (ESP) by having them guess randomly selected colors from a predefined list, repeating the process 11 times, and then displaying the user's information and correct guesses.
 * Due: 9/17/2024
 * Platform/compiler: Eclipse IDE and Command Prompt
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Ash Ibasan
 */

public class ESPGame {
    public static void main(String[] args) {
        // Setup
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Get the name of the user, M#, and description
        System.out.print("Enter your name: ");
        String userName = input.nextLine();

        System.out.print("Enter your M#: ");
        String mNumber = input.nextLine();

        System.out.print("Describe yourself: ");
        String description = input.nextLine();

        System.out.print("When is the assignment due?: ");
        String dueDate = input.nextLine();

        // Define color options using constants
        final String COLOR_RED = "red";
        final String COLOR_GREEN = "green";
        final String COLOR_BLUE = "blue";
        final String COLOR_ORANGE = "orange";
        final String COLOR_YELLOW = "yellow";


        // Initialize count of correct guesses
        int guessesCorrect = 0;  // For counting correct guesses
        int guessesTotal = 11;    // For total rounds of guesses
        
        // Start ESP Game
        System.out.println("\nCMSC203 Assignment 1: Time to test your ESP skills!");

        // Loop for 11 guesses
        for (int i = 0; i < guessesTotal; i++) {
            // add round number
            System.out.println("\nRound " + (i + 1));
            int colorNumber = random.nextInt(5);
            String colorSelect = "";

            // Map number to color
            if (colorNumber == 0) {
            	colorSelect = COLOR_RED;
            } else if (colorNumber == 1) {
            	colorSelect = COLOR_GREEN;
            } else if (colorNumber == 2) {
            	colorSelect = COLOR_BLUE;
            } else if (colorNumber == 3) {
            	colorSelect = COLOR_ORANGE;
            } else if (colorNumber == 4) {
            	colorSelect = COLOR_YELLOW;
            }

            // Ask user to guess color
            System.out.print("I'm thinking of a color." + System.lineSeparator() + "Can you guess what it is? Choose from red, green, blue, orange, or yellow. ");
            String userGuess = input.nextLine();

            // Input validation: Keep prompting until valid color is entered
            while (!userGuess.equalsIgnoreCase(COLOR_RED) && 
            	   !userGuess.equalsIgnoreCase(COLOR_GREEN) && 
            	   !userGuess.equalsIgnoreCase(COLOR_BLUE) && 
            	   !userGuess.equalsIgnoreCase(COLOR_ORANGE) && 
            	   !userGuess.equalsIgnoreCase(COLOR_YELLOW)) {


                System.out.print("The color you have selected is invalid. Please choose from the following colors: red, green, blue, orange, or yellow. ");
                userGuess = input.nextLine();
            }

            // Is the guess correct?
            if (userGuess.equalsIgnoreCase(colorSelect)) {
                System.out.println("Correct! I was thinking of " + colorSelect + ".");
                guessesCorrect++;
            } else {
                System.out.println("Incorrect. I was thinking of " + colorSelect + ".");
            }
        }

        // Display game results
        System.out.println("Game Over!");
        System.out.println("You guessed " + guessesCorrect + " out of " + guessesTotal + " colors correctly.");

        // Display user information
        System.out.println("\n~~~ User Information ~~~");
        System.out.println("Name: " + userName);
        System.out.println("MC M#: " + mNumber);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);

        // Print the name of the programmer
        System.out.println("Programmer: Ash Ibasan");

        // Close scanner
        input.close();
    }
}

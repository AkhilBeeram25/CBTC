import java.util.Random;
import javax.swing.JOptionPane;

public class guess {
    public static void main(String[] args) {
        // Set the range for the random number
        int minRange = 1;
        int maxRange = 100;

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        // Set the number of attempts
        int maxAttempts = 10;
        int attempts = 0;

        // Game loop
        while (attempts < maxAttempts) {
            // Prompt user to enter their guess
            String userInput = JOptionPane.showInputDialog("Guess the number between " + minRange + " and " + maxRange + ":");
            
            // Check if the user wants to exit or cancel the game
            if (userInput == null) {
                System.exit(0);
            }

            try {
                // Parse user input
                int userGuess = Integer.parseInt(userInput);

                // Check if the guess is correct
                if (userGuess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber + " in " + (attempts + 1) + " attempts.");
                    break;
                } else {
                    // Provide feedback on the user's guess
                    String message = (userGuess < randomNumber) ? "Too low!" : "Too high!";
                    JOptionPane.showMessageDialog(null, message + " Try again.");

                    // Increment the number of attempts
                    attempts++;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        // If the user couldn't guess the number in the allowed attempts
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
        }
    }
}

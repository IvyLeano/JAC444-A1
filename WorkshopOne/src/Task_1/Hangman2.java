
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Hangman2 {
	public static void main(String[] args) {
		String[] colours = { "blue", "orange", "yellow", "brown", "green", "purple" };
		boolean play = true;

		replay: while (play == true) {
			int index = (int) (1 + Math.random() * 5);
			int m_colourLength = colours[index].length();
			int m_lettersRemaining = m_colourLength;
			int m_incorrectGuesses = 0;
			int m_lettersGuessedIndex = 0;
			char[] m_guessedLetters = new char[20];
			char[] m_userKey = new char[m_colourLength];
			Arrays.fill(m_userKey, '*');
			String m_userKeyString = new String(m_userKey);
			Scanner input = new Scanner(System.in);

			System.out.println("_____________________________________________________________________\n");
			System.out.println("                        Welcome to Hangman!\n");
			System.out.println("_____________________________________________________________________\n");
			System.out.println("The category is: Colours");
			System.out.println("The colour I'm thinking of has " + m_colourLength + " letters.");
			System.out.println("You have 20 tries before the answer will be revealed. Good Luck!\n");
			System.out.printf("Take a guess, enter a letter: " + m_userKeyString);
			System.out.println("\n");

			tryAgain: while (m_lettersRemaining != 0) {

				System.out.printf("Your Guess: ");
				String in = input.next();
				String guessedLetters = new String(m_guessedLetters);

				if (validateInput(in) == true) {
					System.out.println("\nInvalid input");
					System.out.println();
					continue tryAgain;
				}
				char letter = Character.toLowerCase(in.charAt(0));
				if (guessedLetters.indexOf(letter) != -1) { // indexOf returns -1 if the char is not in the array
					System.out.println("\nThat letter has already been played");
					System.out.println();
					continue tryAgain;
				}

				boolean match = false;
				for (int i = 0; i < m_colourLength; i++) {
					if (colours[index].charAt(i) == letter) {
						m_userKey[i] = letter;
						m_lettersRemaining--;
						match = true;
					}
				}
				if (match == false) {
					m_incorrectGuesses++;
				} else if (match == false && m_incorrectGuesses == 20) {
					System.out.println("You ran out of guesses the correct answer is: " + colours[index]);
				} else {
					m_guessedLetters[m_lettersGuessedIndex] = letter;
					m_lettersGuessedIndex++;
					m_userKeyString = new String(m_userKey);
					System.out.println("Result: " + m_userKeyString + "\n");
				}
			}
			System.out.println("Game Statistics: ");
			System.out.println("Total Misses: " + m_incorrectGuesses);
			System.out.printf("\nWould you like to play again? Enter y or n: ");
			char playAgain = input.next().charAt(0);
			System.out.print("_____________________________________________________________________\n");

			if (Character.toLowerCase(playAgain) == 'y') {
				continue replay;
			} else {
				play = false;
			}
		}
	}

	static boolean validateInput(String userInput) {
		boolean invalidInput = userInput.length() > 1
				|| ((int) userInput.charAt(0) >= 91 && (int) userInput.charAt(0) <= 96) // prevents special
				|| ((int) userInput.charAt(0) >= 32 && (int) userInput.charAt(0) <= 64) // characters and numbers
				|| ((int) userInput.charAt(0) >= 123 && (int) userInput.charAt(0) <= 127);

		return invalidInput;
	}
}

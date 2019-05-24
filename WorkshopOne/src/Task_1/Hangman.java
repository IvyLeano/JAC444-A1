/**********************************************
Workshop # 1
Course: JAC444SAB - Summer
Last Name: Leano - Hill
First Name: Ivy
ID: 120331186
Section: AB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Ivy Leano-Hill
Date: Friday, May 24, 2019
**********************************************/
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Hangman {
	public static void main(String[] args) {
		String[] colours = { "blue", "orange", "yellow", "brown", "green", "purple" };
		boolean play = true;

		// First while loop continues until boolean play == false,
		// play == false when user enters 'n' or 'N'
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

			// Greetings
			System.out.println("_____________________________________________________________________\n");
			System.out.println("                        Welcome to Hangman!\n");
			System.out.println("_____________________________________________________________________\n");
			System.out.println("The category is: Colours");
			System.out.println("The colour I'm thinking of has " + m_colourLength + " letters.");
			System.out.println("You have 20 tries before the answer will be revealed. Good Luck!\n");
			System.out.printf("Take a guess, enter a letter: " + m_userKeyString);
			System.out.println("\n");

			//While the user still has letters left to guess
			//prompt user for input
			tryAgain: while (m_lettersRemaining != 0) {

				System.out.printf("Your Guess: ");
				String in = input.next();
				String guessedLetters = new String(m_guessedLetters);

				//Step 1.validateInput(), if invalid input go back to the start of tryAgain
				if (validateInput(in) == true) {
					System.out.println("\nInvalid input");
					System.out.println();
					continue tryAgain;
				}
				//Step 2. check if letter has already been played, 
				//if letter has already been played go back to the start of tryAgain
				char letter = Character.toLowerCase(in.charAt(0));
				if (guessedLetters.indexOf(letter) != -1) { // indexOf returns -1 if the char is not in the array
					System.out.println("\nThat letter has already been played");
					System.out.println();
					continue tryAgain; 
				}
				//Step 3. compare all letters in array to user input
				boolean match = false;
				for (int i = 0; i < m_colourLength; i++) {
					if (colours[index].charAt(i) == letter) {
						m_userKey[i] = letter; //if there is a match, set the store that letter in the m_userKey array
						m_lettersRemaining--; // decrement the letters remaining to be guessed
						match = true;		  
					}
				}
				//if after iterating through each letter, there is still no match
				//then increment the number of incorrect guesses
				if (match == false) {
					m_incorrectGuesses++;
				}
				//if the number of incorrect guesses is 19, meaning the last index of the m_guessedLetters[]
				//end the current game, prompting the user to start a new game or to quit
				if (m_lettersGuessedIndex == 19) {
					System.out.println("You ran out of guesses, the correct answer is: " + colours[index]);
					break tryAgain;
				}
				//if the guess was correct or incorrect, store it in the guessed letters array
				//and increment the m_lettersGuessedIndex, print out the result of their guess
				m_guessedLetters[m_lettersGuessedIndex] = letter;
				m_lettersGuessedIndex++;
				m_userKeyString = new String(m_userKey);
				System.out.println("Result: " + m_userKeyString + "\n");

			}
			System.out.println("Game Statistics: ");
			System.out.println("Total Misses: " + m_incorrectGuesses);
			
			char letter = 'x';
			//prompting user for play again input, while char letter does not equal 'y' or 'n'
			while (letter != 'y' && letter != 'n') {
				System.out.printf("\nWould you like to play again? Enter y or n: ");
				String playAgain = input.next();
				//if input is invalid, or does not == 'y' or 'n', print invalid input
				//continue while loop, prompting new input
				if (validateInput(playAgain) == true || (Character.toLowerCase(playAgain.charAt(0)) != 'y'
						&& Character.toLowerCase(playAgain.charAt(0)) != 'n')) {
					System.out.println("Invalid Input.");
				} else {
					letter = Character.toLowerCase(playAgain.charAt(0));
				}
			}
			//if the input == y, continue to replay loop
			//else end the replay loop
			if (Character.toLowerCase(letter) == 'y') {
				continue replay;
			} else {
				input.close();
				play = false;
			}
		}
	}
	// function validates user input
	// returns true if input is invalid
	static boolean validateInput(String userInput) {

		boolean invalidInput = userInput.length() > 1
				|| ((int) userInput.charAt(0) >= 91 && (int) userInput.charAt(0) <= 96) // prevents special
				|| ((int) userInput.charAt(0) >= 32 && (int) userInput.charAt(0) <= 64) // characters and numbers
				|| ((int) userInput.charAt(0) >= 123 && (int) userInput.charAt(0) <= 127);

		return invalidInput;
	}
}

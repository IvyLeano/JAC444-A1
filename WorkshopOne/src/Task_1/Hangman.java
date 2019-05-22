import java.util.Scanner;
import java.lang.Math;

public class Hangman {
	public static class GameData {
		int m_colourLength;
		int m_lettersRemaining;
		int m_guessedLetterIndex;
		int m_incorrectGuesses;
		char[] m_userKey;
		char[] m_guessedLetters;
		char[] m_answerKey;
		
		void setGame() {
			String[] colours = { "blue", "orange", "yellow", "brown", "green", "purple" };
			int index = (int) (1 + Math.random() * 5);
			m_colourLength = colours[index].length();
			m_lettersRemaining = m_colourLength;
			m_userKey = new char[m_colourLength];
			m_guessedLetters = new char[20];
			m_answerKey = new char[m_colourLength];
			m_guessedLetterIndex = 0;
			m_incorrectGuesses = 0;
			
			for (int i = 0; i < m_colourLength; i++) {
				m_userKey[i] = '*';
				m_answerKey[i] = colours[index].charAt(i);

			}
		}
		
		boolean validateLetter(char letter) {
			boolean isLetterAlreadyPlayed = false;
			String colour = new String(m_answerKey);
	
			if (m_guessedLetters[0] != '\0') { 
				for (int i = 0; i < 10; i++) {
					if (m_guessedLetters[i] == letter) {
						System.out.printf("You have already entered that value.\n");
						System.out.printf("Please try again. Enter a letter.");
						isLetterAlreadyPlayed = true;
						break;
					}
				}
			if(m_guessedLetters[19] != '\0') {
				System.out.println("You have used 20 guesses, the correct answer is: " + colour);
				closingStatements();
			}
			}
			return isLetterAlreadyPlayed;
		}
		void closingStatements() {
			Scanner input = new Scanner(System.in);
			String startingString;
			char playAgain;
			System.out.println("Game Statistics: ");
			System.out.println("Total Misses: " + m_incorrectGuesses);

			System.out.printf("\nWould you like to play again? Enter y or n: ");
			playAgain = input.next().charAt(0);
			System.out.print("_____________________________________________________________________\n");
			System.out.println();
			if (Character.toLowerCase(playAgain) == 'y') {
				setGame();
				startingString = new String(m_userKey);
				System.out.println("The colour I'm thinking of has " + m_colourLength + " letters.");
				System.out.println("Take a guess, enter a letter in: " + startingString);
			}
		}
	}
	
	public static void main(String[] args) {
		GameData newGame = new GameData();
		newGame.setGame();
		Scanner input = new Scanner(System.in);
		String startingString = new String(newGame.m_userKey);
		String colour = new String(newGame.m_answerKey);
		String userInput;
		char letter;
		boolean match;
	
		// Hangman Greeting
				System.out.println("_____________________________________________________________________\n");
				System.out.println("                        Welcome to Hangman!\n");
				System.out.println("_____________________________________________________________________\n");
				System.out.println("The category is: Colours");
				System.out.println("The colour I'm thinking of has " + newGame.m_colourLength + " letters.");
				System.out.println("You have 20 tries before the answer will be revealed. Good Luck!\n");
				System.out.printf("Take a guess, enter a letter: " + startingString);
				
				guess: while(newGame.m_lettersRemaining != 0) {
					
					System.out.println("\n");
					System.out.printf("Your Guess: ");
					userInput = input.next();
					
					letter = userInput.charAt(0);
					
					//fix this here to remove white spaces from a program in java
			        //1st way  
			        String  userInput2 = userInput.replaceAll("6", "");
					//System.out.printf(userInput2);

					
					boolean invalidInput = userInput2.length() > 1 || ((int)letter >= 91 && (int)letter <= 96) || ((int)letter >= 32 && (int)letter <= 64) ||
					((int)letter >= 123 && (int)letter <= 127);
					
					if(invalidInput) {
						System.out.printf("Your input was invalid. Please enter a single alphabetical character");
						continue guess;
					}
					if(newGame.validateLetter(letter) == true) {
						continue guess;
					}
					
					newGame.m_guessedLetters[newGame.m_guessedLetterIndex] = letter;
					newGame.m_guessedLetterIndex++;
					
					System.out.printf("Result: ");
					match = false;
					
					for (int i = 0; i < newGame.m_colourLength; i++) {
						if (Character.toLowerCase(letter) == newGame.m_answerKey[i]) {
							newGame.m_userKey[i] = letter;
							newGame.m_lettersRemaining--;
							match = true;

						}
						if (i == newGame.m_colourLength - 1 && match == false) {
							newGame.m_incorrectGuesses++;

						}
						System.out.print(newGame.m_userKey[i]);

		
						if (newGame.m_lettersRemaining == 0) {
							System.out.print("\n_____________________________________________________________________\n");
							System.out.println("Congratulations! You guessed correctly, the colour is " + colour + "!");
							newGame.closingStatements();
							
						}
					
					
				}
		//input.close();
	}
	
	}
}

//To resolve the "declared package does not match the expected package" error
//package Task_1;
import java.util.Scanner;
import java.lang.Math;


public class Hangman {
	public static void main(String[] args) {
		String[] colour = {"blue", "orange", "yellow", "brown", "green", "purple"};
		int colourIndex = (int)(1 + Math.random() * 5);
		int colourLength = colour[colourIndex].length();
		char[] userParsedColour = new char[colourLength];
		char[] parsedColour = new char[colourLength];
		int lettersRemaining = colourLength;
		
		System.out.println("__________________________________________\n");
		System.out.println("          Welcome to Hangman!\n");
		System.out.println("__________________________________________\n");
		System.out.println("The category is: Colours");
		System.out.println("The colour I'm thinking of has " + colourLength + " letters.");
		System.out.printf("Take a guess, enter a letter in: ");
		
		for(int i = 0; i < colourLength; i++) {
			System.out.printf("*");
			userParsedColour[i] = '*';
			parsedColour[i] = colour[colourIndex].charAt(i);
			
		}
		System.out.printf("\n");
		
		//System.out.print(parsedCountry.toString());
		
		while(lettersRemaining != 0) {
		
		System.out.printf("\n");
		System.out.printf("Your Guess: ");
		Scanner input = new Scanner(System.in);
		char letter = input.next().charAt(0); //nextChar() does not exist, so returns the first character in a string input instead
		
		System.out.printf("Result: ");
		System.out.printf("\n");
		for(int i = 0; i < colourLength; i++) {
			if(Character.toLowerCase(letter) == parsedColour[i]) {
				userParsedColour[i] = letter;
				lettersRemaining--;
				//System.out.println(lettersRemaining);
			}
				System.out.print(userParsedColour[i]);
			
		}
		if(lettersRemaining == 0) {
			System.out.println("\nCongratulations! You guessed correctly.\n Would you like to play again? Enter y or n: ");
			char playAgain = input.next().charAt(0);
			if(Character.toLowerCase(playAgain) == 'y') {
				lettersRemaining = colourLength;
				
			}
		}
		}
		
		
	}
}

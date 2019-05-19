//To resolve the "declared package does not match the expected package" error
//package Task_1;
import java.util.Scanner;
import java.lang.Math;


public class Hangman {
	//I created this class to make re-setting the game easier
	public static class Data {
	    String colour;
		int colourLength;
		char[] userParsedColour;
		char[] parsedColour;
		int lettersRemaining;
		String userStartingString;
		int totalMisses;
		
		void setData() {
			String[] colourOptions = {"blue", "orange", "yellow", "brown", "green", "purple"};
			int index = (int)(1 + Math.random() * 5);
			totalMisses = 0;
			colour = colourOptions[index];
			colourLength = colour.length();
			
			lettersRemaining = colourLength;
			userParsedColour = new char[colourLength];
			parsedColour = new char[colourLength];
			
			for(int i = 0; i < colourLength; i++) {
				userParsedColour[i] = '*';
				parsedColour[i] = colour.charAt(i);
				
			}
			userStartingString = new String(userParsedColour);
			
			
		}
	}
	
	
	public static void main(String[] args) {
		
		//Instantiate a new Data object called newGame
		//and invoked the setData() function to set the data values for the game
		Data newGame = new Data();
		newGame.setData();
		
		//Hangman Greeting
		System.out.println("__________________________________________\n");
		System.out.println("          Welcome to Hangman!\n");
		System.out.println("__________________________________________\n");
		System.out.println("The category is: Colours");
		System.out.println("The colour I'm thinking of has " + newGame.colourLength + " letters.");
		System.out.printf("Take a guess, enter a letter in: " + newGame.userStartingString);
		
		
		while(newGame.lettersRemaining != 0) {
		
		System.out.println("\n");
		System.out.printf("Your Guess: ");
		Scanner input = new Scanner(System.in);
		char letter = input.next().charAt(0); //nextChar() does not exist, so returns the first character in a string input instead
		
		System.out.printf("Result: ");
	
		for(int i = 0; i < newGame.colourLength; i++) {
			if(Character.toLowerCase(letter) == newGame.parsedColour[i]) {
				newGame.userParsedColour[i] = letter;
				newGame.lettersRemaining--;
			}
			else {
				newGame.totalMisses++;
			}
				System.out.print(newGame.userParsedColour[i]);
			
		}
		System.out.printf("\n");
		if(newGame.lettersRemaining == 0) {
			System.out.println("__________________________________________\n");
			System.out.println("Congratulations! You guessed correctly, the colour is " + newGame.colour + "!");
			System.out.println("Game Statistics: ");
			System.out.println("Total Misses: " + newGame.totalMisses);
			
			System.out.printf("Would you like to play again? Enter y or n: ");
			char playAgain = input.next().charAt(0);
			
			
			if(Character.toLowerCase(playAgain) == 'y') {
				newGame.setData();
				System.out.println("The colour I'm thinking of has " + newGame.colourLength + " letters.");
			}
			
			System.out.println("__________________________________________\n");
		}
		}
		
	}
	
}
import java.util.Scanner;
import java.lang.Math;

public class Craps {
	public static class GameData {
		int die1;
		int die2;
		int sum;

		void rollDice() {
			die1 = (int) (1 + Math.random() * 6);
			die2 = (int) (1 + Math.random() * 6);
			sum = die1 + die2;
		}
		/*
		void tryAgain() {
			int point = sum;
			boolean gameOver = false;
			
			while(gameOver == false) {
				rollDice();
				System.out.println("You rolled " + newGame.die1 + " + " + newGame.die2 + " = " + newGame.sum);
				
				if(sum == 7) {
					System.out.println("You lose");
					gameOver = true;
				}
				else if(sum == point) {
					System.out.println("You win");
					gameOver = true;
				}
				
			}
			
			
			
		}
		*/
	}

	public static void main(String[] args) {
		
		boolean tryAgain = false;
		boolean gameOver = false;
		
		while(gameOver == false) {
		GameData newGame = new GameData();
		newGame.rollDice();
		
		int point = 0;
		boolean craps = newGame.sum == 2 || newGame.sum == 3 || newGame.sum == 12;
		boolean natural = newGame.sum == 7 || newGame.sum == 11;
		
		System.out.println("You rolled " + newGame.die1 + " + " + newGame.die2 + " = " + newGame.sum);
		
	
		if(craps && tryAgain == false) {
			System.out.println("You lose");
			gameOver = true;
		}
		else if(natural && tryAgain == false) {
			System.out.println("You win!");
			gameOver = true;
		}
		else if(tryAgain == true && newGame.sum == 7) {
			System.out.println("You lose");
			gameOver = true;
		}
		else if(tryAgain == true && newGame.sum == point) {
			System.out.println("You win!");
			gameOver = true;
		}
		else {
			System.out.println("Try Again");
			tryAgain = true;
			point = newGame.sum;
			pause();
			//newGame.tryAgain();
		}
		
		}
	}
	
}
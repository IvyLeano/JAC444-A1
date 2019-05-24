
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

		// Pause between rolls
		void pause() {
			for (int i = 0; i < 1000000000; i++) {
				if (i % 100000000 == 0) {
					System.out.printf("*");
				}
			}
		}
	}

	public static void main(String[] args) {
		GameData newGame = new GameData();

		// tryAgain: false == first try, true == multiple tries
		// gameOver: true == ending of while loop and ending of rolls
		// rollcount to indicate the number of rolls
		boolean gameOver = false;;
		int point = 0;

		// greetings
		System.out.println("********************************************************");
		System.out.println("                WELCOME TO A GAME OF CRAPS");
		System.out.println("********************************************************");

		while (gameOver == false) {
			newGame.rollDice();

			boolean craps = newGame.sum == 2 || newGame.sum == 3 || newGame.sum == 12;
			boolean natural = newGame.sum == 7 || newGame.sum == 11;

			System.out.println("You rolled a " + newGame.die1 + " + " + newGame.die2 + " = " + newGame.sum);

			// first roll
			if (craps) {
				System.out.println("You Lose");
				gameOver = true;
			}
			// first roll
			else if (natural) {
				System.out.println("You Win!");
				gameOver = true;
			} else {
				point = newGame.sum;
				System.out.println("point value: " + point + "\n");
				boolean end = false;
				while(end == false){
					newGame.rollDice();
					System.out.println("You rolled a " + newGame.die1 + " + " + newGame.die2 + " = " + newGame.sum);
					if(newGame.sum == 7){
						System.out.println("You Lose");
						gameOver = true;
						end = true;
					}
					else if(newGame.sum == point){
						System.out.println("You Win!");
						gameOver = true;
						end = true;
					}
				}
			}
		}

		}
	}



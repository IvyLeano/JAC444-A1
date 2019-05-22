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
		//Pause between rolls
		void pause() {
			for(int i = 0; i < 1000000000; i++) { if(i % 100000000 == 0) {System.out.printf("*");}}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GameData newGame = new GameData();
		
		//tryAgain: false == first try, true == multiple tries
		//gameOver: true == ending of while loop, ending of rolls
		//rollcount to indicate the number of rolls
		boolean tryAgain = false; 
		boolean gameOver = false;
		int rollCount = 1;
		int point = 0;
		
		System.out.println("********************************************************");
		System.out.println("                WELCOME TO A GAME OF CRAPS");
		System.out.println("********************************************************");
		
		while(gameOver == false) {
		newGame.rollDice();
		
		boolean craps = newGame.sum == 2 || newGame.sum == 3 || newGame.sum == 12;
		boolean natural = newGame.sum == 7 || newGame.sum == 11;
		
		System.out.println("\nRoll Number " + rollCount + ":");
		System.out.println("You rolled a " + newGame.die1 + " + " + newGame.die2 + " = " + newGame.sum);
		
		//first roll
		if(craps && tryAgain == false) { 
		System.out.println("You Lose");
			gameOver = true;
		}
		//first roll
		else if(natural && tryAgain == false) {
		System.out.println("You Win!");
			gameOver = true;
		}
		//consecutive rolls
		else if(tryAgain == true && newGame.sum == 7) {
		System.out.println("You Lose");
			gameOver = true;
		}
		//consecutive rolls
		else if(tryAgain == true && newGame.sum == point) {
		System.out.println("You Win!");
			gameOver = true;
		}
		else {
			rollCount++;
		    System.out.println("Point is " + newGame.sum);
		    System.out.println("Rolling Again \n");
			newGame.pause();
			tryAgain = true;
			point = newGame.sum;
		}
		
		}
	}
	
}
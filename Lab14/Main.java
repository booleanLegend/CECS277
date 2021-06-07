import java.util.Scanner;
import java.util.*;
import java.util.Random;

/**
* Group# 09
* Name: Erik Nguyen and Matthew Zaldana
* Date: 12-01-2020
* Purpose: Make an interactive Tic-Tac-Toe game implementing the Memento design patter 
*/
class Main {
	public static void main(String[] args) {
    	Stack<Memento> boardHistory = new Stack<Memento>();
		Board b = new Board();
		int userRow, userCol;
		int count = 0;
		int menuChoice = 3;
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		int rand1, rand2;
		
		b.display();
		
		do {
			System.out.println("\n1. Place token\n2. Revert\n3. Quit");
			menuChoice = CheckInput.getIntRange(1, 3);
			
			if (menuChoice == 1) {
				if (count != 0) {
					boardHistory.push(b.save());
					}
				if (count % 2 == 0) {
					System.out.print("\nPlace an x\nRow: ");
					userRow = CheckInput.getIntRange(0, 2);
					System.out.print("Col: ");	
					userCol = CheckInput.getIntRange(0, 2);
					if (b.placeToken('x', userRow, userCol)) {
						if (b.checkWin('x') == 'x') {
							System.out.println("Player x wins! Game over.");
							break;
						} else if (b.checkWin('x') == 'd') {
							System.out.println("No one wins! Game over.");
							break;
						}
						count++;						
					} else {
						System.out.println("Could not place an x there");
					}
				} else {
					rand1 = rand.nextInt(2) + 1;
					rand2 = rand.nextInt(2) + 1;
					/*
					System.out.print("\nPlace an o\nRow: ");
					userRow = CheckInput.getIntRange(0, 2);
					System.out.print("Col: ");	
					userCol = CheckInput.getIntRange(0, 2);
					*/
					while (!b.placeToken('o', rand1, rand2)) {
						rand1 = rand.nextInt(2) + 1;
						rand2 = rand.nextInt(2) + 1;
					}
					if (b.checkWin('o') == 'o') {
						System.out.println("Player o wins! Game over.");
						break;
					} else if (b.checkWin('o') == 'd') {
						System.out.println("No one wins! Game over.");
						break;
					}
					count++;
				}
			} else if (menuChoice == 2) {
				b.restore(boardHistory.pop());
			} 
			b.display();
		
		} while (menuChoice != 3);
		System.exit(0);
  	}
}


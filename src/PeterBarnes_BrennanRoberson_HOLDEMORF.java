/*
 * This version of the game uses the string
 * "HOLDEMORF:)" instead of the numbers.  This was
 * accomplished by using a backend number grid
 * that operates the same as a standard 2048 game
 * but is then formatted before it is printed
 * To the user to have the strings that form HOLDEMORF:)
 * again, instead of numbers.*/
import java.util.Scanner;
import java.util.Random;

public class PeterBarnes_BrennanRoberson_HOLDEMORF {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	
	// Method that generates random coordinates on the grid to put either a 2 or 4.
	public void fillSpace(int[][]table){
		int number;
		// This is where either a 2 or a 4 is picked
		int percent = rd.nextInt(100);
		if(percent < 79){
			number = 2;
		} else {
			number = 4;
		}
		int option = 0;
		while(option == 0){
			// Generates 2 random numbers as coordinates.
			int r = rd.nextInt(4);
			int c = rd.nextInt(4);
			// If the space at that coordinate is 0, the space is set to either a 2 or 4
			if(table[r][c] == 0){
				table[r][c] = number;
				option = 1;
			// If the space is occupied, the program simply resets the value of that space to itself.
			} else if(table[r][c] != 0){
				table[r][c] = table[r][c];
			}
		}
	}
	
	
	
	public void moveLeft(int[][] table){
		for(int j = 0; j < 4; j++){
			for(int c = 0; c < 4; c++){
				for(int i = 1; i < 4; i++){
					// This is where we check if the space is 0, equal to the current space, or not equal to the current space
					if(table[j][i] != 0){
						if(table[j][i-1] == 0){
							table[j][i-1] = table[j][i];
							table[j][i] = 0;
						} else if(table[j][i-1] == table[j][i]){
							table[j][i-1] = (table[j][i]) * 2;
							table[j][i] = 0;
						} else if(table[j][i-1] != table[j][i]){
							// Do nothing
						}
					}
				}
			}
		}
	}
	
	public void moveRight(int[][] table){
		for(int j = 0; j < 4; j++){
			for(int c = 0; c < 4; c++){
				for(int i = 2; i >= 0; i--){
					if(table[j][i] != 0){
						if(table[j][i+1] == 0){
							table[j][i+1] = table[j][i];
							table[j][i] = 0;
						} else if(table[j][i+1] == table[j][i]){
							table[j][i+1] = table[j][i] * 2;
							table[j][i] = 0;
						} else if(table[j][i+1] !=  table[j][i]){
							// Do nothing
						}
					}
				}
			}
		}
	}
	
	public void moveUp(int[][] table){
		for(int i = 0; i < 4; i++){
			for(int c = 0; c < 4; c++){
				for(int j = 1; j < 4; j++){
					if(table[j][i] != 0){
						if(table[j-1][i] == 0){
							table[j-1][i] = table[j][i];
							table[j][i] = 0;
						} else if(table[j-1][i] == table[j][i]){
							table[j-1][i] = table[j][i] * 2;
							table[j][i] = 0;
						} else if(table[j-1][i] != table[j][i]){
							// Do nothing
						}
					}
				}
			}
		}
	}
	
	public void moveDown(int[][] table){
		for(int i = 0; i < 4; i++){
			for(int c = 0; c < 4; c++){
				for(int j = 2; j >= 0; j--){
					if(table[j][i] != 0){
						if(table[j+1][i] == 0){
							table[j+1][i] = table[j][i];
							table[j][i] = 0;
						} else if(table[j+1][i] == table[j][i]){
							table[j+1][i] = table[j][i] * 2;
							table[j][i] = 0;
						} else if(table[j+1][i] != table[j][i]){
							// Do nothing
						}
					}	
				}	
			}
		}
	}
	
	// This method is the main driver of the game, it prompts the user for input and handles it.
	public void moveSpace(int[][] table, String[][] letters){
		System.out.println("Enter your direction [W-A-S-D]");
		String input = sc.next();
		System.out.println(input);
		if(input.equalsIgnoreCase("a")){
			moveLeft(table);
		} else if(input.equalsIgnoreCase("w")){
			moveUp(table);
		} else if(input.equalsIgnoreCase("s")){
			moveDown(table);
		} else if(input.equalsIgnoreCase("d")){
			moveRight(table);
		}
		fillSpace(table);
		printTable(table, letters);
	}
	// This is the string formatting, each stage of 2048 is associated with a certain chunk of "HOLDEMORF:)"
	public void printTable(int[][] table, String[][] letters){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(table[i][j] == 0){
					letters[i][j] = "X";
				} else if(table[i][j] == 2){
					letters[i][j] = "H";
				} else if(table[i][j] == 4){
					letters[i][j] = "HO";
				} else if(table[i][j] == 8){
					letters[i][j] = "HOL";
				} else if(table[i][j] == 16){
					letters[i][j] = "HOLD";
				} else if(table[i][j] == 32){
					letters[i][j] = "HOLDE";
				} else if(table[i][j] == 64){
					letters[i][j] = "HOLDEM";
				} else if(table[i][j] == 128){
					letters[i][j] = "HOLDEMO";
				} else if(table[i][j] == 256){
					letters[i][j] = "HOLDEMOR";
				} else if(table[i][j] == 512){
					letters[i][j] = "HOLDEMORF";
				} else if(table[i][j] == 1024){
					letters[i][j] = "HOLDEMORF:";
				} else if(table[i][j] == 2048){
					letters[i][j] = "HOLDEMORF:)";
				}
				System.out.print(letters[i][j] + "\t\t");
			}
			System.out.println(" ");
		}
	}
	
	// This is how we check if the game is over because the board is full, or if the game is won.
	public boolean gameWin(boolean win, int[][] table){
		int counter = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(table[i][j] == 2048){
					System.out.println("Congratuations, you got HOLDEMORF:)");
					win = true;
					break;
				} else if(table[i][j] != 2048 && table[i][j] != 0){
					counter++;
				}
			}
		}
		if(counter == 16){
			win = true;
			System.out.println("The board is full game over");
		}
		return win;
	}
	// Running game...
	public static void main(String[] args) {
		boolean win = false;
		PeterBarnes_BrennanRoberson_HOLDEMORF game = new PeterBarnes_BrennanRoberson_HOLDEMORF();
		
		int[][] table = new int[4][4];
		String[][] letters = new String[4][4];
		game.fillSpace(table);
		game.fillSpace(table);
		game.printTable(table, letters);
		
		do{
			
			game.moveSpace(table, letters);
			win = game.gameWin(win, table);
			
		}while(win == false);
	}	
}

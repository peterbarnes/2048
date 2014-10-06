import java.util.Scanner;
import java.util.Random;

public class Game2048 {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	
	public void fillSpace(int[][]table){
		int option = 0;
		while(option == 0){
			int r = rd.nextInt(4);
			int c = rd.nextInt(4);
			if(table[r][c] == 0){
				table[r][c] = 2;
				option = 1;
			} else if(table[r][c] != 0){
				table[r][c] = table[r][c];
			}
		}

	}
	
	public void moveLeft(int[][] table){
		for(int j = 0; j < 4; j++){
			for(int c = 0; c < 4; c++){
				for(int i = 1; i < 4; i++){
					if(table[j][i] != 0){
						if(table[j][i-1] == 0){
							table[j][i-1] = table[j][i];
							table[j][i] = 0;
						} else if(table[j][i-1] == table[j][i]){
							table[j][i-1] = table[j][i] * 2;
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
						table[j-1][i] = table[j][i];
						table[j][i] = 0;
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
						table[j+1][i] = table[j][i];
						table[j][i] = 0;	
					}	
				}	
			}
		}
	}
	
	public void moveSpace(int[][] table){
		System.out.println("Enter your direction [W-A-S-D]");
		System.out.println("1");
		String input = sc.next();
		System.out.println(input);
		if(input.equalsIgnoreCase("a")){
			System.out.println("2");
			moveLeft(table);
		} else if(input.equalsIgnoreCase("w")){
			System.out.println("3");
			moveUp(table);
		} else if(input.equalsIgnoreCase("s")){
			System.out.println("4");
			moveDown(table);
		} else if(input.equalsIgnoreCase("d")){
			System.out.println("5");
			moveRight(table);
		}
		System.out.println("6");
		fillSpace(table);
		System.out.println("7");
		printTable(table);
		System.out.println("done");
	}
		
	public void printTable(int[][] table){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(table[i][j] + "\t");	
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		int option = 0;
		Game2048 game = new Game2048();
		
		int[][] table = new int[4][4];
		game.fillSpace(table);
		game.fillSpace(table);
		game.printTable(table);
		
		do{
			
			game.moveSpace(table);
			
		}while(option == 0);
	}	

}

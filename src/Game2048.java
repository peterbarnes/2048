import java.util.Scanner;
import java.util.Random;

public class Game2048 {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	
	public void fillSpace(int[][]table){
		int r = rd.nextInt(4);
		int c = rd.nextInt(4);
		int option = 0;
		do{
			if(table[r][c] == 0){
				// TODO Add random 4
				table[r][c] = 2;
				option = 1;	
			} else if(table[r][c] != 0){
				table[r][c] = table[r][c];
			}
		}while(option == 0);
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
							table[j][i-1] = table[j][i] * table[j][i];
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
						table[j][i + 1] = table[j][i];
						table[j][i] = 0;
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
		int r = rd.nextInt(4);
		int c = rd.nextInt(4);
		System.out.println("Enter your direction [W-A-S-D]");
		String input = sc.next();
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
		printTable(table);
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

import java.util.Scanner;
import java.util.Random;

public class Game2048 {
	
	public void fillSpace(int[][]table, int r, int c){
		
		Random rd = new Random();
		r = rd.nextInt(4);
		c = rd.nextInt(4);
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
	
	public void printTable(int[][] table){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(table[i][j] + " ");	
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		Game2048 game = new Game2048();
		int r = 0, c = 0;
		
		int[][] table = new int[4][4];
		game.fillSpace(table, r, c);
		game.fillSpace(table, r, c);
		game.printTable(table);
		
	}	

}

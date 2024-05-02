import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[][] board = new char[15][5];
		

		int k=0;
		for(int i=0; i<5; i++) {
			String s = scan.nextLine();
			
			int j=0;
			for(char ch : s.toCharArray()) {
				board[j++][k] = ch;
			}
			k++;
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] != 0 ? board[i][j] : "");
			}
		}
		
		scan.close();
	}
}

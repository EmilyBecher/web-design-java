//import java.lang.reflect.Array;
import java.util.Scanner;

//Emily Becher
//TicTacToe
//11/15/2018
public class TicTacToe {

	int [][] board = new int [3][3];
	final int blank = 0;
	final int X = 1;
	final int O = 2;
	final int X_turn = 0;
	final int O_turn = 1;
	int turn = X_turn;
	int XWins = 0;
	int OWins = 0;
	Scanner scanner;
	String input = "";
	
	public TicTacToe() {
		scanner = new Scanner(System.in);
		boolean nextGame = true;
		while (nextGame == true) {
			boolean stillplaying = true;
			while (stillplaying == true) { // continues game while there is not a tie or win
				
			
					printBoard();
					input = scanner.nextLine();//This code gets user entry and checks it
					if (input.length() != 2) {
						System.out.println("Enter a letter followed by a number");
					} //Checks that user entry is a/b/c then 1/2/3
					else if (input.charAt(0) != 'a' &&
						 	input.charAt(0) != 'b' &&
						 	input.charAt(0) != 'c') {
						System.out.println("Row must be an a, b, or c");
					}
					else if (input.charAt(1) != '1' &&
				 		 	input.charAt(1) != '2' &&
						 	input.charAt(1) != '3') {
						System.out.println("Column must be an 1, 2, or 3");
					}
					else { //Checks that the space is blank
						int row = input.charAt(0) - 'a';
						int column = input.charAt(1) - '1';
						if (board[row][column] == blank) {
							if (turn == X_turn) {
								board[row][column] = X;
								turn = O_turn;
							}
							else {
								board[row][column] = O;
								turn = X_turn;
							}
						}
						else {
							System.out.println("There is already a piece there"); 
						}
					}
				 //Outputs game result
				if (win(X) == true) {
					XWins = XWins + 1;
					printBoard();
					System.out.println("X wins");
					stillplaying = false;
				}
				else if (win(O) == true) {
					OWins = OWins + 1;
					printBoard();
					System.out.println("O wins");
					stillplaying = false;
				}
				else if (tie() == true ) {
					printBoard();
					System.out.println("Tie!");
					stillplaying = false;
				}
				if (stillplaying == false) { //Ask if they want to play again and output wins accordingly
					System.out.println("Do you want to play again?");
					String yesno = scanner.nextLine();
					if (yesno.equals("yes") || yesno.equals("y")) {
						nextGame = true;
						board[0][0] = blank;
						board[1][0] = blank;
						board[2][0] = blank;
						board[0][1] = blank;
						board[1][1] = blank;
						board[2][1] = blank;
						board[0][2] = blank;
						board[1][2] = blank;
						board[2][2] = blank;
						System.out.println("X has "+ XWins +" wins and O has "+ OWins +" wins.");
						stillplaying = true;
						}
					else {
						System.out.println("X won "+ XWins +" games and O won "+ OWins +" games");
						nextGame = false;}
				
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToe();
	}
	public void printBoard() { //Outputs the board
		System.out.println(" \t1\t2\t3");
		for (int row = 0; row < board.length; row++) {
			String output = (char)('a' +row) +"\t";
			for (int column = 0; column <  board[0].length; column++) {
				if (board[row][column] == blank) {
					output += " \t";
				}
				else if  (board[row][column] == X) {
					output += "X\t";
				}
				else if (board[row][column] == O) {
					output += "O\t";
				}
			}

			System.out.println(output);
		}
	}

	public boolean win(int player) { //Checks for all possible win conditions
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player) { //top row
			return true;
		}
		else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) { //middle row
			return true;
		}
		else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) { //bottom row
			return true;
		}
		else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) { //left column
			return true;
		}
		else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) { //middle column
			return true;
		}
		else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) { //right column
			return true;
		}
		else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) { //diagonal down
			return true;
		}
		else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) { //diagonal up
			return true;
		}
		
		return false;
	}
	
	public boolean tie() { //checks for tie
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				if (board[row][column] == blank) {
					return false;
				}
			}
		}
		return true;
	}
}


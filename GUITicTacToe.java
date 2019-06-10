//Emily Becher
//GUI TicTacToe
//11/28/2018
//Based off code from videos

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITicTacToe implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	int[][] board = new int[3][3];
	final int blank = 0;
	final int X = 1;
	final int O = 2;
	final int X_turn = 0;
	final int O_turn = 1;
	int turn = X_turn;
	Container center = new Container();
	JLabel xname = new JLabel("X wins: 0");
	JLabel oname = new JLabel("O wins: 0");
	JButton xChangeName = new JButton("X's Name");
	JButton oChangeName = new JButton("O's Name");
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	Container north = new Container();
	String xPlayerName = "X";
	String oPlayerName = "O";
	int XWins = 0;
	int OWins = 0;
	
	public GUITicTacToe() {
		//Format Board
		frame.setSize(400, 400);
		//Center Grid Container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
			//Add Buttons
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i] = new JButton(j+","+i);
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
			}
		}
		//Add things to the frame
		frame.add(center, BorderLayout.CENTER);
		//North Container
		north.setLayout(new GridLayout(3,2));
		north.add(xname);
		north.add(oname);
		frame.add(north, BorderLayout.NORTH);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeField);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUITicTacToe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton current;
		boolean gridButton = false;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				if (e.getSource().equals(button[j][i])) {
					gridButton = true;
					current = button[j][i];
					//Play and switch the turn
					if (board[j][i] == blank) {
						if (turn == X_turn) {
							current.setText("X");
							current.setEnabled(false);//disable buttons
							board[j][i] = X;
							turn = O_turn;
						}
						else {
							current.setText("O");
							current.setEnabled(false);
							board[j][i] = O;
							turn = X_turn;
						}
						//Check for wins and ties
						if (win(X) == true) {
							XWins++;
							xname.setText(xPlayerName + " Wins: " + XWins);
							clearBoard();
						}
						else if (win(O) == true) {
							OWins++;
							oname.setText(oPlayerName + " Wins: " + OWins);
							clearBoard();
						}
						else if (tie() == true) {
							clearBoard();
						}
					}
				}
			}
		}
		//Change Player Names
		if (gridButton == false) {
			if (e.getSource().equals(xChangeName) == true) {
				xPlayerName = xChangeField.getText();
				xname.setText(xPlayerName + " wins: " + XWins);
			}
			else if (e.getSource().equals(oChangeName) == true) {
				oPlayerName = oChangeField.getText();
				oname.setText(oPlayerName + " wins: " + OWins);
			}
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
	//Reset Board
	public void clearBoard() {
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board[0].length; b++) {
				JButton current;
				current = button[a][b];
				board[a][b] = blank;
				button[a][b].setText("");
				current.setEnabled(true);
			}
		}
		turn = X_turn;//reset turn
	}

}

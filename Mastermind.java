import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
	boolean playing = true;
	
	//Intro
	System.out.println("This is Mastermind!");
	System.out.println("The goal of the game is to crack the randomly generated code.");
	System.out.println("You know the digits in the code range from 1 to 8.");
	while (playing == true) {
	   final String[] colors = {"1", "2", "3", "4", "5", "6", "7", "8"};
	   int numberOfPegs = 4;
	   		//Number of digits in code
	   		System.out.println("How long of a code would you like to try to crack? Enter a number.");
	   		boolean moveOn = true;
	   		while (moveOn == true) {
		   		Scanner in = new Scanner(System.in);
		   		String num = in.nextLine();
		   		numberOfPegs = Integer.parseInt(num);
		   		if (numberOfPegs > 1 && numberOfPegs < 20) {
		   			moveOn = false;
		   		}
		   		else {//limit responses
		   			System.out.println("That is unreasonable. Try a number between 1 and 20");
		   		}
	   		}
	   	//Randomly generate code
	        Random generator = new Random();
	        String code = "";
	        int index = 4;
	        String[] c = colors;
	        for(int i = 0; i < numberOfPegs; i++)
	        {
	            index=generator.nextInt(c.length);
	            code+=c[index];
	        }
	        //System.out.println(code); //This line is used to test the program
	        
	        System.out.println("The code is set. Good luck.");
	        
	        //Get Guess and Check against code
	        int red = 0;
	        int white = 0;
	        int turns = 0;//keep track of the number of guesses made by the player
	        while(red < numberOfPegs) {//allows user to keep playing until they have guessed the code
	        red = 0;//reset counters for each guess
	        white = 0;
	        char[] chars = code.toCharArray();
	        //Get Guess
	        boolean move = true;
	        char[] guessChars = chars;
	        String guess = " ";
	        while (move == true) {//checks to make sure the guess is valid
		        System.out.println("Guess:");
		        Scanner scan = new Scanner(System.in);
		        guess = scan.nextLine();
		        guessChars = guess.toCharArray();
		        if (guessChars.length != numberOfPegs) {//checks if guess is the correct length
		        	System.out.println("Your guess needs to be the same length as the code. The code is " + numberOfPegs + " digits.");
		        }
		        else {
			        for (int i = 0; i < guessChars.length; i++) {//checks if the guess is only valid characters
			        	String numbers = "12345678";
			        	char[] nums = numbers.toCharArray();
			        	if (guessChars[i] == nums[0] || guessChars[i] == nums[1] || guessChars[i] == nums[2] || guessChars[i] == nums[3] || guessChars[i] == nums[4] || guessChars[i] == nums[5] || guessChars[i] == nums[6] || guessChars[i] == nums[7]) {
			        		move = false;//breaks out of while loop
			        	}
			        	else {
			        		System.out.println("The digits you entered don't make sense. The digits are 1, 2, 3, 4, 5, 6, 7, or 8.");
			        		i = guessChars.length + 1;//if any digit doesn't make sense don't check the rest
			        		move = true;//ask user for another guess by continuing in loop
			        	}
			        }
		        }
	        }
	        char[] tempChars = chars;
	        char[] tempGuess = guessChars;
	        String match1 = "XY";
	        char[] match = match1.toCharArray();
	        //Correct number and correct placement
	        for (int i = 0; i < numberOfPegs; i++) {
	        	if (tempChars[i] == tempGuess[i]) {
	        		tempChars[i] = match[0];//changes code digit to X so it can't be double counted
	        		tempGuess[i] = match[1];//changes guess digit to Y so it can't be double counted
	        		red++;
	        	}
	        }
	        //Correct number and wrong placement
	        for (int i = 0; i < numberOfPegs; i++) {
			int j = 0;//resets j to 0 in order to run through all the possiblilities again
	        	for (int j = 0; j < numberOfPegs; j++) {
	        		if (tempChars[i] == tempGuess[j]) {
	        			tempChars[i] = match[0];//avoids double counting
		        		tempGuess[j] = match[1];//avoids double counting
		        		white++;
	        		}
	        	}
	        }
	        //Outputs
	        System.out.println(guess + " Correct numbers in the right places: "+ red);
	        System.out.println("Correct numbers in the wrong places: " + white);
	        turns++;//counts turns (only valid turns)
	        }
	        System.out.println("You Win! The code was " + code);
	        if (turns == 1) {//Makes sure the grammar of the output is good
	        	System.out.println("It took you 1 guess.");
	        }
	        else {
	        	System.out.println("It took you " + turns + " guesses.");
	        }
		//Continue playing?
	        System.out.println("Would you like to play again? (y/n)");
	        Scanner yesno = new Scanner(System.in);
	        String want = yesno.nextLine();
	        if (want.equals("y") || want.equals("yes") || want.equals("Yes") || want.equals("YES") || want.equals("Y")) {//many options for saying yes
	        	playing = true;
	        }
	        else {
	        	playing = false;
	        	System.out.println("Thanks for playing.");
	        }
	    }
	}
}

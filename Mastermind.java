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
		   		else {
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
	        System.out.println(code);
	        
	        System.out.println("The code is set. Good luck.");
	        
	        //Get Guess and Check against code
	        int red = 0;
	        int white = 0;
	        int turns = 0;
	        while(red < numberOfPegs) {
	        red = 0;
	        white = 0;
	        char[] chars = code.toCharArray();
	        //Get Guess
	        boolean move = true;
	        char[] guessChars = chars;
	        String guess = " ";
	        while (move == true) {
		        System.out.println("Guess:");
		        Scanner scan = new Scanner(System.in);
		        guess = scan.nextLine();
		        guessChars = guess.toCharArray();
		        if (guessChars.length != numberOfPegs) {
		        	System.out.println("Your guess needs to be the same length as the code. The code is " + numberOfPegs + " digits.");
		        }
		        else {
			        for (int i = 0; i < guessChars.length; i++) {
			        	String numbers = "12345678";
			        	char[] nums = numbers.toCharArray();
			        	if (guessChars[i] == nums[0] || guessChars[i] == nums[1] || guessChars[i] == nums[2] || guessChars[i] == nums[3] || guessChars[i] == nums[4] || guessChars[i] == nums[5] || guessChars[i] == nums[6] || guessChars[i] == nums[7]) {
			        		move = false;
			        	}
			        	else {
			        		System.out.println("The digits you entered don't make sense. The digits are 1, 2, 3, 4, 5, 6, 7, or 8.");
			        		i = guessChars.length + 1;
			        		move = true;
			        	}
			        }
		        }
	        }
	        char[] tempChars = chars;
	        char[] tempGuess = guessChars;
	        String match1 = "XY";
	        char[] match = match1.toCharArray();
	        //Correct color and placements
	        for (int i = 0; i < numberOfPegs; i++) {
	        	if (tempChars[i] == tempGuess[i]) {
	        		tempChars[i] = match[0];
	        		tempGuess[i] = match[1];
	        		red++;
	        	}
	        }
	        //Correct color wrong placement
	        for (int i = 0; i < numberOfPegs; i++) {
	        	for (int j = 0; j < numberOfPegs; j++) {
	        		if (tempChars[i] == tempGuess[j]) {
	        			tempChars[i] = match[0];
		        		tempGuess[j] = match[1];
		        		white++;
	        		}
	        	}
	        	int j = 0;
	        }
	        //Outputs
	        System.out.println(guess + " Correct numbers in the right places: "+ red);
	        System.out.println("Correct numbers in the wrong places: " + white);
	        turns++;
	        }
	        System.out.println("You Win! The code was " + code);
	        if (turns == 1) {
	        	System.out.println("It took you 1 guess.");
	        }
	        else {
	        	System.out.println("It took you " + turns + " guesses.");
	        }
	        System.out.println("Would you like to play again? (y/n)");
	        Scanner yesno = new Scanner(System.in);
	        String want = yesno.nextLine();
	        if (want.equals("y") || want.equals("yes") || want.equals("Yes") || want.equals("YES") || want.equals("Y")) {
	        	playing = true;
	        }
	        else {
	        	playing = false;
	        	System.out.println("Thanks for playing.");
	        }
	    }
	}
}


import java.util.Scanner;

public class GuessingGame {
	public GuessingGame() {
		boolean stillPlaying = true;
		while (stillPlaying == true) 
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select your range. What is your maximum value?");
			int max = 51;
			int min = -1;
			String maximum = scanner.nextLine();
			max = Integer.parseInt(maximum);
			if (max > 0) {
				max += 1;
			int randomNum = (int)(Math.random()*max);
			//System.out.println("This is a random number: "+randomNum);
			System.out.println("I have a random number. Make your guess.");
			int guess = -1;
			int turns = 0;
			while (guess != randomNum)
			{
				String input = scanner.nextLine();
				System.out.println("You guessed:"+input);
				guess = Integer.parseInt(input);
				//System.out.println(guess);
				if (guess < max && guess > min)
				{
					turns += 1;
					if (guess < randomNum) {
						System.out.println("Guess is less than my number");
						min = Integer.parseInt(input);
					}
					else if (guess > randomNum) {
						System.out.println("Guess is greater than my number");
						max = Integer.parseInt(input);
					}
				}
				else
				{
					System.out.println("Your guess doesn't make sense. Try again.");
				}
			}
			
			System.out.println("You guessed the number in " +turns);
			System.out.println("turns! Play again?");
			String yesno = scanner.nextLine();
			if (yesno.equals("yes") || yesno.equals("y")) {
				stillPlaying = true;}
			else {
				stillPlaying = false;}
		}
	else {
		System.out.println("Your maximum is not greater than zero. Try again.");
	}}}
	public static void main(String[] args)
	{new GuessingGame();
	
	}
	
}//Based off supplied code

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTranslator {

	public BinaryTranslator() {
		boolean stillPlaying = true;
		while (stillPlaying == true) 
		{
		System.out.println("Please enter \"file\" to enter a file or \"input\" to use the console");
		java.util.Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String numberInput = "";
		if (input.equals("file")) { //input from a file
			try {
				System.out.println("Enter your file name.");
				input = scanner.nextLine();
				java.util.Scanner fileScanner = new Scanner(new File(input));
				numberInput = fileScanner.nextLine();
			} catch (IOException ex) {
				System.out.println("File not found.");
				scanner.close();
				System.exit(1);
			}
			
		}
		else { //input from the console
			System.out.println("Enter your number");
			numberInput = scanner.nextLine();
		}
		System.out.println("If you are translating from decimal to binary type \"dtb\".");
		System.out.println("If you are translating from binary to decimal type \"btd\".");
		System.out.println("If you are translating from decimal to octal type \"dto\".");
		System.out.println("If you are translating from octal to decimal type \"otd\".");
		input = scanner.nextLine();
		if (input.equals("dtb")) { //decimal to binary
			String answer = "";
			int number = Integer.parseInt(numberInput);
			while (number > 0) {
				if (number % 2 == 1) {
					answer = "1" + answer;
				}
				else
				{
					answer = "0" + answer;
				}
				number = number / 2;
			}
			System.out.println(answer);
		}
		else if (input.equals("btd")){ //binary to decimal
			int answer = 0;
			int exp = 0;
			int num = 0;
			for (int a = numberInput.length() -1; a >= 0; a--) {
				if (numberInput.charAt(a) == '1'){
					answer = answer + (int)(Math.pow(2,a));	
					num = 1;
				}
				else if (numberInput.charAt(a) == '0')
				{
					if (num < 1) {
						exp ++;
					}
				}
			}
			while (exp > 0) {
				answer = answer * 2;
				exp --;
			}
			System.out.println(answer);
		}
		System.out.println("Do you want to translate more numbers?");
		String yesno = scanner.nextLine();
		if (yesno.equals("yes") || yesno.equals("y")) {
			stillPlaying = true;}
		else {
			stillPlaying = false;}
		}
	}
	public static void main(String[] args) {
		new BinaryTranslator();

	}

}

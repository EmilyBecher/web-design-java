//Emily Becher

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {

	Scanner consoleInput = new Scanner(System.in);
	String input;
	Scanner fileInput;
	int[] inputArray;
	long startTime;
	
	public Sort() {
		System.out.println("Enter a number for the input file.");
		System.out.println("1: input1.txt, 2: input2.txt, 3: input3.txt, 4: input4.txt");
		input = consoleInput.nextLine();
		if (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') {
			System.out.println("Enter 1, 2, 3, 4");
			while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') {
				input = consoleInput.nextLine();
			}
		}
		try {
			fileInput = new Scanner(new File("input" + input.charAt(0) + ".txt"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		String infile = fileInput.nextLine();
		String[] inputStringArray = infile.split(",");
		inputArray = new int[inputStringArray.length];
		for (int i = 0; i < inputStringArray.length; i++) {
			inputArray[i] = Integer.parseInt(inputStringArray[i]);
			System.out.println(inputArray[i]);
		}
		
		System.out.println("Enter a number for the sort you want to use.");
		System.out.println("1: Bubble, 2: Selection, 3: Table, 4: Quicksort");
		input = consoleInput.nextLine();
		if (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') {
			System.out.println("Enter 1, 2, 3, 4");
			while (input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') {
				input = consoleInput.nextLine();
			}
		}
		startTime = System.currentTimeMillis();
		if (input.equals("1")) {
			inputArray = bubbleSort(inputArray);
		}
		if (input.equals("2")) {
			inputArray = selectionSort(inputArray);
		}
		if (input.equals("3")) {
			inputArray = tableSort(inputArray);
		}
		if (input.equals("4")) {
			inputArray = quickSort(inputArray);
		}
		long TotalTime = System.currentTimeMillis() - startTime;
		System.out.println("Sort time: " + TotalTime + " milliseconds");
		System.out.println("Please wait while your document is written.");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(new File("output.txt")));
			String output = "";
			for (int i = 0; i < inputArray.length; i++) {
				output += inputArray[i] + ", ";
			}
			output += "\nTotal Time: " + TotalTime + " milliseconds";
			pw.write(output);
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		System.out.println("Your document is written! Thank you for your patience.");
		
		
	}
	//Bubble Sort (swap so right side is larger)
	int[] bubbleSort(int[] array) {
		for (int j = 0; j < array.length; j++) {		
			for (int i = 0; i < array.length -1; i++) { //compare pairs of numbers
				if (array[i] > array[i+1]) {
					//swap
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		return array;
	}
	//Selection Sort (find smallest and move to front)
	int[] selectionSort(int[] array) {
		for (int j = 0; j < array.length; j++) {	
			int smallNum = array[j];
			int smallIndex = j;
			for (int i = j; i < array.length; i++) {
				if (array[i] < smallNum) {
					smallNum = array[i];
					smallIndex = i;
				}
			}
			int temp = array[smallIndex];
			array[smallIndex] = array[j];
			array[j] = temp;
		}
		
		
		return array;
	}
	//Table (tally how many times you see number)
	int[] tableSort(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {//finds biggest number in the list
			if (max <= array[i]) {
				max = array[i]+1;
			}
		}
		int[] tally = new int[max];//uses the max to tally for all of the numbers
		for (int i = 0; i < array.length; i++) {
			tally[array[i]]++;
		}
		
		int count = 0;
		//i keeps track of actual number
		//j keeps track of how many times we've seen that number
		for (int i = 0; i < tally.length; i++) {
			for (int j = 0; j < tally[i]; j++) {
				array[count] = i;
				count++;
			}
		}
		return array;
	}
	//Quicksort... kind of
	int[] quickSort(int[] array) {
		boolean sorted = false;
		int pIndex = 0;
		int y = array.length-1;
		while (sorted == false) {
			if (array[pIndex] == array[y]) {//use the last number in array as partition unless it is already in the correct location
				pIndex = y-1;
				y--;
			}
			else {
				pIndex = y;
			}
			for (int j = 0; j < pIndex; ) {//move partition so that greater numbers are after
				int first = array[j];
				if (first > array[pIndex]) {//if greater do all the switches
					int temp = array[j];
					array[j] = array[pIndex-1];
					array[pIndex-1] = array[pIndex];
					array[pIndex] = temp;
					pIndex = pIndex-1;
				}
				else {//don't switch
					j++;
				}
			}
			int i = 0;
			for (i = 0; i < array.length-1; i++) {
				if (array[i] <= array[i+1] || y == 0) {//if sorted, stop sorting
					sorted = true;
				}
				else {
					sorted = false;
					i = array.length;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		new Sort();
	}

}

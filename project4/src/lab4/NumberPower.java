package lab4;

import java.util.Scanner;

public class NumberPower
{
	public static void main(String[] args)
	{
		// get the input from the user
		Scanner scanner = new Scanner(System.in);
		int first = getNextNum(scanner);
		int second = getNextNum(scanner);
		
		// output the power of the two values
		System.out.println(first + " ^ " + second + " = " + (int)Math.pow(first, second));
	}
	
	private static int getNextNum(Scanner scanner)
	{
		System.out.println("Enter a number: ");
		
		// make sure the user inputs an integer
		while (!scanner.hasNextInt()) {
			System.out.println("--- Please Enter a Valid Integer ---");
			scanner.next();
		}
		
		return scanner.nextInt();
	}
}

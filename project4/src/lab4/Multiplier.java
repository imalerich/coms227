package lab4;

import java.util.Scanner;

public class Multiplier
{
	public static void main(String[] args)
	{
		// take to integer inputs
		Scanner scanner = new Scanner(System.in);
		int first = getNextNum(scanner);
		int second = getNextNum(scanner);
		
		// output the result
		System.out.println(first + " * " + second + " = " + first*second);
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

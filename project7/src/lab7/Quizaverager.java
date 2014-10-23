package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quizaverager 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		int possible = 50;
		
		File file = new File("scores.txt");
		Scanner s = new Scanner(file);
		
		while (s.hasNextLine())
		{
			String line = s.nextLine();
			findAverage(line, possible);
		}
		
		s.close();
	}
	
	public static void findAverage(String Line, int Possible)
	{
		Scanner tmp = new Scanner(Line);
		String first = tmp.next();
		String last = tmp.next();
		
		double total = 0.0;
		while (tmp.hasNextInt())
		{
			total += tmp.nextInt();
		}
		
		double avg = total/Possible;
		System.out.println(first + " " + last + ": " + avg);
	}
}

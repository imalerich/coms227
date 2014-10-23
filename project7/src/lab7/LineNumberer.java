package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//File in = new File("story.txt");
		File in = new File("src/lab7/LineNumberer.java");
		File out = new File(in.getName()+".out");
		
		Scanner s = new Scanner(in);
		PrintWriter output = new PrintWriter(out);
		int linecount = 1;
		
		while (s.hasNextLine())
		{
			String line = s.nextLine();
			System.out.println(linecount + " " + line);
			output.println(linecount + " " + line);
			linecount++;
		}
		
		System.out.println("Done");
		output.close();
		s.close();
	}
}

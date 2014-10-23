package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Input to doc.txt:");
		Scanner in = new Scanner(System.in);
		File out = new File("doc.txt");
		if (out.exists())
		{
			System.out.println("File Already exists! Ok to overwrite (y/n)? ");
			if (!in.nextLine().startsWith("y"))
			{
				return;
			}
		}
		PrintWriter output = new PrintWriter(out);
		
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			output.println(line);
		}
		
		System.out.println("Done");
		output.close();
	}
}

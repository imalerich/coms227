package lab7;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import plotter.PolylinePlotter;

public class InputPlotter 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		PolylinePlotter plotter = new PolylinePlotter();
		
		File f = new File("test.txt");
		//File f = new File("hello.txt");
		Scanner s = new Scanner(f);
		while (s.hasNextLine())
		{
			ProcLine(s.nextLine(), plotter);
		}
		
		s.close();
	}
	
	private static boolean DoPrintLine(String Line)
	{
		if (Line.trim().length() == 0) {
			return false;
		}
		
		if (Line.trim().charAt(0) == '#') {
			return false;
		}
		
		return true;
	}
	
	private static int WordCount(String Line)
	{
		Scanner tmp = new Scanner(Line);
		
		int count = 0;
		while (tmp.hasNext())
		{
			tmp.next();
			count++;
		}
		
		return count;
	}
	
	private static Point GetPoint(Scanner S)
	{
		return new Point( S.nextInt(), S.nextInt() );
	}
	
	private static void ProcLine(String Line, PolylinePlotter Plotter)
	{
		if (!DoPrintLine(Line)) {
			return;
		}
		
		int wordcount = WordCount(Line);
		Scanner tmp = new Scanner(Line);
		int width = 1;
		
		if (wordcount%2 == 0)
		{
			width = tmp.nextInt();
		}
		
		String color = tmp.next();
		Plotter.startLine(color, GetPoint(tmp), width);
		
		while (tmp.hasNext())
		{
			Plotter.addPoint( GetPoint(tmp) );
		}
	}
}

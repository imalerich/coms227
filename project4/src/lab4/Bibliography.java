package lab4;

import java.util.Scanner;

public class Bibliography
{
	public static void main(String[] args)
	{
		// declare the strings to be parsed
		String s1 = "Dijkstra, Edsger#Go To Statement Considered Harmful#Communications of the ACM#1968#11";
		String s2 = "Levoy, Marc#Display of Surfaces from Volume Data#IEEE Computer Graphics and Applications#1988#8";
		String s3 = "Dean, Jeffrey; Ghemawat, Sanjay#MapReduce: Simplified Data Processing on Large Clusters#Communications of the ACM#2008#51";
		
		// construct BibItems from those strings
		BibItem b1 = CreateBib(s1);
		BibItem b2 = CreateBib(s2);
		BibItem b3 = CreateBib(s3);
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
	}
	
	private static BibItem CreateBib(String Data)
	{
		Scanner parse = new Scanner(Data);
		parse.useDelimiter("#");
		
		String name = parse.next();
		String title = parse.next();
		String journal = parse.next();
		int year = parse.nextInt();
		int volume = parse.nextInt();
		parse.close();
		
		return new BibItem(name, title, journal, year, volume);
	}
}

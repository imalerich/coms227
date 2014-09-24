package lab3;

import java.util.Random;

public class Trials
{
	public static void main(String[] args)
	{
		// millionth character in sequence 0, 1, 2, 3, 4, 5, 6, 0, 1, 2...
		System.out.println("Millionth Term");
		System.out.println(999999%6); // 0 based counting, so use 1m-1
		
		// person test
		System.out.println("\nPerson Stats");
		Person p = new Person("Bill", 26);
		System.out.println(p.getAge());
		System.out.println(p.getName());
		// System.out.println(p.getNameLength());
		
		// Integer -> String
		System.out.println("\nInteger to String");
		int x = 42;
		String s = "" + x;
		System.out.println(s);
		
		System.out.println( Integer.parseInt("42") );
		// System.out.println( Integer.parseInt("Hello") );
		// System.out.println( Integer.parseInt("23Skidoo") );
		
		// Max Value
		System.out.println("\nMax Values");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
		System.out.println(Integer.MAX_VALUE+2);
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
		
		// Random
		System.out.println("\nRandom");
		Random rand = new Random(137);
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
	}
}

package lab2;

public class StringTest
{
	public static void main(String[] args)
	{
		//output basic information about a string
		String message = "Hello, World!";
		System.out.println(message);
		
		//output our message in all caps
		System.out.println( message.toUpperCase() );
		System.out.println( message.substring(0, 5) );
		System.out.println( message.replace('o', '*') );
	}
}

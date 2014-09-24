public class FizzBuzz 
{
	public static void main(String[] args)
	{
        // sup dude
		String output = new String();
		for (int i=1; i<=100; i++)
		{
			if (i%15 == 0)
				output += "FizzBuzz\n";
			else if (i%5 == 0)
				output += "Buzz\n";
			else if (i%3 == 0)
				output += "Fizz\n";
			else output += i + "\n"; 
		}
		
		System.out.println(output);
	}
}

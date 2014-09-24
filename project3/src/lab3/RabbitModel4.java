package lab3;

import java.util.Random;

public class RabbitModel4
{
	private int population;
	private Random r;
	
	/**
	 * Construct a new RabbitModel
	 */
	public RabbitModel4()
	{
		population = 2;
		r = new Random(6);
	}

	/**
	 * 	Reset the RabbitModel to it's initial values
	 */
	public void reset()
	{
		population = 2;
		r = new Random(6);
	}
	
	/**
	 * 	Return the current population
	 * @return
	 * 	The Current Population
	 */
	public int getPopulation()
	{
		return population;
	}
	
	/**
	 * 	Simulate the passage of one year
	 */
	public void simulateYear()
	{
		population += r.nextInt(10);
	}
}

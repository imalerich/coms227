package lab3;

public class RabbitModel3
{
	private int population;
	
	/**
	 * Construct a new RabbitModel
	 */
	public RabbitModel3()
	{
		population = 500;
	}

	/**
	 * 	Reset the RabbitModel to it's initial values
	 */
	public void reset()
	{
		population = 500;
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
		population /= 2;
	}
}

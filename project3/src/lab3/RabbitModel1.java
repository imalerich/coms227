package lab3;

public class RabbitModel1
{
	private int population;
	
	/**
	 * Construct a new RabbitModel
	 */
	public RabbitModel1()
	{
		population = 2;
	}

	/**
	 * 	Reset the RabbitModel to it's initial values
	 */
	public void reset()
	{
		population = 2;
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
		population++;
	}
}

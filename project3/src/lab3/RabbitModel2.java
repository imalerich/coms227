package lab3;

public class RabbitModel2
{
	private int population;
	
	/**
	 * Construct a new RabbitModel
	 */
	public RabbitModel2()
	{
		population = 0;
	}

	/**
	 * 	Reset the RabbitModel to it's initial values
	 */
	public void reset()
	{
		population = 0;
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
		population %= 5;
	}
}

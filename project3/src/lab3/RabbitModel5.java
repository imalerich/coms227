package lab3;

public class RabbitModel5
{
	private int population; // current population
	private int prevpop0; // last year
	private int prevpop1; // year before last year
	
	/**
	 * Construct a new RabbitModel
	 */
	public RabbitModel5()
	{
		population = 1;
		prevpop0 = 1;
		prevpop1 = 0;
	}

	/**
	 * 	Reset the RabbitModel to it's initial values
	 */
	public void reset()
	{
		population = 1;
		prevpop0 = 1;
		prevpop1 = 0;
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
		prevpop1 = prevpop0; // year before is now last year
		prevpop0 = population;
		population = prevpop0 + prevpop1;
	}
}

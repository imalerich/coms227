package mini1;

public class AirportTram
{
	public static final int MAX_CAPACITY = 20;
	private int numstops;
	private int currentstop;
	private int currentpassengers;
	private int maxpassengers;
	private int totalpassengers;
	private int totalpassengersPerSegment;
	private int traveledsegments;
	
	/**
	 * Create a new AirportTram
	 * 
	 * @param givenNumberOfStops
	 * 	Total number of stops
	 * 
	 * @param givenInitialStop
	 * 	Which stop to begin the simulation at
	 */
	public AirportTram(int givenNumberOfStops, int givenInitialStop)
	{
		numstops = givenNumberOfStops;
		currentstop = givenInitialStop;
		
		currentpassengers = 0;
		maxpassengers = 0;
		totalpassengers = 0;
		traveledsegments = 0;
		totalpassengersPerSegment = 0;
	}
	
	/**
	 * @return
	 * 	Average Passengers per segment
	 */
	public double getAveragePassengersPerSegment()
	{
		return (double)totalpassengersPerSegment/(double)traveledsegments;
	}
	
	/**
	 * @return
	 * 	Get the current number of passengers aboard this AirportTram
	 */
	public int getCurrentPassengers()
	{
		return currentpassengers;
	}
	
	/**
	 * @return
	 *  Return the current stop of the AirportTram
	 */
	public int getCurrentStop()
	{
		return currentstop;
	}
	
	/**
	 * @return
	 * Return the maximum number of passengers that has ever been on this AirportTram
	 */
	public int getMaxPassengers()
	{
		return maxpassengers;
	}
	
	/**
	 * @return
	 * 	Return the total number of passengers this AirportTram has served
	 */
	public int getTotalPassengersServed()
	{
		return totalpassengers;
	}
	
	/**
	 * 	Reset this AirportTram to initial state
	 * @param givenInitialStop
	 * 	the initial stop to simulate
	 */
	public void restart(int givenInitialStop)
	{
		// set the new initial stop
		currentstop = givenInitialStop;
		
		// reset all fields
		currentpassengers = 0;
		maxpassengers = 0;
		totalpassengers = 0;
		traveledsegments = 0;
		totalpassengersPerSegment = 0;
	}
	
	/**
	 * @param passengersOff
	 * 	How many passengers are getting off at this stop
	 * 
	 * @param passengersAdded
	 * 	How many passengers are getting on at this stop
	 */
	public void runSegment(int passengersOff, int passengersAdded)
	{
		// step the simulation
		passengersOff = Math.min(passengersOff, currentpassengers);
		currentpassengers -= passengersOff;
		passengersAdded = Math.min(passengersAdded, MAX_CAPACITY-currentpassengers);
		currentpassengers += passengersAdded;
		
		// move to the next stop
		currentstop++;
		if (currentstop >= numstops) currentstop = 0;
		
		// calculate the statics
		totalpassengers += passengersAdded;
		totalpassengersPerSegment += currentpassengers;
		maxpassengers = Math.max(currentpassengers, maxpassengers);
		
		// store the total segments traveled
		traveledsegments++;
	}
}

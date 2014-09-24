/*---------------------------------------------------------
 * 		ParkingMeter.java
 * 
 * 			Comp S 227
 * 			Homework #1
 --------------------------------------------------------*/


public class ParkingMeter 
{
	//constant value of coins allowed by the parking meter
	public static final int NICKEL_VALUE = 5;
	public static final int DIME_VALUE = 10;
	public static final int QUARTER_VALUE = 25;
	
	//store the state of this parking meter
	private int TimeRemaining;
	private int CoinCount;
	private int CurrentValue;
	
	//store the value of each coin in minutes
	private int NickelToMin;
	private int DimeToMin;
	private int QuarterToMin;
	
	//maximum values for this parking meter
	private int MaxTime;
	private int MaxCoins;
	
	public ParkingMeter(int givenMinutesForNickel,	int givenMinutesForDime, 
						int givenMinutesForQuarter,	int givenMaxTime,
						int givenMaxCoins)
	{
		//store the input for the specification of the parking meter
		NickelToMin 	= givenMinutesForNickel;
		DimeToMin		= givenMinutesForDime;
		QuarterToMin	= givenMinutesForQuarter;
		
		//store the maximums of this parking meter
		MaxTime		= givenMaxTime;
		MaxCoins	= givenMaxCoins;
	}
	
	/*--------------------------------------------------------
	 * return String's of information about this parking meter
	 -------------------------------------------------------*/
	public String getDollarString()
	{
		return String.format("%01.2f", (float)CurrentValue/100.0f);
	}
	
	public String toString()
	{
		String output = "hw1.ParkingMeter["
						+ "Time "	+ TimeRemaining + "/" + MaxTime		+ ", "
						+ "Coins "	+ CoinCount		+ "/" + MaxCoins	+ ", "
						+ "Value "	+ CurrentValue	+ "]";
		
		return output;
	}
	
	/* -----------------------------------------------------------------
	 * 'getter' methods returning the current state of the parking meter
	 ---------------------------------------------------------------- */
	public int getToalCoins()
	{
		return CoinCount;
	}
	
	public int getCents()
	{
		return CurrentValue;
	}
	
	public int getMinutesRemaining()
	{
		return TimeRemaining;
	}
	
	public boolean isExpired()
	{
		//if there is no time remaining, then this parking meter is expired
		if (TimeRemaining == 0) 
			return true;
		else return false;
	}
	
	/*----------------------------------------------
	 * modify the current state of the parking meter
	 ---------------------------------------------*/
	public void insertNickels(int howMany)
	{
		addCoin(NICKEL_VALUE, NickelToMin, howMany);
	}
	
	public void insertDimes(int howMany)
	{
		addCoin(DIME_VALUE, DimeToMin, howMany);
	}
	
	public void insertQuarters(int howMany)
	{
		addCoin(QUARTER_VALUE, QuarterToMin, howMany);
	}
	
	/*----------------------------------
	 * helper function used to add coins
	 ---------------------------------*/
	private void addCoin(int value, int addTime, int count)
	{
		//do not allow another coin to enter if the max time/coin is already reached
		if (TimeRemaining == MaxTime || CoinCount == MaxCoins) return;
		
		//limit the number of coins entering this parking meter
		if (CoinCount+count > MaxCoins) count = MaxCoins-CoinCount;
		
		//add to the current state of the parking meter
		TimeRemaining	+= addTime*count;
		CurrentValue	+= value*count;
		CoinCount		+= count;;
		
		//do not allow time to surpass the MaxTime
		if (TimeRemaining > MaxTime) TimeRemaining = MaxTime;
	}
	
	public void emptyCoins()
	{
		CoinCount = 0;
	}
	
	public void simulateTime(int minutes)
	{
		TimeRemaining -= minutes;
		if (TimeRemaining < 0) //time cannot be negative
			TimeRemaining = 0;
	}
}

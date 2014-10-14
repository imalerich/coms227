package lab5;

public class Basketball 
{
	private double circumference;
	private boolean isDribbleable;
	
	public Basketball(double givenCircumference)
	{
		circumference = givenCircumference;
		isDribbleable = false;
	}
	
	public boolean isDribbleable()
	{
		return isDribbleable;
	}
	
	public double getCircumference()
	{
		return circumference;
	}
	
	public void inflate()
	{
		isDribbleable = true;
	}
}

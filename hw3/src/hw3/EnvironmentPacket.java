package hw3;

/**
 * Stores a single environment variable usings its name and the value
 * referenced by that name.
 * 
 * @author Ian Malerich
 */
public class EnvironmentPacket 
{
	/**
	 * The name of the variable.
	 */
	private String name;
	
	/**
	 * The value stored by the variable.
	 */
	private int val;
	
	/**
	 * Construct a new environment packet.
	 * @param name
	 * 	The name that this packet uses as reference.
	 * @param Value
	 * 	The value stored by that packet.
	 */
	public EnvironmentPacket(String givenName, int givenValue)
	{
		name = givenName;
		val = givenValue;
	}
	
	/**
	 * Get the name of this element in the environment.
	 * @return
	 * 	The name of this element.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the value of this element in the environment.
	 * @return
	 * 	The value of this element.
	 */
	public int getValue()
	{
		return val;
	}
}

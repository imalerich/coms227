package hw3;

import java.util.ArrayList;
import java.util.Iterator;

import api.IEnvironment;
import api.InterpreterException;

/**
 * Concrete implementation of the IEnvironment interface.
 * @author Ian Malerich
 */
public class Environment implements IEnvironment
{
	/**
	 * List of all elements in this environment.
	 */
	private ArrayList<EnvironmentPacket> elems;
	
	/**
	 * Constructs a new environment.
	 */
	public Environment()
	{
		elems = new ArrayList<EnvironmentPacket>();
	}
	
	@Override
	public int get(String name)
	{
		// look through the array for the element of the given name and return its value
		for (Iterator<EnvironmentPacket> i = elems.iterator(); i.hasNext(); )
		{
			EnvironmentPacket next = i.next();
			
			if (next.getName() == name) {
				return next.getValue();
			}
		}
		
		throw new InterpreterException("Invalid name used - " + name);
	}

	@Override
	public void put(String name, int value)
	{
		// if there was already an element by this name, remove it
		remove(name);
		
		// add the new packet
		elems.add( new EnvironmentPacket(name, value) );
	}

	@Override
	public void remove(String name)
	{
		// search for the given element within the array and remove occurrences of it
		for (Iterator<EnvironmentPacket> i = elems.iterator(); i.hasNext(); ) 
		{
			if (i.next().getName() == name) {
				i.remove();			
			}
		}
	}

}

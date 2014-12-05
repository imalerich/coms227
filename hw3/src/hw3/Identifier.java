package hw3;

import api.IEnvironment;

/**
 * Expression type representing an identifier (variable).
 * An identifier contains a string to be used as a variable name.
 * This element has no subelements.  
 * 
 * @author Ian Malerich
 */
public class Identifier extends ValueExpression
{
	/**
	 * Constructs an identifier using the given string name.
	 * @param givenName
	 *   name for this identifier
	 */
	public Identifier(String givenName)
	{
		super("Id", givenName);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		return env.get(getText());
	}

	@Override
	public int getNumSubElements()
	{
		return 0;
	}

	@Override
	public Object getSubElement(int index)
	{
		return new DefaultElement();
	}

}

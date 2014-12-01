package hw3;

import api.IEnvironment;

/**
 * Expression type representing a literal integer value.
 * This element has no subelements.
 * 
 * @author Ian Malerich
 */
public class Literal extends ValueExpression
{
	/**
	 * Value stored by the literal
	 */
	private int val;
	
	/**
	 * Constructs a literal with the given value.
	 * @param value
	 *   int value for this literal.
	 */
	public Literal(int value)
	{
		super("Int", "" + value);
		val = value;
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		return val;
	}

	@Override
	public int getNumSubElements()
	{
		return 0;
	}

	@Override
	public Object getSubElement(int index)
	{
		return null;
	}

}

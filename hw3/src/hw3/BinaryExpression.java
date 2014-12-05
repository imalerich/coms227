package hw3;

import api.IExpression;

/**
 * Abstract binary expression.  This element has
 * two subelements, the expressions on the left and right sides,
 * in that order.
 * 
 * @author Ian Malerich
 */
public abstract class BinaryExpression extends ProgramElement implements IExpression
{
	/**
	 * An array representing the two sides of the expression.
	 */
	private IExpression elements[];
	
	/**
	 * Constructs a binary expression from the given sub-expressions.  
	 * @param givenName
	 *   a name for the type of element
	 * @param givenText
	 *   a text representation of the operator
	 * @param lhs
	 *   expression on the left side
	 * @param rhs
	 *   expression on the right side
	 */
	protected BinaryExpression(String givenName, String givenText, IExpression lhs, IExpression rhs)
	{
		super(givenName, givenText);
		
		elements = new IExpression[2];
		elements[0] = lhs;
		elements[1] = rhs;
	}

	@Override
	public int getNumSubElements()
	{
		return elements.length;
	}

	@Override
	public Object getSubElement(int index)
	{
		return elements[index];
	}

	/**
	 * Get the IExpression representing the left hand side of the expression.
	 * @return
	 * 	Left hand side of the expression.
	 */
	protected IExpression getLeft()
	{
		return elements[0];
	}
	
	/**
	 * Get the IExpression representing the right hand side of the expression.
	 * @return
	 * 	Right hand side of the expression.
	 */
	protected IExpression getRight()
	{
		return elements[1];
	}
	
	/**
	 * Converts an integer into an equivalent boolean.
	 * @param value
	 * 	The value to be converted.
	 * @return
	 * 	The return boolean.
	 */
	protected boolean getBoolean(int value)
	{
		return value != 0;
	}
	
	/**
	 * Converts a boolean to an equivalent integer value.
	 * @param b
	 * 	The input boolean to be converted.
	 * @return
	 * 	The output integer thats converted.
	 */
	protected int getInt(boolean b)
	{
		if (b) {
			return 1;
		} else {
			return 0;
		}
	}
}

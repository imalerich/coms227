package hw3;

import api.IExpression;

/**
 * Abstract unary expression.  This element has one subelement.
 * 
 * @author Ian Malerich
 */
public abstract class UnaryExpression extends ProgramElement implements IExpression
{
	/**
	 * The unary expression to be evaluated.
	 */
	IExpression expression;
	
	/**
	 * Constructs a unary expression from the given sub-expression.  
	 * @param givenName
	 *   a name for the type of element
	 * @param givenText
	 *   a text representation of the operator
	 * @param expr
	 *   expression to be operated upon
	 */
	protected UnaryExpression(String givenName, String givenText, IExpression expr)
	{
		super(givenName, givenText);
		expression = expr;
	}
	
	/**
	 * Get the expression stored by this unary operator.
	 * @return
	 * 	The expression stored.
	 */
	protected IExpression getExpression()
	{
		return expression;
	}

	@Override
	public Object getSubElement(int index)
	{
		if (index != 0) {
			return new DefaultElement();
		}
		
		return getExpression();
	}
}

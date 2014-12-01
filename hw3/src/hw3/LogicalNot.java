package hw3;

import api.IEnvironment;
import api.IExpression;

/**
 * Logical 'not' expression.  Logical values are represented using 0 
 * for false and 1 for true.  This element has one subelement, the 
 * expression to be negated.
 * 
 * @author Ian Malerich
 */
public class LogicalNot extends UnaryExpression
{

	/**
	 * Constructs a unary expression that represents the logical negation
	 * of the given expression.
	 * @param expr
	 *   the logical expression to be negated
	 */
	public LogicalNot(IExpression expr)
	{
		super("NOT", "!", expr);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		if (getExpression().evaluate(env) == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int getNumSubElements()
	{
		return 1;
	}

	@Override
	public Object getSubElement(int index)
	{
		return getExpression();
	}

}

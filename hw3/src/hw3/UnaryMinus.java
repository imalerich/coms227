package hw3;

import api.IEnvironment;
import api.IExpression;

/**
 * Arithmetic negation expression (unary minus).  This element
 * has one subelement, the expression to be negated.
 * 
 * @author Ian Malerich
 */
public class UnaryMinus extends UnaryExpression
{
	/**
	 * Constructs a new unary expression representing the negative
	 * of the given expression.
	 * @param expr
	 *   arithmetic expression to be negated
	 */
	public UnaryMinus(IExpression expr)
	{
		super("NEGATION", "-", expr);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		return -getExpression().evaluate(env);
	}

	@Override
	public int getNumSubElements()
	{
		return 1;
	}
}

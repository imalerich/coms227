package hw3;

import api.IEnvironment;
import api.IExpression;
import api.LogicalOp;

/**
 * Binary expression with a logical operator.  Logical values are represented 
 * using 0 for false and 1 for true.  This element has
 * two subelements, the expressions on the left and right sides,
 * in that order.
 * 
 * @author Ian Malerich
 */
public class LogicalExpression extends BinaryExpression
{
	/**
	 * Constructs a binary expression from the given sub-expressions.  This constructor
	 * does not check whether the given expressions are logical expressions.
	 * @param op
	 *   the binary operator
	 * @param lhs
	 *   expression on the left side
	 * @param rhs
	 *   expression on the right side
	 */
	public LogicalExpression(LogicalOp op, IExpression lhs, IExpression rhs)
	{
		super(op.toString(), op.getText(), lhs, rhs);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		int left = getLeft().evaluate(env);
		int right = getRight().evaluate(env);
		
		if (getText().equals( LogicalOp.AND.getText() )) {
			return getInt( getBoolean(left) && getBoolean(right) );
		} else if (getText().equals( LogicalOp.OR.getText() )) {
			return getInt( getBoolean(left) || getBoolean(right) );
		} else {
			System.err.println("Error: Invalid operator recieved " + getText() + " return false.");
			return 0;
		}
	}
}

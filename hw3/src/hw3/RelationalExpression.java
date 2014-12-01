package hw3;

import api.IEnvironment;
import api.IExpression;
import api.RelationalOp;

/**
 * Binary expression with an arithmetic operator.  This element has
 * two subelements, the expressions on the left and right sides,
 * in that order.
 * 
 * @author Ian Malerich
 */
public class RelationalExpression extends BinaryExpression
{
	/**
	 * Constructs a binary expression from the given sub-expressions.  This constructor
	 * does not check whether the given expressions are arithmetic expressions.
	 * @param op
	 *   the binary operator
	 * @param lhs
	 *   expression on the left side
	 * @param rhs
	 *   expression on the right side
	 */
	public RelationalExpression(RelationalOp op, IExpression lhs, IExpression rhs)
	{
		super(op.toString(), op.getText(), lhs, rhs);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		int left = getLeft().evaluate(env);
		int right = getRight().evaluate(env);
		
		if (getText().equals( RelationalOp.EQ.getText() )) {
			return getInt(left == right);
			
		} else if (getText().equals( RelationalOp.NEQ.getText() )) {
			return getInt(left != right);
			
		} else if (getText().equals( RelationalOp.LT.getText() )) {
			return getInt(left < right);
			
		} else if (getText().equals( RelationalOp.GT.getText() )) {
			return getInt(left > right);
			
		} else if (getText().equals( RelationalOp.LTE.getText() )) {
			return getInt(left <= right);
			
		} else if (getText().equals( RelationalOp.GTE.getText() )) {
			return getInt(left >= right);
			
		} else {
			System.err.println("Error: Invalid operation recieved " + getText() + " returning false.");
			return 0;
		}
	}
}

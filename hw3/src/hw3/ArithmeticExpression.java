package hw3;

import api.ArithmeticOp;
import api.IEnvironment;
import api.IExpression;

/**
 * Binary expression with an arithmetic operator.  This element has
 * two subelements, the expressions on the left and right sides,
 * in that order.
 * 
 * @author Ian Malerich
 */
public class ArithmeticExpression extends BinaryExpression
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
	public ArithmeticExpression(ArithmeticOp op, IExpression lhs, IExpression rhs)
	{
		super(op.toString(), op.getText(), lhs, rhs);
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		int left = getLeft().evaluate(env);
		int right = getRight().evaluate(env);
		
		if (getText().equals( ArithmeticOp.PLUS.getText() )) {
			return left + right;
		} else if (getText().equals( ArithmeticOp.MINUS.getText() )) {
			return left - right;
		} else if (getText().equals( ArithmeticOp.TIMES.getText() )) {
			return left * right;
		} else if (getText().equals( ArithmeticOp.DIV.getText() )) {
			return left / right;
		} else {
			System.err.println("Error: Invalid operation recieved " + getText() + " returning 0");
			return 0;
		}
	}

}

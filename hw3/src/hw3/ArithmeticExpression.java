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
	 * The arithmetic operation to be performed on the left hand and right hand side.
	 */
	private ArithmeticOp operation;

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
		operation = op;
	}

	@Override
	public int evaluate(IEnvironment env)
	{
		// convert the operation to a char so we can use a switch statement
		char optAsChar = operation.getText().toCharArray()[0];
		int left = getLeft().evaluate(env);
		int right = getRight().evaluate(env);
		
		switch (optAsChar) {
		case '+':
			return left + right;
			
		case '-':
			return left - right;
			
		case '*':
			return left * right;
			
		case '/':
			return left / right;
			
		default:
			System.err.println("Invalid arithmetic option " + optAsChar + " defaulting to 0");
			return 0;
		}
	}

}

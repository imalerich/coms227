package hw3;

import api.IEnvironment;
import api.IExpression;
import api.IStatement;

/**
 * Statement type whose execution causes the value of an expression to
 * be printed to the console.
 * 
 * @author Ian Malerich
 */
public class OutputStatement extends ProgramElement implements IStatement
{
	/**
	 * The expression that will be evaluated and sent as output.
	 */
	private IExpression expression;
	
	/**
	 * Constructs an output statement for the given expression.
	 * @param expr
	 *   given expression
	 */
	public OutputStatement(IExpression expr)
	{
		super("Output", null);
		expression = expr;
	}

	@Override
	public void execute(IEnvironment env)
	{
		System.out.println( expression.evaluate(env) );

	}

	@Override
	public int getNumSubElements()
	{
		return 1;
	}

	@Override
	public Object getSubElement(int index)
	{
		if (index != 0) {
			return new DefaultElement();
		}
		
		return expression;
	}
}

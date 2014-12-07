package hw3;

import api.IEnvironment;
import api.IExpression;
import api.IStatement;


/**
 * Representation of a loop statement that executes a repeated task on elements.
 * 
 * @author Ian Malerich
 *
 */
public class LoopStatement extends ProgramElement implements IStatement
{
	/**
	 * The conditional for the loop.
	 */
	private IExpression condition;
	
	/**
	 * The statement to be expected within the loop.
	 */
	private IStatement statement;
	
	/**
	 * Constructs a loop statement from the given condition and body
	 * @param condition
	 *   expression for the loop condition
	 * @param s
	 *   statement for the loop body
	 */
	public LoopStatement(IExpression condition, IStatement s)
	{
		super("Loop", null);
		
		this.condition = condition;
		statement = s;
	}

	@Override
	public void execute(IEnvironment env)
	{
		while (condition.evaluate(env) == 1) {
			statement.execute(env);
		}
	}

	@Override
	public int getNumSubElements()
	{
		return 0;
	}

	@Override
	public Object getSubElement(int index)
	{
		if (index == 0) {
			return this.condition;
		} else if (index == 1) {
			return statement;
		} else {
			return new DefaultElement();
		}
	}
}

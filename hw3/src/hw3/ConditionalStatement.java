package hw3;

import api.IEnvironment;
import api.IExpression;
import api.IStatement;

/**
 * Statement type representing a conditional.  A conditional has a logical
 * expression and two statements.  If the logical expression is true, the
 * first statement is executed and if the logical expression is false, the
 * second statement is executed.  This element has three subelements, the 
 * condition, the first statement, and the second statement, in that order.
 * 
 * @author Ian Malerich
 */
public class ConditionalStatement extends ProgramElement implements IStatement
{
	/**
	 * The condition to determine which statement to execute.
	 */
	IExpression condition;
	
	/**
	 * The statements that will be executed.
	 */
	IStatement statements[];
	
	/**
	 * Constructs a conditional statement from the given condition
	 * and alternative actions.
	 * @param condition
	 *    an expression to use as the condition
	 * @param s0
	 *    statement to be executed if the condition is true (nonzero)
	 * @param s1
	 *    statement to be executed if the condition is false (zero)
	 */
	public ConditionalStatement(IExpression condition, IStatement s0, IStatement s1)
	{
		super("Conditional", null);
		this.condition = condition;
		
		statements = new IStatement[2];
		statements[0] = s0;
		statements[1] = s1;
	}

	@Override
	public void execute(IEnvironment env)
	{
		if (condition.evaluate(env) == 0) {
			statements[1].execute(env);
		} else {
			statements[0].execute(env);
		}
	}

	@Override
	public int getNumSubElements()
	{
		return statements.length;
	}

	@Override
	public Object getSubElement(int index)
	{
		return statements[index];
	}

}

package hw3;

import api.IEnvironment;
import api.IExpression;
import api.IStatement;

/**
 * Implementation of IStatement that represents an assignment to a 
 * variable in the environment.  Execution of an assignment statement
 * causes the environment to be updated with the new value of the variable.
 * If the variable name is not already in the environment, it is added.
 * 
 * @author Ian Malerich
 */
public class AssignmentStatement extends ProgramElement implements IStatement
{
	/**
	 * The expression to be stored in the identifier.
	 */
	private IExpression expression;
	
	/**
	 * Constructs an assignment statement representing v = e.
	 * @param v
	 *   the identifier
	 * @param e
	 *   the expression to be assigned
	 */
	public AssignmentStatement(Identifier v, IExpression e)
	{
		super("Assign", v.getText());
		expression = e;
	}

	@Override
	public void execute(IEnvironment env)
	{
		// evaluate the expression using the environment, then assign it to the identifier
		env.put(getText(), expression.evaluate(env));

	}

	@Override
	public int getNumSubElements() {
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

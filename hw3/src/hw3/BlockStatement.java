package hw3;

import java.util.ArrayList;
import java.util.Iterator;

import api.IEnvironment;
import api.IStatement;

/**
 * Compound statement representing a sequence of statements.  Execution
 * of a block iterates through the sequence, calling execute() on each
 * one.  The number of subelements is the number of statements in
 * this block (possibly zero).
 * 
 * @author Ian Malerich
 */
public class BlockStatement extends ProgramElement implements IStatement
{
	/**
	 * List of all statements in this block.
	 */
	private ArrayList<IStatement> statements;
	
	/**
	 * Constructs an empty sequence of statements.
	 */
	public BlockStatement()
	{
		super("Block", null);
		statements = new ArrayList<IStatement>();
	}

	/**
	 * Adds a statement to this block.  The statements will be executed
	 * in the order added.
	 * @param s
	 *   statement to be added to this block
	 */
	public void addStatement(IStatement s)
	{
		statements.add(s);
	}

	@Override
	public void execute(IEnvironment env)
	{
		// execute all statements in the order they were added
		for (Iterator<IStatement> i = statements.iterator(); i.hasNext(); )
		{
			i.next().execute(env);
		}
	}

	@Override
	public int getNumSubElements()
	{
		return statements.size();
	}

	@Override
	public Object getSubElement(int index)
	{
		try {
			return statements.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Out of bounds exception caught, returning a DefaultElement instead.");
			return new DefaultElement();
		}
	}

}

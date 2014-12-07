
package mini3;

import java.util.ArrayList;
import java.util.Iterator;

import maze.MazeCell;
import maze.Status;

/**
 * Utility class for searching a maze described by a collection
 * of MazeCell objects.
 * 
 * @author Ian Malerich
 */

public class Searcher
{
	/**
	 * Recursively searches a given MazeCell and all of its unexplored 
	 * neighbors.  Returns true if the current cell is the goal or if
	 * the goal is found in a search initiated from this cell by 
	 * searching a neighbor.  Returns false if the goal is not found.
	 * If the goal is found, then when this method returns, the given
	 * ArrayList will contain a path from the current cell to the goal.
	 * @param current
	 *   the current cell at which a search is being initiated 
	 * @param solution
	 *   an empty array list
	 * @return
	 *   true if the goal was found through this search, false otherwise
	 */
	public static boolean search(MazeCell current, ArrayList<MazeCell> solution)
	{
		// goal found, return true
		if (current.getStatus() == Status.GOAL) {
			solution.add(0, current);
			return true;
		}
		
		// return false if we have already explored this cell
		if (current.getStatus() != Status.UNEXPLORED) {
			return false;
		}
		
		// set this cell as being explored and loop through each adjacent cell
		current.setStatus(Status.EXPLORING);
		Iterator<MazeCell> i = current.getNeighbors().iterator();
		while (i.hasNext()) {
			if (search(i.next(), solution)) {
				current.setStatus(Status.SUCCEEDED);
				solution.add(0, current);
				return true;
			}
		}
		
		// goal not found through this path, return false
		current.setStatus(Status.FAILED);
		return false;
	}

}

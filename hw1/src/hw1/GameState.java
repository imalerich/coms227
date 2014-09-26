package hw1;

/**
 * This class encapsulates the logic and state for a simplified
 * game of American football.  
 * 
 * @author 
 * 	Ian Malerich
 */
public class GameState
{
	/**
	 * Number of points awarded for a touch down.
	 */
	public static final int TOUCHDOWN_POINTS = 6;
  
	/**
	 * Number of points awarded for a successful extra point attempt
	 * after a touch down.
	 */
	public static final int EXTRA_POINTS = 1;
  
	/**
	 * Number of points awarded for a field goal.
	 */
	public static final int FIELD_GOAL_POINTS = 3;
  
	/**
	 * Total length of the field from goal line to goal line, in yards.
	 */
	public static final int FIELD_LENGTH = 100;
  
	/**
	 * Initial position of the offensive team after receiving a kickoff.
	 */
	public static final int STARTING_POSITION = 70;
	
	/**
	 * current down of the game
	 */
	private int currentDown;
	
	/**
	 * current location of the ball
	 */
	private int ballLocation;
	
	/**
	 * current offensive team (0 or 1)
	 */
	private int currentOffense;
	
	/**
	 * score of team 0
	 */
	private int score0;
	
	/**
	 * score of team 1
	 */
	private int score1;
	
	/**
	 * current yards to first down
	 */
	private int yardsToFirstDown;
	
	/**
	 * Construct a new game.
	 */
	public GameState()
	{
		currentDown = 1;
		ballLocation = STARTING_POSITION;
		currentOffense = 0;
		score0 = 0;
		score1 = 0;
		yardsToFirstDown = 10;
	}
	
	/**
	 * Add input score to the current offensive team.
	 * @param points
	 * 	total points scored by offensive team
	 */
	private void addScore(int points)
	{
		if (currentOffense == 0)
		{
			score0 += points;
		} else {
			score1 += points;
		}
	}
	
	/**
	 * Switch the offensive team.
	 * @param position
	 * 	the position away from their goal that the defending team gets the ball
	 */
	private void switchOffensive(int position)
	{
		currentOffense = 1 - currentOffense;
		ballLocation = position;
		currentDown = 1;
		yardsToFirstDown = 10;
		
		// assert that the balls Location is valid
		ballLocation = Math.min(ballLocation, FIELD_LENGTH);
	}
	
	/** * Records the result of an extra point attempt, adding EXTRA_POINTS points if the attempt was successful. 
	 * Whether or not the attempt is successful, the defense gets the ball and starts with a first down, 
	 * STARTING_POSITION yards from the goal line.
	 * @param success
	 *  true if the extra point was successful, false otherwise
	 */
	public void extraPoint(boolean success)
	{
		if (success)
		{
			// the point was successful, award the point
			addScore(EXTRA_POINTS);
		}
		
		// switch the offensive team
		switchOffensive(STARTING_POSITION);
	}
	
	/**
	 * Records the result of a field goal attempt, adding FIELD_GOAL_POINTS points if the field goal was successful.
	 * @param success
	 * 	true if the field goal was successful, false otherwise
	 */
	public void fieldGoal(boolean success)
	{
		if (success)
		{
			// the field goal was successful, award the point
			addScore(FIELD_GOAL_POINTS);
		}
		
		// switch the offensive team
		switchOffensive(FIELD_LENGTH - ballLocation);
	}
	
	/**
	 * Return the current down.
	 * @return
	 * 	The current down.
	 */
	public int getDown()
	{
		return currentDown;
	}
	
	/**
	 * Returns the location of the ball as the number of yards from the defense's goal line.
	 * @return
	 * 	number of yards from the ball to the defense's goal line
	 */
	public int getLocation()
	{
		return ballLocation;
	}
	
	/**
	 * Returns the index for the team currently playing offense.
	 * @return
	 * index of the team playing offense (0 or 1)
	 */
	public int getOffense()
	{
		return currentOffense;
	}
	
	/**
	 * Returns the points for the indicated team.
	 * @param whichTeam
	 * 	whichTeam - team index 0 or 1
	 * @return
	 * 	score for team 0 if the given argument is 0, score for team 1 otherwise
	 */
	public int getScore(int whichTeam)
	{
		if (whichTeam == 1) {
			return score1;
		} else {
			return score0;
		}
	}
	
	/**
	 * Returns the number of yards the offense must advance the ball to get a first down.
	 * @return
	 * 	number of yards to get a first down
	 */
	public int getYardsToFirstDown()
	{
		return yardsToFirstDown;
	}
	
	/**
	 * Records the result of a punt. The defense gets the ball with a first down after it 
	 * has advanced the given number of yards; however, if the ball would have advanced past the defense's 
	 * goal line, the defense starts with the ball at location FIELD_LENGTH (i.e. it can't be behind their 
	 * own goal line). The given number of yards should not be negative.
	 * @param yards
	 * number of yards the ball is advanced by the punt (not less than zero)
	 */
	public void punt(int yards)
	{
		// yards must be greater than 0
		if (yards < 0) return;
		
		// decrement ball location by the distance towards the offensive goal
		ballLocation -= yards;
		
		// switch the current offensive team
		switchOffensive(FIELD_LENGTH - ballLocation);
	}
	
	/**
	 * Records the result of advancing the ball the given number of yards, possibly resulting in a first down, a 
	 * touch down, or a turnover.
	 * 
	 * 	+ If the resulting location of the ball is less than zero, then a touch down is awarded and the offense gets TOUCHDOWN_POINTS points added. 
	 *		 	(However, after a touch down, the defending team does not get the ball and begin a first down until 
	 *			extraPoint is called.)
	 * 	+ If the ball has been advanced 10 or more yards since the first down, the offense keeps the ball and gets a first down.
	 * 	+ If it is the fourth down, there is no touch down, and the ball has not been advanced 10 yards or more, then the defense takes 
	 * 			possession at the ball's current location.
	 * 	+ Otherwise, the offense stays in control and the down increases by 1. 
	 * 
	 * The number of yards the ball is advanced may be negative. However, the location does not ever go over FIELD_LENGTH yards.
	 * param @yard
	 * number of yards (possibly negative) the ball is advanced
	 */
	public void runOrPass(int yards)
	{
		// move the ball yards and apply that distance towards the distance to the first yard line
		ballLocation -= yards;
		yardsToFirstDown -= yards;
		
		// assert that the ball has not moved beyond the goal line
		if (ballLocation > FIELD_LENGTH)
		{
			yardsToFirstDown -= (ballLocation - FIELD_LENGTH);
			ballLocation = FIELD_LENGTH;
		}
		
		// check if a touch down occurs
		if (ballLocation < 0)
		{
			// add the score for the appropriate team
			addScore(TOUCHDOWN_POINTS);
		}
		
		// check if a first down occurs
		if (yardsToFirstDown <= 0)
		{
			yardsToFirstDown = 10;
			currentDown = 1;
		}
		
		// check if the 4th down just occurred (and failed)
		if (currentDown == 4)
		{
			// swap the orientation of the ball location as the defending team takes possession
			switchOffensive(FIELD_LENGTH - ballLocation);
		}
		
		// increment the current down
		currentDown++;
	}
}
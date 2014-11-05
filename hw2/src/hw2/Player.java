package hw2;

/**
 * This class encapsulates information about a player for
 * a game in which money is won in multiple rounds.  A player 
 * has a <em>round balance</em>, which represent potential
 * winnings for the current round, and a <em>game balance</em>,
 * which is the total winnings for all rounds.  When a player
 * wins a round, the round balance is transferred to the 
 * game balance.  When a player loses in a round, the round
 * balance is set to zero but the game balance is kept.
 * 
 * @author Ian Malerich
 */
public class Player
{
	/**
	 * The current winnings of this player for this round.
	 */
	private int roundBalance;
	
	/**
	 * The current winnings of this player for the game.
	 */
	private int gameBalance;
	
	/**
	 * The players name.
	 */
	private String name;

	/**
	 * Constructs a player with the given name and zero winnings.
	 * @param givenName
	 *   the player's name
	 */
	public Player(String givenName)
	{
		// set the players name and their winnings to zero
		name = givenName;
		roundBalance = 0;
		gameBalance = 0;
	}

	/**
	 * Returns the player's round balance (potential winnings for the 
	 * current round).
	 * @return
	 *   the player's balance for the current round
	 */
	public int getRoundBalance()
	{
		return roundBalance;
	}

	/**
	 * Increases the player's round balance by the given amount.  
	 * This method does not check whether the amount to add is positive.
	 * @param toAdd
	 *   amount to add to round balance
	 */
	public void addToRoundBalance(int toAdd)
	{
		// add the balance to the round balance
		roundBalance += toAdd;
	}

	/**
	 * Decreases the player's round balance by the given amount.  
	 * This method does not check whether the balance becomes negative.
	 * @param toSubtract
	 *   amount to subtract from round balance
	 */
	public void subtractFromRoundBalance(int toSubtract)
	{
		// remove from the round balance
		roundBalance -= toSubtract;
	}

	/**
	 * Resets the player's round balance to zero.
	 */
	public void clearRoundBalance()
	{
		// reset the round balance
		roundBalance = 0;
	}

	/**
	 * Returns the player's game balance
	 * (not including potential winnings from the current round).
	 * @return
	 *   players game balance
	 */
	public int getGameBalance()
	{
		return gameBalance;
	}

	/**
	 * Adds the player's round balance to the game balance (without modifying the round balance).
	 */
	public void winRound()
	{
		// add the round balance to the game balance
		gameBalance += roundBalance;
	}

	/**
	 * Returns the player's name.
	 * @return
	 *   player's name
	 */
	public String getName()
	{
		return name;
	}
}

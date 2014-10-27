package lab08;
import java.util.Random;

import lab08.Card.Suit;

/**
 * Class representing a standard 52-card deck of playing
 * cards from which cards can be selected at random.
 */
public class Deck
{
	/**
	 * The size of the deck.
	 */
	private int deckSize = 52;

	/**
	 * The cards comprising this deck.
	 */
	private Card[] cards;

	/**
	 * The random number generator to use for selecting cards.
	 */
	private Random rand;

	/**
	 * Constructs a new deck with a default random number generator.
	 */
	public Deck()
	{
		rand = new Random();
		init();
	}

	/**
	 * Constructs a new deck with the given random number generator.
	 */
	public Deck(Random givenGenerator)
	{
		rand = givenGenerator;
		init();
	}

	private void swap(int First, int Second)
	{
		// temporarily store the second card to be swapped
		Card tmp = cards[Second];

		// swap the position of the two cards
		cards[Second] = cards[First];
		cards[First] = tmp;
	}

	/**
	 * Returns a new array containing k elements selected
	 * at random from this deck.
	 */
	public Card[] select(int k)
	{
		Card[] hand = new Card[k];

		for (int i=0; i<k; i++) {
			// select a card from the index of 0 to the end of the deck
			int pick = rand.nextInt(deckSize-i);
			hand[i] = cards[pick];

			// pull the selected card to the back of the deck
			swap(pick, deckSize-1-i);
		}
		
		deckSize -= k;
		return hand;
	}

	/**
	 * Initializes a new deck of 52 cards.
	 */
	private void init()
	{
		cards = new Card[52];
		int index = 0;
		for (int rank = 1; rank <= 13; ++rank)
		{
			cards[index] = new Card(rank, Suit.CLUBS);
			index += 1;
			cards[index] = new Card(rank, Suit.DIAMONDS);
			index += 1;
			cards[index] = new Card(rank, Suit.HEARTS);
			index += 1;
			cards[index] = new Card(rank, Suit.SPADES);
			index += 1;
		}

	}
}

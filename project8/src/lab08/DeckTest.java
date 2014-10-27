package lab08;

import java.util.Random;

public class DeckTest 
{
	public static void main(String[] args) 
	{
		int handSize = 50;
		Random r = new Random(40);
		Deck d = new Deck(r);
		Card[] hand = d.select(handSize);
		
		for (int i=0; i<handSize; i++) {
			System.out.println(hand[i].toString());
		}
	}
}

package hw1;

public class GameTest
{
	public static void main(String[] args)
	{
		GameState game = new GameState();
		
		game.runOrPass(5);
		System.out.println(game.getLocation());
		System.out.println("Expected - " + 65);
		game.fieldGoal(false);
		System.out.println(game.getLocation());
		System.out.println("Expected - " + 35);
		System.out.println(game.getOffense());
		System.out.println("Expected - " + 1);
	}
}

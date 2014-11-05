package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WheelTest {
	GameWheel gw;
	
	@Before
	public void setUp()
	{
		gw = new GameWheel();
	}
	
	@Test
	public void testPositive() {
		GameWheel game=new GameWheel();
		game.spin(30);
		assertEquals(900,game.getSegmentValue());
	}

	@Test
	public void testNegative() {
		GameWheel game=new GameWheel();
		game.spin(-30);
		assertEquals(300,game.getSegmentValue());
	}

	@Test
	public void testMultiSpinsPos() {
		GameWheel game=new GameWheel();
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		game.spin(30);
		assertEquals(450,game.getSegmentValue());
	}
	@Test
	public void testMultiSpinsNeg() {
		GameWheel game=new GameWheel();
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		game.spin(-30);
		assertEquals(5000,game.getSegmentValue());
	}
	
	@Test
	public void testWheelAt361()
	{
		GameWheel w = new GameWheel();
		w.spin(361);
		assertEquals(359, w.getRotation());
	}    
	
	@Test
	public void testSpinInclusive() {
		gw.spin(10);
		assertEquals(9, gw.getRotation());
	}
	
	@Test
	public void testSpinOver() {
		gw.spin(360);
		assertEquals(359, gw.getRotation());
	}
	
	@Test
	public void testSpinNegIncl() {
		gw.spin(-350);
		assertEquals(9, gw.getRotation());
	}
	
	@Test
	public void testSpinNegOver() {
		gw.spin(-362);
		assertEquals(357, gw.getRotation());
	}
	
	@Test
	public void testSpinMultipleFifteen() {
		gw.spin(1);
		assertEquals(359, gw.getRotation());
	}
	
	@Test
	public void testSpinMultipleOver() {
		gw.spin(361);
		assertEquals(359, gw.getRotation());
	}
	
	@Test
	public void testSpinNegMultiple() {
		gw.spin(-374);
		assertEquals(344, gw.getRotation());
	}
	
	@Test
	public void testSpinZero() {
		gw.spin(0);
		assertEquals(359, gw.getRotation());
	}
	
	@Test
	public void testSpinAddToZero() {
		gw.spin(-359);
		assertEquals(359, gw.getRotation());
	}
	
	@Test
	public void testGetSegValueInit() {
		assertEquals(5000, gw.getSegmentValue());
	}
	
	@Test
	public void testGetSegValueBankrupt() {
		gw.spin(194);
		assertEquals(-1, gw.getSegmentValue());
	}
}

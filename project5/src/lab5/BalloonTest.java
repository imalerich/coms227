package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import balloon.Balloon;

public class BalloonTest 
{
	Balloon b;
	
	@Before
	public void setup()
	{
		b = new Balloon(100);
	}
	
	@Test
	public void testInitial()
	{
		String msg = "Initial Radius should be 0";
		assertEquals(msg, b.getRadius(), 0);
		
		msg = "Should not be popped";
		assertEquals(msg, b.isPopped(), false);
	}
	
	@Test
	public void testBlowFull()
	{
		b.blow(100);
		String msg = "Should only pop when blown over maximum radius";
		assertEquals(msg, false, b.isPopped());
		
		msg = "After blow to max radius, Radius should be 100";
		assertEquals(msg, 100, b.getRadius());
	}
	
	@Test
	public void testBlow()
	{
		b.blow(20);
		String msg = "Blow to 20, Radius should be 20";
		assertEquals(msg, 20, b.getRadius());
		
		msg = "Should not be popped after a single blow below max radius";
		assertEquals(msg, false, b.isPopped());
		
		b.blow(30);
		msg = "Blow to 20, then 30, radius should be 50";
		assertEquals(msg, 50, b.getRadius());
		
		b.blow(51);
		msg = "Blow beyond the max radius, balloon should now be popped";
		assertEquals(msg, true, b.isPopped());
		
		msg = "Blow beyond the max radius, balloon is popped, Radius should be 0";
		assertEquals(msg, 0, b.getRadius());
		
		b.blow(20);
		msg = "Balloon is popped, blow should not increase radius, Radius should be 0";
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test
	public void testDeflate()
	{
		b.blow(20);
		String msg = "After blow 20, Radius should be 20";
		assertEquals(msg, 20, b.getRadius());
		
		b.deflate();
		msg = "After deflate, Radius should be 0";
		assertEquals(msg, 0, b.getRadius());
		
		msg = "After deflate, balloon should not be popped";
		assertEquals(msg, false, b.isPopped());
		
		b.blow(30);
		msg = "After deflate to 0, and blow to 30, Radius should be 30";
		assertEquals(msg, 30, b.getRadius());
	}
	
	@Test
	public void testPop()
	{
		b.blow(30);
		String msg = "After Blow 30, Radius should be 30";
		assertEquals(msg, 30, b.getRadius());
		
		b.pop();
		msg = "Balloon has been popped, Radius should be 0";
		assertEquals(msg, 0, b.getRadius());
		
		msg = "Balloon should now be popped";
		assertEquals(msg, true, b.isPopped());
		
		b.blow(30);
		msg = "Balloon is popped, therefore, blow should not increase radius";
		assertEquals(msg, 0, b.getRadius());
	}
}

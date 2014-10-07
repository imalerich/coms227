package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketballTest 
{
	// margin of error 
	private static final double EPSILON = 10e-07;
	private Basketball b;
	
	@Before
	public void setup() // will run before every test case
	{
		b = new Basketball(5);
	}
	
	@Test
	public void testInitial()
	{
		assertEquals(false, b.isDribbleable());
	}
	
	@Test
	public void testInitialDiameter()
	{
		assertEquals(5.0, b.getCircumference(), EPSILON);
	}
	
	@Test
	public void testInflate()
	{
		b.inflate();
		
		assertEquals(true, b.isDribbleable());
	}
	
	@Test
	public void testDiameterAfterInflation()
	{
		b.inflate();
		
		assertEquals(5.0, b.getCircumference(), EPSILON);
	}
}

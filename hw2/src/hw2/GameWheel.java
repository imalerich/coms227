package hw2;

/**
 * This class encapsulates information about the state of the wheel
 * for a wheel of fortune game. The state of the wheel is represented
 * by its counterclockwise rotation in degrees.  The wheel represented
 * by this class has 24 segments each covering 15 degrees of rotation.
 * The value associated with each segment is fixed and is given by an internal
 * array of values (WHEEL_SEGMENTS). The rotation is always between
 * 1 and 359, with exact multiples of 15 degrees disallowed.
 * 
 * @author Ian Malerich
 */
public class GameWheel
{
	/**
	 * Constant representing the "bankrupt" wheel segment.
	 */
	public static final int BANKRUPT = -1;

	/**
	 * Constant representing the "free play" wheel segment.
	 */
	public static final int FREE_PLAY = 0;

	/**
	 * Constant representing the "lose a turn" wheel segment.
	 */
	public static final int LOSE_A_TURN = 1;

	/**
	 * Numeric values for the wheel segments.
	 */
	private static final int[] SEGMENT_VALUES = 
		{
		500, // 0 through 14 degrees
		900, // 15 through 29 degrees
		700,
		300,
		800,
		550,
		400,
		500,
		600,
		350,
		500,
		900,
		BANKRUPT,
		650,
		FREE_PLAY,
		700,
		LOSE_A_TURN,
		800,
		500,
		450,
		500,
		300,
		BANKRUPT,
		5000  // 345 through 359 degrees
		};
	
	/**
	 * the angle of an individual segment
	 */
	private static final int SEGMENT_ANGLE = 15;
	
	/**
	 * The current angle of the wheel in degrees;
	 */
	private int currentAngle;
	
	/**
	 * Constructs a new game wheel with an initial rotation of 359 degrees.
	 */
	public GameWheel()
	{
		currentAngle = 359;
	}

	/**
	 * Adds the given number of degrees to the wheel's position.  
	 * If adding the given number would cause the rotation to be
	 * an exact multiple of 15, then 1 is subtracted.  The result
	 * is wrapped so that the end result is between 1 and 359 (inclusive).
	 * (Note that the argument may be negative.)
	 * @param degrees
	 *   number of degrees to spin the wheel
	 */
	public void spin(int degrees)
	{
		// spin the wheel
		currentAngle += degrees;
		
		// if exact multiple of 15, subtract 1
		if (currentAngle % SEGMENT_ANGLE == 0) {
			currentAngle--;
		}
		
		// wrap from 1 to 359 (will not be 0, as previous statement would set to -1)
		currentAngle %= 360;
	}

	/**
	 * Returns the current rotation of the wheel.
	 * @return
	 *   current rotation of the wheel
	 */
	public int getRotation()
	{
		return currentAngle;
	}

	/**
	 * Returns the value for the segment at the wheel's current rotation.
	 * @return
	 *   segment value for current rotation
	 */
	public int getSegmentValue()
	{
		// the index is the integer value of the current angle over SEGMENT_ANGLE (rounded down)
		return SEGMENT_VALUES[currentAngle/SEGMENT_ANGLE];
	}
}

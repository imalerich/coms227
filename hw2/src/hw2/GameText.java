package hw2;
/**
 * Class representing some hidden text for a letter-guessing game.
 * The <em>displayed text</em> is a character array in which all
 * alphabetic characters are initially replaced by the '*' character.
 * (Spaces and punctuation, if any, are always shown normally.
 * A character ch is considered alphabetic if 
 * <code>Character.isAlphabetic(ch)</code> returns true.)
 * Whenever the update() method is called with a letter that 
 * actually occurs in the hidden text, that character replaces
 * the '*' character in the hidden text.  All methods are 
 * case-insensitive and internally, all text and characters are converted to 
 * upper-case.
 * 
 * @author Ian Malerich
 */
public class GameText
{  
	/**
	 * The hidden phrase, not displayed to the end user.
	 */
	private String hiddenText;
	
	/**
	 * The displayed phrase, with '*' covering non visible characters.
	 */
	private char[] displayedText;

	/**
	 * Constructs a GameText using the given string as the hidden text.
	 * The hidden text is assumed NOT to contain the character '*'.
	 * Internally the text is converted to upper case.
	 * @param phrase
	 *   the given hidden text
	 */
	public GameText(String phrase)
	{
		// store the hidden phrase
		hiddenText = phrase.toUpperCase();
		
		// create a character array for the displayed text
		displayedText = new char[hiddenText.length()];
		
		// construct the displayed text array
		for (int i=0; i<displayedText.length; i++) {
			// if the this character in hiddenText is alphabetic, set the displayed to '*'
			if (Character.isAlphabetic(hiddenText.charAt(i))) {
				displayedText[i] = '*';
			} else {
				// else set the displayed non-alphabetic character
				displayedText[i] = hiddenText.charAt(i);
			}
		}
	}

	/**
	 * Returns the actual hidden text stored in this object.
	 * @return
	 *   the hidden text
	 */
	public String getHiddenText()
	{
		return hiddenText;
	} 

	/**
	 * Returns the displayed form of the hidden text, in which only
	 * the letters that have been identified by the update() method
	 * are revealed.
	 * @return
	 *   displayed form of the hidden text
	 */
	public char[] getDisplayedText()
	{
		return displayedText;
	}

	/**
	 * Returns the number of alphabetic character positions that are 
	 * currently not displayed (occupied by '*' characters).
	 * @return
	 *   number of characters positions not yet identified 
	 */
	public int countHiddenLetters()
	{
		int count = 0;
		for (int i=0; i<displayedText.length; i++) {
			// count each occurrence of the '*' character
			if (displayedText[i] == '*') {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * Returns the number of consonant positions that are 
	 * currently not displayed (are occupied by '*' characters).
	 * A consonant is defined as an alphabetic character other than
	 * a vowel (A, E, I, O, or U). 
	 * @return
	 *   number of consonant positions not yet identified 
	 */
	public int countHiddenConsonants()
	{
		int count = 0;
		for (int i=0; i<displayedText.length; i++) {
			// count each hidden character that is not a vowel in the hiddenText
			if (displayedText[i] == '*' && !isVowel(hiddenText.charAt(i))) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * Returns the number of times the given character occurs in the
	 * hidden text. Does not modify the displayed text.  This method
	 * is not case sensitive.
	 * @param ch
	 *   the character to check
	 * @return
	 *   number of occurrences of the given character in the hidden text
	 */
	public int letterCount(char ch)
	{
		int count = 0;
		for (int i=0; i<hiddenText.length(); i++) {
			// if the character exists in hiddenText, increment the count
			if (hiddenText.charAt(i) == Character.toUpperCase(ch)) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * Updates the displayed text to reveal all occurrences of
	 * the given character in the hidden text, if any.  Has no effect
	 * if the character does not occur in the hidden text.
	 * The given character is converted to upper case.
	 * @param ch
	 *   the character to be revealed
	 */
	public void update(char ch)
	{
		for (int i=0; i<hiddenText.length(); i++) {
			// if the the character exists in hiddenText
			if (hiddenText.charAt(i) == Character.toUpperCase(ch)) {
				// set that character as visible
				displayedText[i] = Character.toUpperCase(ch);
			}
		}
	}

	/**
	 * Updates the displayed text to reveal all hidden letters.
	 */
	public void updateAllRemaining()
	{
		displayedText = hiddenText.toCharArray();
	}

	/**
	 * Determines whether the given character is a vowel
	 * (A, E, I, O, or U).
	 * @param ch
	 *   given character
	 * @return
	 *   true if the character is a vowel, false otherwise
	 */
	private boolean isVowel(char ch)
	{
		return "aeiouAEIOU".indexOf(ch) >= 0;
	}
}

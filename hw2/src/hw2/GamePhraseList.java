package hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class encapsulates a list of strings representing phrases or words for use in 
 * a letter-guessing game. The list is initialized from a file.
 * 
 * @author Ian Malerich
 */
public class GamePhraseList
{

	/**
	 * Constructs a GamePhraseList that will select phrases from the given file.
	 * @param givenFilename
	 *   the name of the file
	 * @throws FileNotFoundException
	 *   if the named file cannot be opened or read
	 */
	public GamePhraseList(String givenFilename) throws FileNotFoundException
	{
		// TODO
	}

	/**
	 * Returns the nth phrase from the file, where the first line of the file
	 * is numbered zero.  Caller must ensure that n is greater than or equal to
	 * zero and smaller than the number of phrases.
	 * @param n
	 *   number indicating which phrase from the file is to be returned
	 * @return 
	 *    the nth phrase
	 */
	public String getPhrase(int n)
	{
		// TODO
		return null;
	}

	/**
	 * Returns the number of strings in this phrase list.
	 * @return
	 *   number of strings in this list
	 */
	public int getSize()
	{
		// TODO
		return 0;
	}

}

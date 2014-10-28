package hw2;

import java.io.File;
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
	 * Store the phrases from the file into a dynamic array.
	 */
	private ArrayList<String> phrases = new ArrayList<String>();

	/**
	 * Constructs a GamePhraseList that will select phrases from the given file.
	 * @param givenFilename
	 *   the name of the file
	 * @throws FileNotFoundException
	 *   if the named file cannot be opened or read
	 */
	public GamePhraseList(String givenFilename) throws FileNotFoundException
	{
		File f = new File(givenFilename);
		Scanner s = new Scanner(f);
		
		// read each phrase into the dynamic array
		while (s.hasNextLine()) {
			phrases.add( s.nextLine() );
		}
		
		s.close();
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
		return phrases.get(n);
	}

	/**
	 * Returns the number of strings in this phrase list.
	 * @return
	 *   number of strings in this list
	 */
	public int getSize()
	{
		return phrases.size();
	}

}

package mini2;

import java.util.Random;
import java.util.Scanner;

public class LoopyStuff 
{
	/**
	 * Determines whether all the characters of target can be found as a substring of source
	 * @param Target
	 * The string to search for
	 * @param Source
	 * The string to search within
	 * @return
	 * Whether or not Source contains a subset Target
	 */
	public static boolean containsSubsequence(String Target, String Source)
	{
		// return true if the source has no length
		if (Source.length() == 0) {
			return true;
		}
		
		int index = 0;
		for (int i=0; i<Target.length(); i++)
		{
			// found the letter at Source[index] at Target[i]
			if (Target.charAt(i) == Source.charAt(index)) {
				index++;
			}
			
			// all the letters were found in sequential order
			if (index == Source.length()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determines whether s and t differ by exactly one pair of distinct adjacent characters reversed
	 * @param S
	 * first input string
	 * @param T
	 * second input string
	 * @return
	 * whether or not s and t differ by one distinct pair of adjacent characters reversed
	 */
	public static boolean differByOneSwap(String S, String T)
	{
		// if the strings are equal, or do not have the same length, return false
		if (S.equals(T) || S.length() != S.length()) {
			return false;
		}
		
		// store the indices of up to two differences in the strings
		int diff0 = -1;
		int diff1 = -1;
		
		for (int i=0; i<S.length(); i++)
		{
			// skip if this is not a difference between characters
			if (S.charAt(i) == T.charAt(i))
				continue;
			
			if (diff0 < 0) {
				// set the index of the first difference
				diff0 = i;
			} else if (diff1 < 0) {
				// set the index of the second difference
				diff1 = i;
			} else {
				// more then 2 differences were found, return false
				return false;
			}
		}
		
		if (S.charAt(diff0) == T.charAt(diff1) &&
				S.charAt(diff1) == T.charAt(diff0))
			return true;
		
		return false;
	}
	
	/**
	 * Returns the index of the nth occurrence of the given string, or -1 if the character does not occur n or 
	 * more times
	 * @param S
	 * @param Ch
	 * @param N
	 * @return
	 */
	public static int findNth(String S, char Ch, int N)
	{
		int found = 0;
		for (int i=0; i<S.length(); i++)
		{
			if (S.charAt(i) == Ch) {
				found++;
			}
			
			if (found == N) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the second largest number in a string of integers
	 * @param nums
	 * String of integers
	 * @return
	 * the second largest integer in the input string 
	 */
	public static int findSecondLargest(String Nums)
	{
		int max = 0;
		int nxtMax = 0;
		
		Scanner s = new Scanner(Nums);
		while (s.hasNextInt()) 
		{
			int val = s.nextInt();
			if (val > max) {
				nxtMax = max;
				max = val;
			} else if (val > nxtMax) {
				nxtMax = val;
			}
		}
		
		s.close();
		return nxtMax;
	}
	
	/**
	 * Determine whether or not the input string is palindrome
	 * @param S
	 * whether or not the input string is a palindrome
	 * @return
	 */
	public static boolean isPalindrome(String S)
	{
		// empty string IS a palindrome
		if (S.length() == 0) {
			return true;
		}
		
		// loop through each character and compare it to its inverse
		boolean isPalindrome = true;
		for (int i=0; i<S.length(); i++)
		{
			if (S.charAt(i) != S.charAt( S.length()-i-1) ) {
				isPalindrome = false;
			}
		}
		
		return isPalindrome;
	}
	
	/**
	 * print a row of dashes and spaces
	 * @param Spaces
	 * number of spaces
	 * @param Dashes
	 * number of dashes
	 */
	private static void printData(int Spaces, int Dashes)
	{
		for (int i=0; i<Spaces/2; i++) {
			System.out.print(' ');
		}

		System.out.print('*');
		for (int i=0; i<Dashes; i++) {
			System.out.print('-');
		}
		System.out.print('*');

		for (int i=0; i<Spaces/2; i++) {
			System.out.print(' ');
		}

		// new line
		System.out.println();
	}
	
	/**
	 * prints a pattern of 2n rows containing dashes and stars
	 * @param n
	 */
	public static void printStars(int n)
	{
		// for each row (ascending)
		for (int r=0; r<n; r++)
		{
			int dashes = (2*r);
			int spaces = (2*n) - (dashes+2);
			printData(spaces, dashes);
		}
		
		// for each row (descending)
		for (int r=n-1; r>=0; r--)
		{
			int dashes = (2*r);
			int spaces = (2*n) - (dashes+2);
			printData(spaces, dashes);
		}
	}
	
	/**
	 * Determines the number of random integers that must be generated using a given random in order
	 * to get two consecutive numbers that are the same
	 * @param R
	 * Input random stream
	 * @param Max
	 * upper bound of numbers to be generated
	 * @return
	 */
	public static int randomExperiment(Random R, int Max)
	{
		int prev = R.nextInt(Max);
		int calls = 1;
		
		while (true)
		{
			int i = R.nextInt(Max);
			calls++;
			
			if (prev == i) {
				return calls;
			}
			
			prev = i;
		}
	}
}

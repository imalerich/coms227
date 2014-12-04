package lab11;

import java.io.File;
import java.util.ArrayList;

public class Recursion 
{
	public static void main(String[] args) 
	{
		System.out.println("-----------------------------------------");
		System.out.println("2^8:\t" + power(2, 8) + "\t--- expected 256");
		System.out.println("16^4:\t" + power(16, 4) + "\t--- expected 65,536");
		
		System.out.println("-----------------------------------------");
		System.out.println("3 rows: " + getPyramidCount(3));
		System.out.println("7 rows: " + getPyramidCount(7));
		
		System.out.println("-----------------------------------------");
		int[] arr0 = {4, 1, 2, 3, 4, 12, 4, 23, 88, 16};
		System.out.println(getMaximum(arr0));
		int[] arr1 = {4, 1, 2, 3, 4, 12, 4, 23, 88, 16, 99};
		System.out.println(getMaximum(arr1));
		int[] arr2 = {124, 4, 1, 2, 3, 4, 12, 4, 23, 88, 16, 99};
		System.out.println(getMaximum(arr2));
		
		System.out.println("-----------------------------------------");
		System.out.println(getDirectorySize(new File("src/lab11/")));
		
		System.out.println("-----------------------------------------");
		ArrayList<String> names = getJavaFiles(new File("../"));
		System.out.println(names.toString());
		
		System.out.println("-----------------------------------------");
		names = getJavaFiles(new File("src/lab11/"));
		System.out.println(names.toString());
		System.out.println("-----------------------------------------");
	}
	
	public static int power(int x, int p)
	{
		if (p == 1) {
			return x;
		}
		
		return power(x, p-1)*x;
	}
	
	public static int getPyramidCount(int n)
	{
		if (n == 1) {
			return 1;
		}
		
		return power(n, 2) + getPyramidCount(n-1);
	}
	
	public static int getMaximum(int[] arr)
	{
		return getMaximum(arr, 0, arr.length-1);
	}
	
	public static int getMaximum(int[] arr, int start, int end)
	{
		if (start == end) {
			return arr[start];
		}
		
		int width = (end-start);
		int leftmax	 = getMaximum(arr, start, end-width/2-1);
		int rightmax = getMaximum(arr, end-width/2, end);
		
		if (leftmax > rightmax) {
			return leftmax;
		} else {
			return rightmax;
		}
	}
	
	public static long getDirectorySize(File d)
	{
		File[] D = {d};
		return getDirectorySize(D, 0);
	}
	
	public static long getDirectorySize(File[] d, int index)
	{
		if (index == d.length) {
			return 0;
		}
		
		if (d[index].isFile()) {
			// d[index] is a file
			return d[index].length() + getDirectorySize(d, index+1);
		} else {
			// d[index] is a directory
			return getDirectorySize(d[index].listFiles(), 0) + getDirectorySize(d, index+1);
		}
	}
	
	public static ArrayList<String> getJavaFiles(File d)
	{
		ArrayList<String> names = new ArrayList<String>();
		
		File[] D = {d};
		getJavaFiles(D, names, 0);
		return names;
	}
	
	public static void getJavaFiles(File[] d, ArrayList<String> names, int index)
	{
		if (index == d.length) {
			return;
		}
		
		if (d[index].isFile()) {
			// d[index] is a file
			if (d[index].getName().endsWith(".java")) {
				names.add(d[index].getName());
			}
			
		} else {
			//d[index] is a directory
			getJavaFiles(d[index].listFiles(), names, 0);
		}
		
		// next file in directory
		getJavaFiles(d, names, index+1);
	}
}

package lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MileageTest 
{
	private static ArrayList<FillUp> data = new ArrayList<FillUp>();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		procData();
		outputMileage();
	}
	
	private static void procData() throws FileNotFoundException
	{
		File f = new File("mileage.txt");
		Scanner scanner = new Scanner(f);
		
		while (scanner.hasNext()) {
			data.add( new FillUp(scanner.nextInt(), scanner.nextDouble()) );
		}
		
		scanner.close();
	}
	
	private static void outputMileage()
	{
		for (int i=1; i<data.size(); ++i) {
			int milesDriven = data.get(i).getOdometer() - data.get(i-1).getOdometer();
			double gallonsConsumed = data.get(i).getGallons();
			
			System.out.println( "Mileage " + i + ": " + (milesDriven/gallonsConsumed) );
		}
	}
}

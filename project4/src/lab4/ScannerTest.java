package lab4;

import java.util.Scanner;
import lab2.Atom;

public class ScannerTest
{
	public static void main(String[] args)
	{
		String text = "Uranium U 92 92 146";
		Scanner parser = new Scanner(text);
		String name = parser.next();
		parser.next(); // skip U
		
		// parse the text for the atom data
		int protons = parser.nextInt();
		int electrons = parser.nextInt();
		int neutrons = parser.nextInt();
	
		// create and output the atom
		System.out.println(name);
		Atom  atom = new Atom(protons, neutrons, electrons);
		System.out.println("Atomic mass: " + atom.getAtomicMass());
		parser.close();
	}
}

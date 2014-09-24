package lab2;

public class AtomTest
{
    //next test
	public static void main(String[] args)
	{
		//create an atom and check its initial state
		Atom uranium = new Atom(92, 146, 92);
		System.out.println( uranium.getAtomicCharge() );
		System.out.println( uranium.getAtomicMass() );
		
		//decay and check results
		uranium.decay();
		System.out.println( uranium.getAtomicCharge() );
		System.out.println( uranium.getAtomicMass() );
	}
}

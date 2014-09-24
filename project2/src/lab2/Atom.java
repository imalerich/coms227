package lab2;

/**
 * Encapsulates the state of an atom
 * holds the protons neutrons and electrons
 * and provides utilites to access the state of the atom.
 * @author imalerich
 *
 */
public class Atom
{
	/**
	 * current proton count
	 */
	private int protons;
	/**
	 * current neutron count
	 */
	private int neutrons;
	/**
	 * current electron count
	 */
	private int electrons;
	
	/**
	 * construct a new Atom
	 * @param givenProtons
	 * 	the initial proton count
	 * @param givenNeutrons
	 * 	the initial neutron count
	 * @param givenElectrons
	 * 	the initial electorn count
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons)
	{
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
	}
	
	/**
	 * get the atomic mass of this atom
	 * @return
	 * 	the sum of this atoms protons and its neutrons
	 */
	public int getAtomicMass()
	{
		return protons+neutrons;
	}
	
	/**
	 * get the atomic charge of this atom
	 * @return
	 * 	the difference of the proton count and electron count
	 */
	public int getAtomicCharge()
	{
		return protons-electrons;
	}
	
	/**
	 * decreases the proton and neutron count by 2
	 */
	public void decay()
	{
		protons -= 2;
		neutrons -= 2;
	}
}

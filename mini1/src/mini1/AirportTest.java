package mini1;

public class AirportTest
{
	public static void main(String[] Args)
	{
		AirportTram t = new AirportTram(4, 3);
		t.runSegment(0, 5);
		t.runSegment(2, 5);
		
		System.out.println(t.getCurrentStop());
		System.out.println(t.getCurrentPassengers());
		System.out.println(t.getTotalPassengersServed());
		System.out.println(t.getMaxPassengers());
		System.out.println(t.getAveragePassengersPerSegment());
	}
}

public class Hello 
{
	public static void main(String[] args)
	{
		ParkingMeter meter = new ParkingMeter(1, 2, 3, 100, 100);
		meter.insertDimes(2);
		meter.insertNickels(5);
		meter.insertQuarters(18);
		
		System.out.println( meter.getDollarString() );
		System.out.println( meter.toString() );
	}
}

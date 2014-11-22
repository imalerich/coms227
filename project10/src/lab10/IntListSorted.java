package lab10;

public class IntListSorted extends IntList 
{
	public static void main(String[] args) {
		IntListSorted i = new IntListSorted();
		i.add(10);
		i.add(3);
		i.add(0);
		i.add(2);
		i.add(1);
		
		System.out.println(i.toString());
		System.out.println("Median: " + i.getMedian());
		System.out.println("Min: " + i.getMinimum());
		System.out.println("Max: " + i.getMaximum());
	}
	public IntListSorted() 
	{
		super();
	}

	/**
	 * Adds the new item not at end of the list, but at the correct spot so that
	 * the list stays sorted.
	 * 
	 * @param newItem the item to add.
	 */
	public void add(int newItem) 
	{
		// Ask the superclass to insert the item at the end of the list.
		super.add(newItem);

		// Now, look at the item right before the new item. Is it greater than
		// the new item? If so, swap the items. Keep doing this until we either
		// see an item before the new item that is not greater or we hit the
		// front of the list.
		int tmp;
		for (int i = size - 1; i > 0 && list[i - 1] > list[i]; --i) {
			tmp = list[i];
			list[i] = list[i - 1];
			list[i - 1] = tmp;
		}
	}
	
	/**
	 * Find the maximum int in the list.
	 *
	 * @return
	 * Maximum value in list.
	 */
	@Override
	public int getMaximum()
	{
		return list[size()-1];
	}
	
	/**
	 * Find the minimum int in the list.
	 *
	 * @return
	 * Minimum value in list.
	 */
	@Override
	public int getMinimum()
	{
		return list[0];
	}
	
	/**
	 * Get the median value of the list.
	 * @return
	 * 	The median value of the list.
	 */
	public int getMedian()
	{
		return list[size()/2 - 1 + size()%2];
	}
}
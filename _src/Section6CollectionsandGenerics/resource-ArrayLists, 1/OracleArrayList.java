public class OracleArrayList<T>
{
	private T[] mItems;
	private int mFilledSpots;

	public OracleArrayList()
	{
		mItems = (T[]) new Object[10];
	}

	public void add(T item)
	{
		if (mFilledSpots < mItems.length)
		{
			mItems[mFilledSpots] = item;
			mFilledSpots++;
		}
		else
		{
			T[] copy = mItems;
			mItems = (T[]) new Object[mItems.length + 10];
			for (int i = 0; i < copy.length; i++)
			{
				mItems[i] = copy[i];
			}
			
			add(item);
		}
	}
	
	public T get(int index)
	{
		return mItems[index];
	}
	
	public int size()
	{
		return mItems.length;
	}
}

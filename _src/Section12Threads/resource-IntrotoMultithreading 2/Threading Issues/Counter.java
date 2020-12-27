
public class Counter
{
	private int x;
	
	public synchronized void add()
	{
		for (int i = 0; i < 2000; i++)
		{
		}

		x++;
	}
	
	public synchronized void sub()
	{
		x--;
	}
	
	public synchronized int getX()
	{
		return x;
	}
}

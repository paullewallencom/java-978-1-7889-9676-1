
public class Rock implements NonMovableActivityClient
{
	@Override
	public void doSomething()
	{
		System.out.println("I can't do anything on my own - I'm a rock!");
	}

	@Override
	public void onUseRequested()
	{
		System.out.println("I am being used!");
	}

	@Override
	public void test()
	{
	}
	
	@Override
	public void defaultActivity()
	{
		System.out.println("This is rock's implementation");
	}
}

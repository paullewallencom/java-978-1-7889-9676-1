public interface ActivityClient
{
	void doSomething(int value);
	default void defaultActivity()
	{
		System.out.println("This is default activity");
	}
}

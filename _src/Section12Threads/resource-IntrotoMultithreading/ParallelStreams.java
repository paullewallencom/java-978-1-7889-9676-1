import java.util.ArrayList;
import java.util.Arrays;

public class ParallelStreams
{
	public static void main(String[] args)
	{
		ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		intArray
			.parallelStream()
			.forEach((x) -> 
			{
				System.out.println(x);
			});
	}
}

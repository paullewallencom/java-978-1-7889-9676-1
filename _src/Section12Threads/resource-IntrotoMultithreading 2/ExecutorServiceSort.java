import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSort
{
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Double>> randomNumLists = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < 10; i++)
		{
			randomNumLists.add(new ArrayList<Double>());
		}

		for (int i = 0; i < randomNumLists.size(); i++)
		{
			ArrayList<Double> nonInit = randomNumLists.get(i);
			for (int j = 0; j < 100; j++)
			{
				nonInit.add(Math.random() * 100);
			}
		}
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<Callable<ArrayList<Double>>> callables = new ArrayList<Callable<ArrayList<Double>>>();
		randomNumLists.stream().forEach((listToSort) -> 
		{
			callables.add(() -> 
			{
				Collections.sort(listToSort);
				return listToSort;
			});
		});
		
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		try
		{
			List<Future<ArrayList<Double>>> out = service.invokeAll(callables);
			service.shutdown();
			
			randomNumLists.stream().forEach((sortedList) -> 
			{
				double avg = sortedList.stream()
					.mapToDouble((x) -> x)
					.average()
					.getAsDouble();
				
				System.out.println("List's average is: " + avg);
			});
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println("Program took: " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}
}

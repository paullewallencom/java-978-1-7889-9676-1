import java.util.ArrayList;
import java.util.Collections;


public class ListSort
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
			for (int j = 0; j < 1000000; j++)
			{
				nonInit.add(Math.random() * 100);
			}
		}
		
		ArrayList<Thread> joinedThreads = new ArrayList<Thread>();
		
		long startTime = System.currentTimeMillis();
		int listNum = 0;
		for (ArrayList<Double> arrayList : randomNumLists)
		{
			System.out.println("Firing new thread");
			
			final int index = listNum;
			Thread t = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					Collections.sort(arrayList);
					System.out.println("Finished sorting list number: " + index);
				}
			}); 
			
			t.start();
			joinedThreads.add(t);
			listNum++;
			// ------> main thread ---->
			// 				|
			//				|
			//				|
			//			new thread -----> finish			
		}
		
		for (Thread thread : joinedThreads)
		{
			try
			{
				System.out.println("Waiting for thread to finish");
				thread.join();
				System.out.println("Thread finished executing");
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Program took: " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}
}

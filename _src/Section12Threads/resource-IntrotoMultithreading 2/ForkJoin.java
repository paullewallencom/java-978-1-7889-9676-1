import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoin
{
	public static void main(String[] args)
	{
		int[] myList = new int[50000]; // sum([500]) + sum([500]) ... sum([500])
		for (int i = 0; i < myList.length; i++)
		{
			myList[i] = i;
		}

		int sum = 0;
		for (int i = 0; i < myList.length; i++)
		{
			sum += myList[i];
		}

		System.out.println(sum);
		
		int parallelSum = new ForkJoinPool().invoke(new DivideAndSumTask(myList));
		System.out.println("Parallel sum is: " + parallelSum);
	}

	static class DivideAndSumTask extends RecursiveTask<Integer>
	{
		private int[] mArr;
		private int mStart, mEnd;
		private final int MAX_VALUES_BEFORE_DIVIDE = 500;

		public DivideAndSumTask(int[] arr)
		{
			mArr = arr;
			mStart = 0;
			mEnd = arr.length;
		}

		public DivideAndSumTask(int[] arr, int start, int end)
		{
			mArr = arr;
			mStart = start;
			mEnd = end;
		}

		@Override
		protected Integer compute()
		{
			int sum = 0;
			int dSize = mEnd - mStart;
			if (dSize <= MAX_VALUES_BEFORE_DIVIDE)
			{
				for (int i = mStart; i < mEnd; i++)
				{
					sum += mArr[i];
				}
			}
			else
			{
				ArrayList<ForkJoinTask<Integer>> tasks = new ArrayList<ForkJoinTask<Integer>>();
				
				int numTasks = (int) (dSize / MAX_VALUES_BEFORE_DIVIDE) + 1;
				for (int i = 0; i < numTasks; i++)
				{
					int start = i * MAX_VALUES_BEFORE_DIVIDE;
					int end = Math.min(start + MAX_VALUES_BEFORE_DIVIDE, mArr.length);
					
					DivideAndSumTask task = new DivideAndSumTask(mArr, start, end);
					tasks.add(task.fork());
				}
				
				for (ForkJoinTask<Integer> forkJoinTask : tasks)
				{
					sum += forkJoinTask.join();
				}
			}

			return sum;
		}
	}
}

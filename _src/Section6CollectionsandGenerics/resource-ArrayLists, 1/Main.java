import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main
{
	public static void main(String[] args)
	{
		class Holder<K, V>
		{
			private K key;
			private V value;

			public Holder(K key, V value)
			{
				this.key = key;
				this.value = value;
			}
		}

		Holder<Integer, String> h1 = new Holder<Integer, String>(10, "Bob");
		Holder<Integer, String> h2 = new Holder<Integer, String>(20, "Willy");
		Holder<Integer, String> h3 = new Holder<Integer, String>(201123, "Emily");
		Holder<Integer, String> h4 = new Holder<Integer, String>(293423, "Samantha");

		ArrayList<Holder<Integer, String>> list = new ArrayList<Holder<Integer, String>>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);

		int desiredId = 293423;
		for (Holder<Integer, String> holder : list)
		{
			if (holder.key == desiredId)
			{
				// System.out.println(holder.value);
				break;
			}
		}

		// HashMap<Integer, String> schoolRecords = new HashMap<Integer, String>();
		// schoolRecords.put(10, "Bob");
		// schoolRecords.put(20, "Willy");
		//
		// String studentName = schoolRecords.get(20);
		// if (studentName != null)
		// {
		// System.out.println(studentName);
		// }
		// else
		// {
		// System.out.println("We couldn't find a student for that id");
		// }
		//

		OracleHashMap.HashProvider<String> provider = new OracleHashMap.HashProvider<String>()
		{
			@Override
			public int getHash(String key)
			{
				int sum = 0;
				for (int i = 0; i < key.length(); i++)
				{
					sum += key.charAt(i) * i;
				}

				return sum;
			}
		};

		OracleHashMap<String, Integer> hashTest = new OracleHashMap<String, Integer>(provider);
		hashTest.put("Sally", 100);
		hashTest.put("yllaS", 23);
		hashTest.put("Joey", 40);

		int result = hashTest.get("Joey");
		System.out.println("Id number is: " + result);

		TreeSet<String> myTreeSet = new TreeSet<String>();
		myTreeSet.add("Willy");
		myTreeSet.add("Joey");
		myTreeSet.add("Banana");
//		System.out.println(myTreeSet); // Binary Search Tree (O(log(N)))
		
		Deque<String> deque = new LinkedList<String>();
		deque.addFirst("First");
		deque.add("Sally");
		deque.push("End of array?");
		System.out.println(deque);
		deque.pop();
		System.out.println(deque);
	}
}

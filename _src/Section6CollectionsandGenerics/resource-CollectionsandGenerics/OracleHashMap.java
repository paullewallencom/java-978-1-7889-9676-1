import java.util.ArrayList;

public class OracleHashMap<K, V>
{
	private class Holder<K2, V2>
	{
		private K2 key;
		private V2 value;

		public Holder(K2 key, V2 value)
		{
			this.key = key;
			this.value = value;
		}
	}

	public static interface HashProvider<K>
	{
		public int getHash(K key); // f(x) = y, y value should be the same everytime we provide x = 2, or x = 3 and so on
	}

	private ArrayList<Holder<K, V>>[] values; // [ArrayList], [ArrayList], [ArrayList], [ArrayList]
	// Arraylist at index 0: [V], [V], [V], [V], [V]
	private HashProvider<K> mProvider;

	public OracleHashMap(HashProvider<K> provider)
	{
		values = new ArrayList[1000];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = new ArrayList<OracleHashMap<K, V>.Holder<K, V>>();
		}

		mProvider = provider;
	}

	public void put(K key, V value)
	{
		Holder<K, V> itemInBucket = getHolder(key);
		if (itemInBucket != null)
		{
			itemInBucket.value = value;
		}
		else
		{
			getBucket(key).add(new Holder<K, V>(key, value));
		}
	}

	public V get(K key)
	{
		Holder<K, V> holder = getHolder(key);
		if (holder != null)
		{
			return holder.value;
		}

		return null;
	}

	private Holder<K, V> getHolder(K key)
	{
		ArrayList<Holder<K, V>> bucket = getBucket(key);
		for (int i = 0; i < bucket.size(); i++)
		{
			Holder<K, V> item = bucket.get(i);
			if (item.key == key)
			{
				return item;
			}
		}

		return null;
	}

	private ArrayList<Holder<K, V>> getBucket(K key)
	{
		int index = getHash(key);
		return values[index];
	}

	// 5 % 2 --> Gets remainder of 5 / 2 --> 1
	// 5 % 1 = 0, 5 % 2 = 1, 5 % 3 = 2, 5 % 4 = 1, 5 % 5 = 0
	private int getHash(K key)
	{
		return mProvider.getHash(key) % values.length;
	}
}

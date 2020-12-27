import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaInterfaces
{
	public static interface MyInterface
	{
		public void absMethod(int x);
	}

	public static void main(String[] args)
	{
		Person person = new Person("Willy", 20, new Person.Address("298 Chick Filee Drive", "New York City", "New York"));

		Person builderPerson = new Person.Builder().name("Willy").age(20)
				.address(new Person.Address.Builder().street("298 Chick Filee Drive").city("New York City").state("North York").create()).create();

		Person p2 = new Person.Builder().name("Sammy").age(20)
				.address(new Person.Address.Builder().street("298 Willy Wonka Drive").city("New York City").state("North York").create()).create();

		Person p3 = new Person.Builder().name("Joey").age(20)
				.address(new Person.Address.Builder().street("298 Antartica Drive").city("New York City").state("North York").create()).create();

		ArrayList<Person> personsList = new ArrayList<Person>(Arrays.asList(new Person[]
		{
				builderPerson, p2, p3
		}));

		for (Person person2 : personsList)
		{
			if (!person2.getName().equals("Willy"))
			{
				System.out.println(person2.getName());
			}
		}

		System.out.println("----------------");

		personsList.forEach((loopItem) -> {
			// System.out.println(loopItem.getName());
			});

		// Same as the lambda expression above
		personsList.forEach(new Consumer<Person>()
		{
			@Override
			public void accept(Person t)
			{}
		});

		personsList.stream().filter(new Predicate<Person>()
		{
			@Override
			public boolean test(Person t)
			{
				return !t.getName().equals("Willy");
			}
		}).forEach(new Consumer<Person>()
		{
			@Override
			public void accept(Person t)
			{
				System.out.println(t.getName());
			}
		});

		personsList.stream()
			.filter((t) -> !t.getName().equals("Willy") || t.getAge() == 20)
			.map(LambdaInterfaces::mapPerson) // f(Person person) -> then return
			.forEach((Integer personAge) -> System.out.println(personAge)); // Now use the mapped output for each item in our loop
		
		HashMap<Integer, Person> map = new HashMap<Integer, Person>();
		map.put(0, person);
		map.put(1, p2);
		map.put(2, p3);
		
		BiPredicate<Integer, Person> personTest = (Integer k, Person p) -> p.getAge() < 50 && k > 1;
		if(personTest.test(3, p2))
			System.out.println("Predicate passed test!");
		else
			System.out.println("Predicate failed test!");
	}

	public static int mapPerson(Person person)
	{
		return person.getAge();
	}
}

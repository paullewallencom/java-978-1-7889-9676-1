import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args)
	{
		class Person
		{
			public int age;
			public String name;

			public Person(int age, String name)
			{
				this.age = age;
				this.name = name;
			}
			
			@Override
			public String toString()
			{
				return name;
			}
		}

		Person[] peopleArr =
		{
				new Person(10, "Sally"), new Person(20, "Joey"), new Person(30, "Willy"), new Person(10, "Smithy"), 
				new Person(30, "Joey")
		};

		ArrayList<Person> people = new ArrayList<>(Arrays.asList(peopleArr));
		Map<Integer, List<Person>> groupedPeople = people
				.stream()
				.collect(Collectors.groupingBy((p)->p.age));
		
		System.out.println(groupedPeople.toString());
		
//		people = new ArrayList<>(
//				people.stream()
//				.filter((person) -> person.age <= 20)
//				.collect(Collectors.toList())); 
		
//		people.stream()
//			.forEach((person)-> System.out.println(person.age + " " + person.name));
		
		
	}
}

import java.util.Date;

public class Person
{
	private String name, birthDate;

	public Person(String personName, String personBirthDate)
	{
		name = personName;
		birthDate = personBirthDate;
	}

	public void printInfo()
	{
		System.out.println("I am a person" + " and I was born on " + birthDate);
	}
	
	public void doSomething()
	{
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}
}

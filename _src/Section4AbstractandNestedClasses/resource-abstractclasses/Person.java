public abstract class Person
{
	private String name, birthDate;

	public Person(String personName, String personBirthDate)
	{
		name = personName;
		birthDate = personBirthDate;
	}

	public abstract void printInfo();

	public void doSomething()
	{}

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

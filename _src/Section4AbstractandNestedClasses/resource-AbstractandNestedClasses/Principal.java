import java.util.Date;

public class Principal extends Person
{
	private Date mJoinDate; // The date the principal joined the school

	public Principal(String personName, String personBirthDate, Date joinDate)
	{
		super(personName, personBirthDate);
		mJoinDate = joinDate;
	}

	@Override
	public void doSomething()
	{
		super.doSomething();
		System.out.println("This person is a principal");
	}

	@Override
	public void printInfo()
	{
		System.out.println("I am a principal");
	}
}

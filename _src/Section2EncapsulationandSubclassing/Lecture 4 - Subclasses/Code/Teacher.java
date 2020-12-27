public class Teacher extends Person
{
	private String mSchool;
	private double mSalary;
	
	public Teacher(String name, String birthDate, String school, double salary)
	{
		super(name, birthDate);
		mSchool = school;
		mSalary = salary;
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("I am a teacher and I was born on " + getBirthDate());
	}
}

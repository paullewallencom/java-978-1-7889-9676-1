public final class Teacher extends Person
{
	private String mSchool;
	private double mBaseSalary;
	private int mNumYearsAtSchool;
	
	public Teacher(String name, String birthDate, String school, double salary, int numYearsAtSchool)
	{
		super(name, birthDate);
		mSchool = school;
		mBaseSalary = salary;
		mNumYearsAtSchool = numYearsAtSchool;
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("I am a teacher and I was born on " + getBirthDate());
	}
	
	public double getSalary()
	{
		return mNumYearsAtSchool * 1000 + mBaseSalary;
	}
}

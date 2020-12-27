public final class Teacher extends Person
{
	private String mSchool;
	private double mBaseSalary;
	private int mNumYearsAtSchool;
	private Subject mSubject;
	
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
		System.out.println("I am a teacher");
	}

	public double getSalary()
	{
		return mNumYearsAtSchool * 1000 + mBaseSalary;
	}
	
	public void setSubject(Subject teacherSubject)
	{
		mSubject = teacherSubject;
	}
	
	public Subject getSubject()
	{
		return mSubject;
	}
	
	public static class Subject
	{
		private String mSubjectName;
		
		public Subject(String subjectName)
		{
			mSubjectName = subjectName;
		}
		
		public String getName()
		{
			return mSubjectName;
		}
	}
}

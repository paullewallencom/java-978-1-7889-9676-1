public class Student extends Person
{
	private String mGpa;

	public Student(String studentName, String studentBirthDate, String gpa)
	{
		super(studentName, studentBirthDate);
		mGpa = gpa;
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("See? I'm in the student class now");
	}
}

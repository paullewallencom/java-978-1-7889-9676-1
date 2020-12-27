import java.util.Date;

public class Student extends Person
{
	private final int MAX_ASSIGNMENTS = 20;

	private double mGpa;
	private int mCurrentNumAssignments;
	
	private Assignment mCurrentAssignment;
	private Assignment[] mStudentAssignments;
	
	public Student(String studentName, String studentBirthDate, double gpa)
	{
		super(studentName, studentBirthDate);
		mGpa = gpa;
		mStudentAssignments = new Assignment[MAX_ASSIGNMENTS];
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("I am a student");
		System.out.println("These are the assignments that belong to user: " + getName());
		
		for (int i = 0; i < mCurrentNumAssignments; i++)
		{
			System.out.println(mStudentAssignments[i].getName());
		}
	}
	
	public void printAssignmentInfo()
	{
		if (mCurrentAssignment != null)
		{
			System.out.println(mCurrentAssignment.getName() + ", " + mCurrentAssignment.getAssignmentDueDate());
		}
	}
	
	@Override
	public String toString()
	{
		return getName() + " " + mGpa;
	}
	
	public void addAssignment(Assignment assignment)
	{
		if (mCurrentNumAssignments < MAX_ASSIGNMENTS)
		{
			mStudentAssignments[mCurrentNumAssignments] = assignment;
			mCurrentNumAssignments++;
		}
	}
	
	public void addAssignments(Assignment... assignments) // addAssignment(Assignment[] assignments)
	{
		for (Assignment assignment : assignments)
		{
			addAssignment(assignment);
		}
	}

	public void setCurrentAssignment(Assignment assignment)
	{
		mCurrentAssignment = assignment;
	}
	
	public void setCurrentAssignment(String assignmentName)
	{
		mCurrentAssignment = new Assignment(assignmentName, "Default Class", new Date());
	}
}

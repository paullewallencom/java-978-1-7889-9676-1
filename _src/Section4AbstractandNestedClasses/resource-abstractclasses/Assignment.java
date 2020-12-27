import java.util.Date;

public class Assignment
{
	private String mName, mClassName;
	private Date mAssignmentDueDate;
	
	public static final int ASSIGNMENT_DEFAULT_SCORE = 20;
	
	public Assignment(String name, String className, Date assignmentDueDate)
	{
		mName = name;
		mClassName = className;
		mAssignmentDueDate = assignmentDueDate;
	}
	
	public static Assignment getFarthestInPastAssignment(Assignment[] assignments)
	{
		long date = Long.MAX_VALUE;
		
		Assignment closestAssignment = null;
		for (Assignment assignment : assignments)
		{
			if (assignment.mAssignmentDueDate.getTime() < date)
			{
				date = assignment.mAssignmentDueDate.getTime();
				closestAssignment = assignment;
			}
		}
		
		return closestAssignment;
	}
	
	public String getName()
	{
		return mName;
	}

	public void setName(String mName)
	{
		this.mName = mName;
	}

	public String getClassName()
	{
		return mClassName;
	}

	public void setClassName(String mClassName)
	{
		this.mClassName = mClassName;
	}

	public Date getAssignmentDueDate()
	{
		return mAssignmentDueDate;
	}

	public void setAssignmentDueDate(Date mAssignmentDueDate)
	{
		this.mAssignmentDueDate = mAssignmentDueDate;
	}
}

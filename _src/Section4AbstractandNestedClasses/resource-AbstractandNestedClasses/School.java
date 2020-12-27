public class School
{
	private Principal mPrincipal;
	private Teacher[] mTeachers;
	private Student[] mStudents;
	private String mSchoolName;
	
	private static School mInstance;

	// Singleton
	public static School getInstance()
	{
		if (mInstance == null)
			mInstance = new School();

		return mInstance;
	}

	private School()
	{
	}

	public void setPrincipal(Principal principal)
	{
		mPrincipal = principal;
	}

	public String getSchoolName()
	{
		return mSchoolName;
	}

	public void setSchoolName(String mSchoolName)
	{
		this.mSchoolName = mSchoolName;
	}
}

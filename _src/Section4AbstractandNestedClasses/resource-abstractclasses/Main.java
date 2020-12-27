public class Main
{
	public static void main(String[] args)
	{
		// Teacher sally = new Teacher("Sally", "04/24/1970", "UCLA", 50000, 10);
		// System.out.println(sally.getSalary());
		//
		// Date mAssignmentDueDate = new Date();
		// Assignment joeyAssignment = new Assignment("Calculus Homework", "Calculus", mAssignmentDueDate);
		//
		// Student joey = new Student("Joey", "02/23/1992", 4.0);
		// // joey.setCurrentAssignment(joeyAssignment);
		// // joey.setCurrentAssignment("Biology project");
		// // joey.printAssignmentInfo();
		// // System.out.println(joey);
		//
		// // joey.addAssignment(new Assignment("Bio HW", "Biology", new Date()));
		// // joey.addAssignment(new Assignment("Computer Science Lab", "CS", new Date()));
		//
		// joey.addAssignments(new Assignment("Bio HW", "Biology", new Date()), new Assignment("Computer Science Lab", "CS", new Date()),
		// new Assignment("Computer Science Lab", "CS", new Date()), new Assignment("Computer Science Lab", "CS", new Date()), new Assignment(
		// "Computer Science Lab", "CS", new Date()));
		//
		// // joey.printInfo();
		// //
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(Calendar.YEAR, 1980);
		// calendar.set(Calendar.MONTH, Calendar.MARCH);
		// calendar.set(Calendar.DATE, 23);
		//
		// Principal principal = new Principal("Alex Smith", "03/23/1965", calendar.getTime());
		// principal.doSomething();
		//
		Teacher sallyTeacher = new Teacher("Alexis Brown", "05/07/1980", "San Diego State", 50000, 20);
		// Teacher.Subject sallySubject = new Teacher.Subject("History"); // Use this syntax for nested classes: sallyTeacher.new Subject("History");
		// sallyTeacher.setSubject(sallySubject);
		// System.out.println(sallyTeacher.getSubject().getName());

		// doSomething(joey);
		// doSomething(principal);
		// doSomething(sallyTeacher);

		// Assignment[] assignments =
		// {
		// new Assignment("Bio HW", "Biology", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)),
		// new Assignment("Computer Science Lab", "CS", new Date()), new Assignment("Computer Science Lab", "CS", new Date()),
		// new Assignment("Computer Science Lab", "CS", new Date()), new Assignment("Computer Science Lab", "CS", new Date())
		// };
		//
		// Assignment farthestInPast = Assignment.getFarthestInPastAssignment(assignments);
		// int defScore = Assignment.ASSIGNMENT_DEFAULT_SCORE;
		// System.out.println(farthestInPast.getName());
		//
		// School mSchool = School.getInstance();
		// mSchool.setPrincipal(principal);
		// otherFunction();
		//
		// Person person = new Person("name", "")
		// {
		// @Override
		// public void printInfo()
		// {
		// System.out.println("lalala");
		// }
		// };
		//
		// person.printInfo();

		Teacher.Subject subject = new Teacher.Subject("Math");
		sallyTeacher.setSubject(subject);
		System.out.println(sallyTeacher.getSubject().getName());
	}

	public static void otherFunction()
	{
		otherFunction2();
	}

	public static void otherFunction2()
	{
		School sameSchool = School.getInstance();
	}

	public static void doSomething(Person person)
	{
		if (person instanceof Student)
		{
			System.out.println("This person is a student");
		}
		else if (person instanceof Teacher)
		{
			Teacher castedTeacher = (Teacher) person;
			System.out.println("This person is a teacher who has a salary of " + castedTeacher.getSalary());
		}
		else if (person instanceof Principal)
		{
			System.out.println("This person is a principal");
		}
	}
}

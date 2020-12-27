public class Main
{
	public static void main(String[] args)
	{
		//
		// Person person1 = new Person("Joey", "April 10, 1990");
		// person1.printInfo();

		// Teacher teacher1 = new Teacher("Sally", "March 1, 1980", "UCLA", 90000);
		// teacher1.printInfo();
		//
		// Teacher teacher2 = new Teacher("Wendy", "February 2, 1980", "Caltech", 90000);
		// teacher2.printInfo();
		//
		// Student student1 = new Student("Willy", "April 20, 2000", "4.0");
		// student1.printInfo();

		Person[] myPersonArray =
		{
				new Student("Willy", "April 20, 2000", "4.0"), new Teacher("Wendy", "February 2, 1980", "Caltech", 90000)
		};

		for (int i = 0; i < myPersonArray.length; i++)
		{
			myPersonArray[i].printInfo();
		}
	}
}

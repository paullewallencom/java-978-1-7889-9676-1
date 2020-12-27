public class Main
{
	public static void main(String[] args)
	{
		Animal animal = new Animal()
		{
			@Override
			public void walk()
			{}
		};

		Rock rock = new Rock();
		// rock.onUseRequested();
		// rock.test();

		// animal.eat();
		Car car = new Car();
		ActivityClient[] items =
		{
				animal, car, rock
		};

		// for (ActivityClient item : items)
		// {
		// item.doSomething();
		// item.defaultActivity();
		// }

//		class CustomClass implements ActivityClient
//		{
//			@Override
//			public void doSomething()
//			{
//				System.out.println("This is intended to make the concept of  anonymous inner classes more clear");
//			}
//		}
//
//		ActivityClient client = new ActivityClient()
//		{
//			@Override
//			public void doSomething()
//			{
//				System.out.println("This is an anonymous inner class");
//			}
//		};

		AnimateActivityManager manager = new AnimateActivityManager();
		manager.accept(new ActivityClient()
		{
			@Override
			public void doSomething(int value)
			{
				
			}
		});
		
		manager.accept((val)->
		{
			System.out.println("This is a lambda expression with val" + val);
		});
	}
}

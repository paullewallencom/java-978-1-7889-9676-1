public class Person
{
	private String mName;
	private int mAge;
	private Address mAddress;

	public Person(String name, int age, Address address)
	{
		mName = name;
		mAge = age;
		mAddress = address;
	}

	public String getName()
	{
		return mName;
	}

	public int getAge()
	{
		return mAge;
	}

	public Address getAddress()
	{
		return mAddress;
	}

	static class Builder
	{
		private String mName;
		private int mAge;
		private Address mAddress;

		public Builder name(String name)
		{
			mName = name;
			return this;
		}

		public Builder age(int age)
		{
			mAge = age;
			return this;
		}

		public Builder address(Address address)
		{
			mAddress = address;
			return this;
		}

		public Person create()
		{
			return new Person(mName, mAge, mAddress);
		}
	}

	static class Address
	{
		private String mStreet, mCity, mState;

		public Address(String street, String city, String state)
		{
			mStreet = street;
			mCity = city;
			mState = state;
		}

		public String getStreet()
		{
			return mStreet;
		}

		public void setStreet(String mStreet)
		{
			this.mStreet = mStreet;
		}

		public String getCity()
		{
			return mCity;
		}

		public void setCity(String mCity)
		{
			this.mCity = mCity;
		}

		public String getState()
		{
			return mState;
		}

		public void setState(String mState)
		{
			this.mState = mState;
		}

		public static class Builder
		{
			private String mStreet, mCity, mState;

			public Builder street(String street)
			{
				mStreet = street;
				return this;
			}

			public Builder city(String city)
			{
				mCity = city;
				return this;
			}

			public Builder state(String state)
			{
				mState = state;
				return this;
			}

			public Address create()
			{
				return new Address(mStreet, mCity, mState);
			}
		}
	}
}

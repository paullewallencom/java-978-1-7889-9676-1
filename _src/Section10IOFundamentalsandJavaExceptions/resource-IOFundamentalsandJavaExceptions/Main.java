import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		// while(scanner.hasNextLine())
		// {
		// String input = scanner.nextLine();
		// }

		// try
		// {
		// String s = null;
		// int len = s.length();
		// }
		// catch (NullPointerException e)
		// {
		// System.out.println("Program crashed!");
		// }
		//
		// System.out.println("Continue program's execution as normal");

		File file = new File("test.txt");

		try
		{
			FileOutputStream out = new FileOutputStream(file);
			out.write("Trololo".getBytes());
			out.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.print("File wasn't found. Aborting write");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.print("IO Exception. Couldn't finish writing the file");
		}

		try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(new File("obj.ser"))))
		{
			objOutStream.writeObject(new SimpleObject("these are some random contents", 1, 2, 3));

			try (ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(new File("obj.ser"))))
			{
				SimpleObject data = (SimpleObject) objInputStream.readObject();
				// System.out.print(data.getContents() + " " + data.getX() + " " + data.getY() + " " + data.getZ());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println(readFromFile("test.txt"));

		try
		{
			testThrow();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			String s = null;
			s.length();
		}
		catch (NullPointerException e)
		{
			System.out.println("Contents are null!");
		}

		try
		{
			readUserData();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (MyCheckedException e)
		{
		}
		catch (MyUncheckedException e)
		{
		}
	}

	public static void testThrow() throws FileNotFoundException
	{
		BufferedReader reader = new BufferedReader(new FileReader(new File("asdfasdf")));
	}

	public static String readUserData() throws FileNotFoundException, MyUncheckedException, MyCheckedException
	{
		return null;
	}

	public static String readFromFile(String fileName)
	{
		String out = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName))))
		{
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				out += line + "\n";
			}

			throw new MyCheckedException();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (MyCheckedException e)
		{
			e.printStackTrace();
		}

		// finally
		// {
		// if (reader != null)
		// {
		// try
		// {
		// reader.close();
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// }
		// }

		return out;
	}
}

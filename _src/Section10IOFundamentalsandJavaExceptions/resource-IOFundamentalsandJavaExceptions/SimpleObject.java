import java.io.Serializable;

public class SimpleObject implements Serializable
{
	private String contents;
	private int x, y, z;
	
	public SimpleObject(String contents, int x, int y, int z)
	{
		super();
		this.contents = contents;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getZ()
	{
		return z;
	}

	public void setZ(int z)
	{
		this.z = z;
	}
}

/**
 * The Cannon class represents the idea of a cannon in the Alien Invasion game.
 * @author Jason
 * @author Linna
 *
 */
public class Cannon
{
	private int size;
	private int x;
	private int y;
	private int width;
	private int length;
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getLength()
	{
		return length;
	}
	public void setSize(int length,int width)
	{
		 size = (width*length);
	}
	public int setAlocation;
	{
		this.x = x;
		this.y = y;
	}
}
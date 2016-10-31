/**
 * The Cannon class represents the idea of a cannon in the Alien Invasion game.
 * @author Jason
 * @author Linna
 *
 */
public class Cannon
{
	private int aradius;
	private double asize;
	private int x;
	private int y;
	private int bwidth;
	private int blength;
	
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
		return bwidth;
	}
	public int getLength()
	{
		return blength;
	}
	public int setAradius;
	{
		this.aradius = 1;
	}
	
	//Why do we need to know this?
	public double setArea;
	{
		this.asize = (3.14159*aradius*aradius)/2;
	}
	
	public int setAlocation;
	{
		this.x = x;
		this.y = y;
	}
	
	
	
}
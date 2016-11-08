import javafx.scene.canvas.GraphicsContext; 
/**
 * The Missile class contains represents the idea of a missile in the Alien Invasion game. 
 * @author Charlie
 * @author Gavin
 *
 */
public class Missile
{
	private double xPos, yPos, diameter;
	private boolean DidHit;
	
	public Missile (double startingxPos, double startingyPos, boolean setDidHit, double setdiameter)
	{
		xPos = startingxPos;
		yPos = startingyPos;
		DidHit = setDidHit;
		diameter = setdiameter;
	}
	
	public void drawAndShoot (GraphicsContext gc, double speed, double angle)//takes the angle in degrees
	{	
		if (DidHit == false)
		{
			this.xPos = this.xPos + speed * Math.cos(angle/180*3.1416);
			this.yPos = this.yPos - speed * Math.sin(angle/180*3.1416);
			gc.fillOval(xPos, yPos, diameter, diameter);
		}
		
	}
	
	public void setPos(double x, double y)
	{
		this.xPos = x;
		this.yPos = y;
	}
	
	public boolean getDidHit()
	{
		return DidHit;
	}
	
	public void setDidHit(boolean dh)
	{
		this.DidHit = dh;
	}
	
	public double getxPos()
	{
		return xPos;
	}
	
	public double getyPos()
	{
		return yPos;
	}
	
}	
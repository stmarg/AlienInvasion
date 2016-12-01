import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * The Missile class contains represents the idea of a missile in the Alien Invasion game. 
 * @author Charlie
 * @author Gavin
 *
 */
public class Missile
{
	private double xPos, yPos, diameter, angle, speed, sx, sy;
	private boolean DidHit = false;
	private Color c;
	
	public Missile (double x, double y, double setdiameter, double setangle, double setspeed)
	{
		
		xPos = x;
		yPos = y;
		diameter = setdiameter;
		angle = setangle;
		speed = setspeed;
		c = Color.RED;
		
		sx = speed * Math.cos(angle/180*3.1416);
		sy = -speed * Math.sin(angle/180*3.1416);
		
	}
	
	public Missile (double setangle)
	{
		this (800, 700, 50, setangle, 4);
	}
	
	public Missile (double x, double y, double setdiameter, double setangle, double setspeed, Color whatcolor)
	{
		
		xPos = x;
		yPos = y;
		diameter = setdiameter;
		angle = setangle;
		speed = setspeed;
		c = whatcolor;
		
		
		sx = speed * Math.cos(angle/180*3.1416);
		sy = -speed * Math.sin(angle/180*3.1416);
		
	}
	
	
	public void draw(GraphicsContext gc)//takes the angle in degrees
	{	
		if (this.DidHit == false)
		{
			gc.setFill(c);
			gc.fillOval(xPos, yPos, diameter, diameter);

			xPos += sx;
			yPos += sy;
		}
	}
	
	public void setPos(double x, double y)
	{
		this.xPos = x;
		this.yPos = y;
	}
	
	public boolean DidHit(Ship s)
	{
		if ((s.getX() + s.getWidth()/2 - this.getxPos()) < (s.getWidth()/2 + this.getDiameter()/2) && (s.getY() + s.getHeight()/2 - this.getyPos()) < (s.getHeight()/2 + this.getDiameter()/2))
		{
			return true;
			
		}
		return false;
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
	
	public double getDiameter()
	{
		return diameter;
	}
	
}	
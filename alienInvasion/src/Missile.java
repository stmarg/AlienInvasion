import javafx.scene.canvas.GraphicsContext;
/**
 * The Missile class contains represents the idea of a missile in the Alien Invasion game. 
 * @author Charlie
 * @author Gavin
 *
 */
public class Missile
{
	private double xPos, yPos, speed;
	private double diameter = 50;
	private boolean DidHit;
	
	double angle = Math.atan(yPos / xPos);
	
	public void exist(GraphicsContext gc, Ship s)
	{
		if (DidHit == false)
		{
			gc.fillOval(xPos, yPos, diameter, diameter);
		}
			
	}
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public void setPos(double angle, double cannon_length)
	{
		xPos = 700 + cannon_length * Math.cos(angle);
		yPos = 800 + cannon_length * Math.sin(angle); 
		
	}
	
	//What is the purpose of this method?
	public void shootMissile(double angle, Ship s)
	{
		boolean test = false;
		double xV = 0;
		double yV = 0;
		boolean midstep = false;
		
			xV = this.speed * Math.cos(angle);
			yV = this.speed * Math.sin(angle);
			
			
		if (test == true)
		{
			midstep = true;
		}
			
		if (midstep == true)
		{
			xPos = xPos + xV;
			yPos = yPos + yV;
		}
		
		if (this.xPos > s.getxPos() && this.xPos < (s.getxPos() + s.getLength()) && this.yPos > s.getyPos() && this.yPos < (s.getyPos() + s.getHeight()))
		{
			//this.explode();
		}
			
	}
	
	public void explode(GraphicsContext gc)
	{
			
		gc.fillOval(xPos, yPos, diameter /4, diameter /4); //WIP
			
			
	}
	
	public boolean didHit(Ship s)
	{
		boolean mid = false;
		
		if (this.xPos > s.getxPos() && this.xPos < (s.getxPos() + s.getLength()) && this.yPos > s.getyPos() && this.yPos < (s.getyPos() + s.getHeight()))
		{
			mid = true;
		}	
		
		if (mid == true)
		{
			DidHit = true;
		}
			
		return DidHit;
		
	}
	
	
}
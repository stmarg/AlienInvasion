import javafx.scene.canvas.GraphicsContext; 

public class Missile
{
	private double xPos, yPos;
	private boolean DidHit;
	
	
	public void Missile (GraphicsContext gc, double startingxPos, double startingyPos, double speed, double angle, double diameter)
	{	
		if (DidHit == false)
		{
			gc.fillOval(xPos, yPos, diameter, diameter);
			this.xPos = this.xPos + speed * Math.cos(angle/180*3.1416);
			this.yPos = this.yPos - speed * Math.sin(angle/180*3.1416);
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
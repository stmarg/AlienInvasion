import javafx.scene.canvas.GraphicsContext; 

public class Missile
{
	private double xPos, yPos;
	private boolean DidHit;
	
	
	public void Missile (GraphicsContext gc, double startingxPos, double startingyPos, double speed, double angle, double diameter)
	{
		this.xPos = startingxPos;
		this.yPos = startingyPos;
		
		while (DidHit == false)
		{
			gc.fillOval(xPos, yPos, diameter, diameter);
			this.xPos = this.xPos + speed * Math.cos(angle);
			this.yPos = this.yPos + speed * Math.sin(angle);
		}
		
	}
	
	public boolean getDidHit()
	{
		return DidHit;
	}
	
	public void setDidHit(boolean dh)
	{
		this.DidHit = dh;
	}
	
}	
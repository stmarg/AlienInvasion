import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Cannon
{
	//private int size;
	private int x;
	private int y;
	private double angle;
	private int barrelx;
	private int barrely;
	private int width;
	private int height;
	private int size;
	
	public Cannon(int x, int y, int size)
	{
		this.x=x;
		this.y=y;
		this.size= width*height;
		
	}
	public int getbX()
	{
		return barrelx;
	}
	public int getbY()
	{
		return barrely;
	}
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
		return height;
	}
	public double getAngle()
	{
		return angle;
	}
	public Missile shoot()
	{
		Missile m = new Missile(x,y,diameter, angle, speed);
		return m;
	}
	public void setLocation(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.RED);
		gc.fillRect(x, y, height, width);
		gc.fillRect(x, y, height, width);
		
	}
}
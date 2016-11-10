import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cannon
{
	private int size;
	private int x;
	private int y;
	private int angle;
	private int barrelx;
	private int barrely;
	private int width;
	private int length;
	
	public Cannon(int x, int y, int size, int color)
	{
		this.x=x;
		this.y=y;
		this.size=size;
	}
	public int getbX()
	{
		return barrelx;
	}
	public int getbY()
	{
		return barrely;
	}
	public int getSize()
	{
		return size;
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
		return length;
	}
	public double getAngle()
	{
		return angle;
	}
	public void setSize(int length,int width)
	{
		 size = (width*length);
	}
	public int setAlocation()
	{
		this.x=x;
		this.y=y;
		this.barrelx=x;
		this.barrely=(y+2);
	}
	public void shoot()
	{
		
	}
	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.RED);
		gc.fillRect(x, y, length, width);
		gc.fillRect((x+length/2)-5, y-10, 10, 10);
	}
}
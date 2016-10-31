import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
/**
 * The Ship class represents the idea of a space ship in the Alien Invasion game.
 * @author Kevin
 * @author Madi
 *
 */
public class Ship
{
	Image alien = new Image("Alien.jpg");
	private double xLocation;
	private double yLocation;
	private double width;
	private double height;
	private double speedX;
	private double speedY;

	public Ship(double x, double d, double w, double h)
	{
		this.setDimensions(x, d, w, h);
	}

	public double getX()
	{
		return xLocation;
	}
	public double getY()
	{
		return yLocation;
	}
	public double getW()
	{
		return width;
	}
	public double getH()
	{
		return height;
	}
	public double getSpeedX()
	{
		return speedX;
	}
	public double getSpeedY()
	{
		return speedY;
	}
	
	//Why are you making a public method like this? 
	public void setDimensions( double xLocation, double yLocation, double width, double height)
	{
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.width = width;
		this.height = height;
	}
	public void setSpeed (double speedX, double speedY)
	{
		this.speedX = speedX;
		this.speedY = speedY;
	}
	public void moveIt(double speedX2, double speedY2)
	{
		xLocation = xLocation + speedX2;
		yLocation = yLocation + speedY2;
	}
	public void moveIt()
	{
		moveIt(speedX, speedY);
	}
	
	public void drawIt(GraphicsContext gc)
	{
		gc.drawImage(alien, getX(), getY(), getH(), getW());
		
	}
}
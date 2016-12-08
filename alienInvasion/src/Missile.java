import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Missile class contains represents the idea of a missile in the Alien
 * Invasion game.
 * 
 * @author Charlie
 * @author Gavin
 *
 */
public class Missile {
	private double xPos, yPos, diameter, angle, speed, sx, sy;
	private boolean inactive = false;
	private Color c;

	public Missile(double x, double y, double setdiameter, double setangle, double setspeed) {
		xPos = x;
		yPos = y;
		diameter = setdiameter;
		angle = setangle;
		speed = setspeed;
		c = Color.RED;

		sx = speed * Math.cos(angle / 180 * 3.1416);
		sy = -speed * Math.sin(angle / 180 * 3.1416);
	}

	public Missile(double setangle) {
		this(800, 700, 50, setangle, 4);
	}

	public Missile(double x, double y, double setdiameter, double setangle, double setspeed, Color whatcolor) {

		xPos = x;
		yPos = y;
		diameter = setdiameter;
		angle = setangle;
		speed = setspeed;
		c = whatcolor;

		sx = speed * Math.cos(angle / 180 * 3.1416);
		sy = -speed * Math.sin(angle / 180 * 3.1416);

	}

	public void draw(GraphicsContext gc)// takes the angle in degrees
	{
		// if (this.inactive == false)
		// {
		gc.setFill(c);
		gc.fillOval(xPos, yPos, diameter, diameter);

		xPos += sx;
		yPos += sy;
		// }
	}

	public boolean didHit(Ship s) {
		double sx = s.getX() + (s.getWidth() / 2);
		double sy = s.getY() + (s.getHeight() / 2);
		double tx = this.getxPos() + (this.getDiameter() / 2);
		double ty = this.getyPos() + (this.getDiameter() / 2);

		if (Math.abs(sx - tx) < (s.getWidth() + this.getDiameter()) / 2
				&& Math.abs(sy - ty) < (s.getHeight() + this.getDiameter() / 2)) {
			return true;

		}
		return false;
	}

	public boolean didHit(Powerup p) {
		double px = p.getX()+(p.getWidth()/2);
		double py = p.getY()+(p.getHeight()/2);
		double tx = this.getxPos()+(this.getDiameter()/2);
		double ty = this.getyPos()+(this.getDiameter()/2);
		
		return Math.abs(px-tx) < (p.getWidth()+this.getDiameter())/2 && 
				Math.abs(py-ty) < (p.getHeight()+ this.getDiameter()/2);
	}
	
	public void fall(double acc)
	{
		yPos = yPos + sy;
		sy = sy + acc;
	}
	
	public void wallbounce(double leftwall, double rightwall) //doesn't work. Not sure why.
	{
		if (xPos < leftwall || xPos > rightwall)
		{
			this.angle = 180 - angle;
		}
	}
	

	public void setInactive(boolean dh) {
		this.inactive = dh;
	}

	public boolean isInactive() {
		return inactive;
	}

	public boolean isActive() {
		return inactive == false;
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}
	
	public void setPos(double x, double y) {
		this.xPos = x;
		this.yPos = y;
	}

	public double getDiameter() {
		return diameter;
	}

}
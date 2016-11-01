import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
/**
 * The Ship class represents the idea of a space ship in the Alien Invasion game.
 * @author Kevin
 * @author Madi
 *
 */
public class Ship {
	Image alien = new Image("Tommy.jpg");
	private double x;
	private double originalx;
	private double y;
	private double width;
	private double height;
	private double vx;
	private double vy;

	public Ship(double x, double y, double w, double h){
		this.x = x;
		this.originalx = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	public void draw(GraphicsContext gc){
		gc.drawImage(alien, x, y, width, height);
	}

	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	public double getvx(){
		return vx;
	}
	
	public double getvy(){
		return vy;
	}
	
	//Why are you making a public method like this? 
	public void setDimensions( double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setSpeed (double vx, double vy){
		this.vx = vx;
		this.vy = vy;
	}
	
	public void move(){
		this.y = this.y + vy;
		this.x = this.x + vx;
		
		if (x > originalx+10 || x < originalx-10) {
			vx = -vx;
		}
		
		if (y > 900) {
			y = (int) (0 - height/1.5);
			x = (int) (Math.random() * 800) + 100;
		}
	}
}
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ship {
	private double x;
	private double originalx;
	private int y;
	private int width;
	private int height;
	private int originalW;
	private int originalH;
	private double vx = (int) 1.5;
	private int vy = (int) (Math.random() * 3) + 2;
	private int vs = 2;
	
	/**An example of how you can create a "constant". 
	 * It's public so everything can reference it. It's static so there is only one
	 * variable shared accross all instances (ie: it's a "class" variable and not an instance variable
	 * It's 'final' which means that it's value can not change. Note that constants are usually written all cap
	 */
	
	public static final int ALIEN_MODE = 1;
	public static final int TOMMY_MODE = 2;
	private int mode = 1;
	
	private boolean alive = true;
	
	private Image Alien = new Image("Alien.jpg");
	private Image Tommy = new Image("Tommy.png");
	
	public Ship(double x, int y, int width, int height, int mode) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.originalx = x;
		this.originalW = width;
		this.originalH = height;
		this.mode = mode;
	}
	
	/**
	 * This is an example of an overloaded constructor. It allows a ship to be created without
	 * specifying a 'mode'. This constructor simply 'chains' to the original constructor, passing
	 * in the value ALIEN_MODE as the mode value
	 * @param x The location of the ship in the x coordinate
	 * @param y The location of the ship in the y coordinate
	 * @param width The width of the ship
	 * @param height The height of the ship
	 */
	
	public Ship(int x, int y, int width, int height) {
		this (x,y,width,height, ALIEN_MODE);
	}

	public void draw(GraphicsContext gc) {
		if (mode == 1) {
			gc.drawImage(Alien, x, y, width, height);
		}
		
		if (mode == 2) {
			gc.drawImage(Tommy, x, y, width, height);
		}
	}
	
	public void move() {
		this.x = this.x + vx;
		this.y = this.y + vy;
		
		if (x > originalx+10 || x < originalx-10) {
			vx = -vx;
		}
	}
	
	public void sChange() {
		this.width = this.width + vs;
		this.height = this.height + vs;
		
		if (width > originalW+30 || width < originalW-30) {
			vs = -vs;
		}
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSpeed(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public double getOriginalx() {
		return originalx;
	}

	public void setOriginalx(double originalx) {
		this.originalx = originalx;
	}
}
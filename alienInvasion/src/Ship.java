import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ship {
	private int x;
	private int originalx;
	private int y;
	private int width;
	private int height;
	private int originalW;
	private int originalH;
	private int vx = (int) 1.5;
	private int vy = (int) (Math.random() * 4) + 3;
	private int vs = 2;
	
	private int mode = 1;
	private boolean alive = true;
	
	private Image Alien = new Image("alien.png");
	private Image Tommy = new Image("Tommy.png");
	
	public Ship(int x, int y, int width, int height, int mode) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.originalx = x;
		this.originalW = width;
		this.originalH = height;
		this.mode = mode;
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
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

	public int getOriginalx() {
		return originalx;
	}

	public void setOriginalx(int originalx) {
		this.originalx = originalx;
	}
}
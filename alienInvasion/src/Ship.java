import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ship {
	private int x;
	private int originalx;
	private int y;
	private int s;
	private int vx = (int) 1.5;
	private int vy = (int) (Math.random() * 4) + 3;
	private boolean alive = true;
	private Image Alien = new Image("Alien.jpg");
	
	public Ship(int x, int y, int s) {
		this.x = x;
		this.originalx = x;
		this.y = y;
		this.s = s;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(Alien, x, y, s, s/1.5);
	}
	
	public void move() {
		this.y = this.y + vy;
		this.x = this.x + vx;
		
		if (x > originalx+10 || x < originalx-10) {
			vx = -vx;
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

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
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
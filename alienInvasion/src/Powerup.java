import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Powerup {
	private int x;
	private int y;
	private int width;
	private int height;
	private int mode;
	private boolean isAlive = true;

	private Image Ammo = new Image("Ammo.png");

	public Powerup(int x, int y, int width, int height, int mode) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.mode = mode;
	}

	public void draw(GraphicsContext gc) {
		if (mode == 1) {
			gc.drawImage(Ammo, x, y - 40, width, height);
		}

		if (mode == 2) {

		}
	}

	public boolean didHit(Missile m) {
		double mx = m.getxPos() + (m.getDiameter() / 2);
		double my = m.getyPos() + (m.getDiameter() / 2);
		double tx = this.x + (this.width / 2);
		double ty = this.y + (this.height / 2);

		return Math.abs(mx - tx) < (m.getDiameter() + this.width) / 2
				&& Math.abs(my - ty) < (m.getDiameter() + this.height / 2);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
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

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
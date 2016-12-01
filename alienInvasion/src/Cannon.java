import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Cannon {
	private int x;
	private int y;
	private double angle;
	private int barrelx;
	private int barrely;
	private int barrelh = 100;
	private int barrelw = 40;
	private int width;
	private int height;
	private Image barrel = new Image("GunBarrel.png");

	public Cannon(int x, int y, int width, int height, double angle) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.angle = angle;
	}

	public Cannon(double angle) {
		x = 800;
		y = 700;
		this.angle = angle;
		width = 800;
		height = 800;
	}

	public int getbX() {
		return barrelx;
	}

	public int getbY() {
		return barrely;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return height;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Missile shoot() {
		double setangle = 10;
		double setdiameter = 10;
		double setspeed = 10;
		Missile m = new Missile(x, y, setdiameter, setangle, setspeed);
		{
			barrelx = x;
			barrely = y;
			angle = setangle;
			return m;
		}

	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(GraphicsContext gc) {
		gc.save();
		gc.translate(x, y);
		gc.rotate(angle);
		gc.restore();

		gc.drawImage(barrel, x, y - 40, barrelw, barrelh);
		gc.setFill(Color.RED);
		gc.fillRect(x, y, height, width);
	}
}
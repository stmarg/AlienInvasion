import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Building class represents the idea of a building in the Alien Invasion game
 * @author Julia
 * @author Madison
 *
 */
public class Building 
{
	private int x;
	private int y;
	private int s;
	private Color bcolor;
	private Color tcolor;
	private boolean alive = true;

	public Building(int x, int y, int s, Color bcolor, Color tcolor) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.bcolor = bcolor;
		this.tcolor = tcolor;
	}

	public void draw(GraphicsContext gc) 
	{
		gc.setFill(tcolor);
		gc.fillRect(x, y, s, s);
		gc.fillRect(x + s / 6, y - s / 3, s / 1.8, s / 3);
		gc.fillRect(x + s / 4.2, y - s / 3 - s / 5, s / 4, s / 5);
		gc.setFill(bcolor);
		gc.fillRect(x + s / 3, y + s / 4, s / 3, s - s / 4);
	}

	public boolean checkHit(Ship s) {
		// if (this.x > x + s.x && this.x + s.x < x && this.y < y + s.y && alive == true) {
		// return true;
		// }

		return false;
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

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

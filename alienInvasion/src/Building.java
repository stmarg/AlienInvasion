import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Building class represents the idea of a building in the Alien Invasion
 * game
 * 
 * @author Julia
 * @author Madison
 *
 */
public class Building {
	private int x;
	private int y;
	private int size;
	private Color bcolor;
	private Color tcolor;
	private boolean alive = true;

	public Building(int x, int y, int size, Color bcolor, Color tcolor) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.bcolor = bcolor;
		this.tcolor = tcolor;
	}

	public void draw(GraphicsContext gc) {
		if (alive == true) {
			gc.setFill(tcolor);
			gc.fillRect(x, y, size, size);
			gc.fillRect(x + size / 6, y - size / 3, size / 1.8, size / 3);
			gc.fillRect(x + size / 4.2, y - size / 3 - size / 5, size / 4, size / 5);
			gc.setFill(bcolor);
			gc.fillRect(x + size / 3, y + size / 4, size / 3, size - size / 4);
		}
		else
		{ 
			gc.setFill(Color.BLACK);
			gc.fillRect(x, y, size, size);
		}
	}

	public boolean checkHit(Ship s) {
		return s.didHit(this);
	}

	public void explode(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, y, size, size);
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
		return size;
	}

	public void setS(int size) {
		this.size = size;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

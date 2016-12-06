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
	private int time;

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
		} else {

			if (time < 100) {
				time++;
				gc.setFill(tcolor);
				gc.fillRect(x + size / 2, y - size / 3, size / 4, size / 3);
				if (time < 80) {
					gc.fillRect(x + size / 4, y - size / 5, size / 5, size / 4);
					if (time < 70) {
						gc.fillRect(x - size / 3, y + size / 10, size / 3, size / 5);
						if (time < 60) {
							gc.fillRect(x + size / 7, y + size / 9, size / 6, size / 5);
							if (time < 50) {
								gc.fillRect(x + size / 12, y + size / 11, size / 4, size / 3);
								if (time < 40) {
									gc.fillRect(x - size / 15, y - size / 8, size / 6, size / 4);
									if (time < 30) {
										gc.fillRect(x - size / 2, y - size / 12, size / 4, size / 2);
										if (time < 20) {
											gc.fillRect(x, y - 1.5 * size, size / 4, size / 3);
											if (time < 10) {
												gc.fillRect(x - size / 2, y - 1.15 * size, size / 6, size / 4);
											}
										}
									}
								}
							}
						}
					}
				}
				// gc.fillRect(x + size/3, y - size/8, size/3, size/2);
				// gc.fillRect(x + size/1.5, y - size/1.5, size/2, size/2);
				// gc.fillRect(x + size/1.5, y - size/2, size/3, size/2);
			}

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

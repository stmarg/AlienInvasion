import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class Juliagame extends SimpleApp {
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[10];
	ArrayList<Missile> bullets = new ArrayList<>();

	// Don't have both arrays and single variables. Use arrays when you have
	// many things (like buildings and ships), use single variables when you
	// have only one thing...like a cannon.
	// Your program is crashing because you are using this single ship variable
	// when you should be using the array.
	// private Ship s;
	// private Building b;
	// private Missile m;
	private Cannon c;

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) {
		for (Ship s : ships) {
			s.draw(gc);
			s.move();

			// if(s.getY() < getHeight())
			// {
			// s.draw(gc);
			// }

		}

		for (int i = 0; i < buildings.length; i++) {
			buildings[i].draw(gc);

			// }
 
			// for (Building b : buildings)
			// {
			for (Ship s : ships) {
				if (s.didHit(buildings[i]) == true) {
					// if (buildings[i].checkHit(s) == true)
					{
						gc.setFill(Color.GREEN);
						gc.fillText("Building Hit", getWidth() / 2, getHeight() / 2);

						buildings[i].explode(gc);

					}
				}
			}

			for (Missile m : bullets) {

			}

			c.draw(gc);
		}
	}

	public void setupApp(GraphicsContext gc) {
		for (int i = 0; i < buildings.length; i++) {

			buildings[i] = new Building((int) (getWidth() * (.14 * (i + 1))), getHeight() - 25, 50, Color.BLUE,
					Color.BLUE);
		}

		for (int k = 0; k < ships.length; k++) {
			ships[k] = new Ship(50 + k * 150, 50, 100, (int) (100 / 1.5), k);
		}

		c = new Cannon(getWidth() / 2 - 1, getHeight() - 90, 90, 50, 90);
	}

	public static void main(String[] args) {
		launch();
	}
}

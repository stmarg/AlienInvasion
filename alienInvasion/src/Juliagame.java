import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class Juliagame extends SimpleApp {
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[7];
	ArrayList<Missile> bullets = new ArrayList<>();

	
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

			
			for (int j = 0; j < ships.length; j++) {
			//for (Ship s : ships) {
				if (ships[j].didHit(buildings[i]) == true) {
					
					{
						gc.setFill(Color.GREEN);
						gc.fillText("Building Hit", getWidth() / 2, getHeight() / 2);

						buildings[i].setAlive(false);

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
			ships[k] = new Ship(50 + k * 150, 50, 100, (int) (100 / 1.5), 1);
		}

		c = new Cannon(getWidth() / 2 - 1, getHeight() - 90, 90, 50, 90);
	}

	public static void main(String[] args) {
		launch();
	}
}

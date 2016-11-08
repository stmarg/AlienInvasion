import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class KevinGame extends SimpleApp {
	// private Cannon c;
	private Building b1;
	private Building b2;

	private int score = 0;
	private boolean hi = false;

	Ship[] ships = new Ship[3];
	Building[] buildings = new Building[4];

	public static void main(String[] args) {
		launch();
	}

	public void updateAnimation(long arg0) {
		
	}

	public void draw(GraphicsContext gc) {
		// c.draw(gc);

		for (Ship s : ships) {
			s.draw(gc);
			s.move();
		}
		
		gc.fillText("Score: " + score, getWidth() - getWidth()/8, getHeight()/8);
		
		for (int i = 0; i < ships.length; i++) {
			if (ships[i].getY() > 900) {
				ships[i].setY(-50);
				ships[i].setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				ships[i].setOriginalx(ships[i].getX());
				ships[i].setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
				score++;
			}
			//ships[i].remove();
		}

		for (Building b : buildings) {
			b.draw(gc);
		}

		if (hi == true) {
			// c.rotate(gc);
			hi = false;
		}
	}

	public void setupApp(GraphicsContext arg0) {
		// c = new Cannon(getWidth() / 2 - 20, getHeight() - 50, 40);

		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship(50 + i * 150, 50, 100);
		}

		for (int i = 0; i < buildings.length; i++) {
			buildings[i] = new Building((getWidth() / 4 + i * 300) - 110, getHeight() - 40, 40, Color.CORNFLOWERBLUE,
					Color.DARKBLUE);
		}
	}

	public void onMousePressed(MouseEvent me) {
		hi = true;
	}
}
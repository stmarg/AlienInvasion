import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class kevingame extends SimpleApp {
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

		for (int i = 0; i < ships.length; i++) {
			ships[i].draw(gc);
			ships[i].move();
		}

		for (int i = 0; i < buildings.length; i++) {
			buildings[i].draw(gc);
		}

		if (hi == true) {
			// c.rotate(gc);
			hi = false;
		}
	}

	public void setupApp(GraphicsContext arg0) {
		// c = new Cannon(getWidth() / 2 - 20, getHeight() - 50, 40);

		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship(50 + i * 150, 50, 100, 100);
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
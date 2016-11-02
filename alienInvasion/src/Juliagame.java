import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class Juliagame extends SimpleApp {
	Building[] buildings = new Building[6];
	

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) {
		for (Building b : buildings) {
			b.draw(gc);
		}

	}

	public void setupApp(GraphicsContext gc) {

		/*
		 * buildings[1] = new Building(getWidth()/4, getHeight()-25, 50, 1);
		 * buildings[2] = new Building(getWidth()*3/4, getHeight()-25, 50, 2);
		 * buildings[3] = new Building(getWidth()*5/6, getHeight()-25, 50,1);
		 * buildings[4] = new Building(getWidth()/6, getHeight()-15, 50, 2);
		 * buildings[5] = new Building(getWidth()/3, getHeight()-15, 50, 3);
		 * buildings[6] = new Building(getWidth()*2/3, getHeight()-25, 50, 3);
		 */

		for (int i = 0; i < buildings.length; i++) 
		{
			int x = (int) (getWidth() * (.15 * (i + 1)));
			int y = getHeight() - 25;

			buildings[i] = new Building(x, y, 50, Color.BLUE, Color.BLUE);
		}

		
	}

	public static void main(String[] args) {
		launch();
	}

}

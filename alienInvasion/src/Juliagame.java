import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class Juliagame extends SimpleApp {
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[3];
	
	private Ship s; 
	private Building b; 
	

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) 
	{
		
		for (int i = 0; i < buildings.length; i++) {
			buildings[i].draw(gc);
		}
		for (Building b : buildings) 
		{
			if (b.checkHit(s) == true) 
			{
				gc.fillText("Building Hit", getWidth() / 2, getHeight() / 2);
			}
		} 

		for (Ship s : ships) 
		{
			s.draw(gc);
			s.move();
		}
			
	}

	public void setupApp(GraphicsContext gc) 
	{
		for (int i = 0; i < buildings.length; i++) 
		{

			buildings[i] = new Building((int) (getWidth() * (.15 * (i + 1))), getHeight() - 25, 50, Color.BLUE, Color.BLUE);
		}
		
		for (int i = 0; i < ships.length; i++)
		{ 
			ships[i] = new Ship(50 + i *150, 50, 100, (int) (100/1.5), i);
		}
	}

	public static void main(String[] args) {
		launch();
	}
}

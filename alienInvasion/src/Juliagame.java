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
		//b.draw(gc);
		//s.draw(gc); 
		//s.move(); 
		
		for (int i = 0; i < buildings.length; i++) {
			buildings[i].draw(gc);
		}
		
		for (int i = 0; i < ships.length; i++)
		{ 
			ships[i].draw(gc); 
			ships[i].move(); 
		}
	}

	public void setupApp(GraphicsContext gc) 
	{
		for (int i = 0; i < buildings.length; i++) 
		{
			//int x = (int) (getWidth() * (.15 * (i + 1)));
			//int y = getHeight() - 25;

			buildings[i] = new Building((int) (getWidth() * (.15 * (i + 1))), getHeight() - 25, 50, Color.BLUE, Color.BLUE);
		}
		
		for (int i = 0; i < ships.length; i++)
		{ 
			ships[i] = new Ship(100,100,100,100); 
		}

		//for (int i = 0; i < ships.length; i ++)
		//{ 
			//ships[i] = new Ship(10,10,100,100); 
		//}
		//ships[1] = new Ship(10,10,100,100); 
		
		
	}

	public static void main(String[] args) {
		launch();
	}
}

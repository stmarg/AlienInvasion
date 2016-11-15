import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class MadisonGame extends SimpleApp 
{
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[3];
	Cannon[] cannon = new Cannon[1];
	
	private Ship s; 
	private Building b; 
	private Cannon c;

	public void updateAnimation(long arg0) 
	{

	}

	public void draw(GraphicsContext gc) 
	{
		for (Building b : buildings) 
		{
			b.draw(gc);
		}
		
		for (Ship s: ships) 
		{ 
			s.draw(gc); 
			s.move(); 
		}
		
		for (Cannon c: cannon)
		{
			c.draw(gc);
		}

	}

	public void setupApp(GraphicsContext gc) 
	{
		for (int i = 0; i < buildings.length; i++) 
		{
			int x = (int) (getWidth() * (.15 * (i + 1)));
			int y = getHeight() - 25;

			buildings[i] = new Building(x, y, 50, Color.CRIMSON, Color.CRIMSON);
		}

		
		for (int i = 0; i < ships.length; i++)
		{ 
			ships[i] = new Ship(50 + i *150, 50, 100, (int) (100/1.5), i);
		}
		
		for (int i = 0; i < cannon.length; i++)
		{
			cannon[i] = new Cannon(x, y, 50, Color.BLACK, Color.BLACK);
		}

		
	}

	public static void main(String[] args) {
		launch();
	}

}
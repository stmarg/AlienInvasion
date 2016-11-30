import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.Drawable;
import tsinn.ui.SimpleApp;

public class Juliagame extends SimpleApp {
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[3];
	ArrayList <Missile> bullets = new ArrayList<> ();
	
	
	//Don't have both arrays and single variables. Use arrays when you have many things (like buildings and ships), use single variables when you have only one thing...like a cannon.
	//Your program is crashing because you are using this single ship variable when you should be using the array.
	//private Ship s; 
	//private Building b; 
	//private Missile m; 
	private Cannon c; 
	

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) 
	{
		
		for (int i = 0; i < buildings.length; i++) {
			buildings[i].draw(gc); 
		//}
		
		//for (Building b : buildings) 
		//{
			for (Ship s : ships) 
			{
				if (buildings[i].checkHit(s) == true) 
				{
					gc.fillText("Building Hit", getWidth() / 2, getHeight() / 2);
				}
			}
		} 

		for (Ship s : ships) 
		{
			s.draw(gc);
			s.move();
		}
		
		for (Missile m : bullets)
		{ 
			
		}
		
		c.draw(gc); 
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

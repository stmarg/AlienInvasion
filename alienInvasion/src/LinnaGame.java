import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

//I'm so pleased that my commits actually seem to be working now!!!


//ships aren't drawing??????


public class LinnaGame extends SimpleApp
{
	Building[] buildings = new Building [3];
	Ship[] ships = new Ship [2];
	private Cannon c;
	
	
	@Override
	public void updateAnimation(long arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void draw(GraphicsContext gc)
	{
		// TODO Auto-generated method stub	
		
		for (Building b : buildings)
		{
			
			b.draw(gc);
		}
		
		for (Ship s: ships)
		{
			s.draw(gc);
			s.move();
		}
		
		c.draw(gc);
	}
	@Override
	public void setupApp(GraphicsContext arg0)
	{
		// TODO Auto-generated method stub	
		for (int i = 0; i < buildings.length; i++)
		{
			buildings[i] = new Building((getWidth() / 4 + i * 420) - 110, getHeight() - 40, 60, Color.CYAN,
					Color.ROYALBLUE);
			//At first I thought it wasn't drawing.. then I realized the colors were just too light XD
		}
		for (int i = 0; i < ships.length; i++)
		{
			int x = (int)((Math.random()*getWidth())+1);
			ships[i] = new Ship(x, getHeight(), 40, 40, 1);
			ships[i].setSpeed(7, (int)(Math.random()*20));
			//Give the new ships an initial Y speed.
			//Is this what you meant? It's still not drawing for me, so...
			
		}
		c = new Cannon (getWidth()/2, getHeight()-20, 60, 60, 0);
		
	}
	
	public void onMousePressed(MouseEvent m)
	{
		c.shoot();
	}
	
	
	public static void main (String[] args)
	{
		launch();
	}
}
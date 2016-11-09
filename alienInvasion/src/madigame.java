import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class madigame extends SimpleApp {

	Ship[] ships = new Ship [10];
	Building[] buildings = new Building[6];
	
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		for (int i=0; i< ships.length; i++)
		{
		//	ships[i] = new Ship((int)(Math.random()*getWidth()), (Math.random()* -(getHeight()*2)), 100, 100);
			//ships[i].setSpeed(0, (Math.random()*10));
			ships[i].setSpeed(0, 1);
			if (ships[i].getY() > getHeight()) 
			{
				ships[i].setY(-50);
			}
		}
		
		for (int i = 0; i < buildings.length; i++) 
		{
			int x = (int) (getWidth() * (.15 * (i + 1)));
			int y = getHeight() - 25;

			buildings[i] = new Building(x, y, 50, Color.RED, Color.BLACK);
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i<ships.length; i++)
		{
			ships[i].draw(gc);
			ships[i].move();
		}
		
		for (Building b : buildings) 
		{
			b.draw(gc);
		}
		
	}
	public static void main (String[] args)
	{
		launch();
	}
	
}
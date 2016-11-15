import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class CharlieGame extends SimpleApp
{
	boolean test = false;
	int ammo = 100;
	double angle;
	
	Missile[] bullets = new Missile[ammo];
	
	Building[] buildings = new Building[6];
	
	int count = 0;
	
	
	
	public void onKeyPressed(KeyEvent ke)
	{
		
		if (ke.isAltDown() == true)
		{
			this.angle = this.angle + 10;
		}
		
		
		if (ke.isShiftDown() == true)
		{
			
			Missile M = new Missile(angle); 
			
			test = true;
			count = count + 1;
		}
		
		
	}
	
	

	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		if (M != null)
		{
			M.draw(gc);
		}
		
		
		for (int i = 1; i < buildings.length; i++)
		{
			buildings[i].draw(gc);
		}
		
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
		/*for (int i = 0; i < bullets.length; i++)
		{
			bullets[i] = new Missile(10*i);
		}*/
		
		for (int i = 0; i < buildings.length; i++)
		{
			buildings[i] = new Building(getWidth() * i / 6, getHeight() - 50, 50, Color.BEIGE, Color.BURLYWOOD);
		}
		
		
		
		
		
	}
	
	
	
	public static void main (String [] args)
	{
		launch();
	}
	
}
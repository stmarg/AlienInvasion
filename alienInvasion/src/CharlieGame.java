import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class CharlieGame extends SimpleApp
{
	
	//boolean test = false;
	//int count = -1;
	
	int ammo = 0;
	double angle = 90;
	
	//Missile[] bullets = new Missile[ammo];
	
	Missile[] bullets = new Missile[10];
	
	Building[] buildings = new Building[6];
	
	//ArrayList<Missile> missiles = new ArrayList<>();
	
	Missile M = null;
	
	
	
	
	public void onKeyPressed(KeyEvent ke)
	{
		
		if (ke.isControlDown() == true)
		{
			this.angle = this.angle + 22.5;
		}
		
		if (ke.isAltDown() == true)
		{
			this.angle = this.angle - 22.5;
		}
		
		
		if (ke.isShiftDown() == true)
		{
			
			M = new Missile(angle);
			
			//bullets = new Missile[ammo];
			
			/*for (int i = 0; i < bullets.length; i++)
			{
				bullets[i] = new Missile(22.5 * i);
			}*/
			
			ammo += 1;
			
			
			//test = true;
			//count += 1;
			
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
			
			if (M.getyPos() + M.getDiameter() < 0)
			{
				M = null;
			}
		}
		
		for (int i = 0; i < ammo; i++)
		{
			bullets[i].draw(gc);
		}
		
		
		
		
		
		
		
		
		
		/*if (test == true)
		{
			if (count >= 0)
			{
				bullets[0].draw(gc);
			}
			if (count >= 1)
			{
				bullets[1].draw(gc);
			}
			if (count >= 2)
			{
				bullets[2].draw(gc);
			}
			if (count >= 3)
			{
				bullets[3].draw(gc);
			}
			if (count >= 4)
			{
				bullets[4].draw(gc);
			}
			
		}*/
		
		
		
		for (int i = 1; i < buildings.length; i++)
		{
			buildings[i].draw(gc);
		}
		
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
		
		
		for (int i = 0; i < buildings.length; i++)
		{
			buildings[i] = new Building(getWidth() * i / 6, getHeight() - 50, 50, Color.BLACK, Color.BURLYWOOD);
		}
		
		
		
		
		
	}
	
	
	
	public static void main (String [] args)
	{
		launch();
	}
	
}
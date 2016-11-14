import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class CharlieGame extends SimpleApp
{
	boolean test = false;
	int ammo = 100;
	
	Missile[] bullets = new Missile[ammo];
	
	Building B = new Building(400, 400, 50, Color.BLUE, Color.BEIGE);
	
	Missile M = new Missile(400, 700, false, 50);
	
	
	
	public void onKeyPressed(KeyEvent ke)
	{
		if (ke.isShiftDown() == true)
		{
			test = true;
			ammo = ammo + 1;
		}
	}
	
	

	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		
		B.draw(gc);
		
		if (test == true)
		{
			M.drawAndShoot(gc, 3, 90);
			
			bullets[0].drawAndShoot(gc, 4, 45);
			
		}
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < bullets.length; i++)
		{
			bullets[i] = new Missile(400, 700, false, 50);
		}
		
	}
	
	
	
	public static void main (String [] args)
	{
		launch();
	}
	
}
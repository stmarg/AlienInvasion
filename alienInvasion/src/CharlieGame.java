import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class CharlieGame extends SimpleApp
{
	boolean test = true;
	
	Missile[] bullets = new Missile[5];
	
	Building B = new Building(400, 400, 50, Color.BLUE, Color.BEIGE);
	
	Missile M = new Missile(400, 700, false, 50);
	
	public void onMousePressed(MouseEvent me)
	{	
		
		if (me.getX() > 0 && me.getY() > 0)
		{
			test = false;
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
		M.draw(gc);
		if (test = true)
		{
			M.shoot(3, 90);
		}
		
		
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	public static void main (String [] args)
	{
		launch();
	}
	
}
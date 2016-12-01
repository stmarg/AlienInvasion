import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;


public class JasonGame extends SimpleApp {
	
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[3];
	ArrayList <Missile> bullets = new ArrayList<> ();
	private Cannon c ;
	double angle = 90 ;
	

	public void onKeyPressed(KeyEvent ke)
	{
		// if left 
	}
		
	public void setupApp(GraphicsContext gc) 
	{
		for (int i = 0; i < buildings.length; i++) 
		{

			buildings[i] = new Building((int) (getWidth() * (.25 * (i + 1))), getHeight() - 25, 50, Color.BLACK, Color.BLACK);
		}
		
		for (int i = 0; i < ships.length; i++)
		{ 
			ships[i] = new Ship(50 + i *150, 50, 100, (int) (100/1.5), i);
		}
	}
	//score
	//angle
	//
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void updateAnimation(long arg0) {

	}

	@Override
	public void draw(GraphicsContext gc) {
		
		
	}
}
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
	int ammo = 100 ;
	private Cannon c;
	double angle = 90 ;
	

	public void onMouseMove (MouseEvent me)
	{
		
		c.setAngle(angle);
	}
	public void onMousePressed(MouseEvent me) 
	{
		
	}
		
	public void onMouseReleased(MouseEvent m) {
		c.shoot();
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
	
	public static void main(String[] args) {
		launch();
	}
	

	public void updateAnimation(long arg0) {

	}

	
	public void draw(GraphicsContext gc) {
		c.draw(gc);
		for (int i = 0; i < buildings.length; i++){
			
		}
		for (int i = 0; i < ships.length; i++){
			ships[i].draw(gc);
			ships[i].move();
		}
		
	}
}
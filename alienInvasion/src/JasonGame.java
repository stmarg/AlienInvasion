import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

//you are getting a null pointer because you never create c.
//currently, c is null
public class JasonGame extends SimpleApp {
	
	Building[] buildings = new Building[6];
	Ship[] ships = new Ship[3];
	ArrayList <Missile> bullets = new ArrayList<> ();
	private Cannon c;
	private double ammo = 100 ;
	private double score = 0;
	private double health = 100;
	private boolean alive = true;
	double angle = 90 ;
	

	public void onMouseMove (MouseEvent me)
	{
		double radian = Math.atan2(c.getY()-me.getY(), me.getX()-c.getX());
		double degrees = (180*radian/3.14159);
		c.setAngle(degrees);
	}
	public void onMousePressed(MouseEvent me) 
	{
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
	public void collision(){
	
	}

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) {
		//draw cannon
		c.draw(gc);
		//draw buildings
		for (int i = 0; i < buildings.length; i++){
			buildings[i].draw(gc);
		}
		//draw ships
		for (int i = 0; i < ships.length; i++){
			ships[i].draw(gc);
			ships[i].move();
		
		if (alive == true){
			gc.setFill(Color.BLACK);
			gc.setFont(javafx.scene.text.Font.font(20));
			//draw ammo count
			gc.fillText("Missles:"+ ammo, 0, -50);
			//draw lives left
			gc.fillText("Health:"+ health,0,-70);
			//draw score
			gc.fillText("Score" + score, 0, -90);
		}
		if (health == 0){
			alive = false ;
			gc.fillText("GAME OVER", getWidth()/2, getHeight()/2);
			gc.fillText("Your final score was" + score, getWidth()/2,(getHeight()/2)-20);
		}
		
		{
		
		}
	}
}
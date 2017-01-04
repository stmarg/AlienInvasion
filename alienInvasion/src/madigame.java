import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class madigame extends SimpleApp 
{
	// Variables
	private int score = 100;
	int angle = 0;
	// Classes
	private Ship[] ships = new Ship[10];
	private Building[] buildings = new Building[6];
	private Cannon c;
	private boolean shooting = false;
	double kill_count = 0;
	double difficulty = 2;
	ArrayList<Missile> bullets = new ArrayList<>();
	Media hit = new Media("Pan.mp3");
		MediaPlayer hitplayer = new MediaPlayer(hit);
	

	// Angle
	public void onMouseMove(MouseEvent me) 
	{
		double radians = Math.atan2(c.getY() - me.getY(), -c.getX() + me.getX());
		double angle = Math.toDegrees(radians);
		if (angle>=0 && angle<= 180)
		{
		c.setAngle(angle);
		}
	}
	
	//Shoot
	
	public void onMousePressed(MouseEvent me) 
	{
		shooting = true;
		bullets.add(new Missile(c.getX(), c.getY(), 10, c.getAngle(), 15));
	}

	public void updateAnimation(long arg0) 
	{
		// TODO Auto-generated method stub
	}

	// Sets up arrays
	public void setupApp(GraphicsContext arg0) 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < ships.length; i++) 
		{
			ships[i] = new Ship((int) (Math.random() * getWidth()-100), (int) (Math.random() * -(getHeight() * 2)), 100,
					100, 1);
			//ships[i].setSpeed(0, (int) (Math.random() * difficulty + 1));
		}

		for (int j = 0;j < buildings.length; j++) 
		{
			int x = (int) (getWidth() * (.15 * (j + 1)));
			int y = getHeight() - 25;

			buildings[j] = new Building(x, y, 50, Color.RED, Color.BLACK);
		}

		c = new Cannon((getWidth() / 2) + 30,  getHeight()-60, 200, 100, angle);
		
	}

	// This function draws the game provided that you are alive
	@Override
	public void draw(GraphicsContext gc) 
	{
		// TODO Auto-generated method stub
		if (score >= 0) 
		{
			//Cannon
			c.draw(gc);
			//Ships and buildings 
			for (int j = 0; j < buildings.length; j++) 
			{
				buildings[j].draw(gc);
			}
			for (Missile m : bullets) 
			{
				if (shooting == true) 
				{
					m.draw(gc);
				}
				if (m.getxPos() > getWidth() && m.getxPos() < 0 && m.getyPos() > getHeight() && m.getyPos() < 10) 
				{
					bullets.remove(m);
				}
			}
			for (int i = 0; i < ships.length; i++) 
			{
				ships[i].draw(gc);
				ships[i].move();
				if (ships[i].getY() > getHeight()) 
				{
					ships[i].setY(-100);
				}
				ships[i].setSpeed(0, (int) (Math.random() * difficulty + 1));
				
				for (int j = 0; j < buildings.length; j++) 
				{
				//	buildings[j].draw(gc);

					if (ships[i].didHit(buildings[j]) == true) 
					{
						ships[i].setY(-100);
						score -= 5;
						
					}
				}
				for (Missile m : bullets) 
				{
					//if (shooting == true) 
					//{
						//m.draw(gc);
					//}

					//if (m.getxPos() > getWidth() && m.getxPos() < 0 && m.getyPos() > getHeight() && m.getyPos() < 10) 
					//{
						//bullets.remove(m);
					//}
					
					if (m.didHit(ships[i]) == true)
					{
						ships[i].setY(-100);
						ships[i].setX(Math.random() * getWidth());
						kill_count += 1;
						bullets.remove(m);
						hitplayer.play();
					}
				}
				
			}
			if (kill_count > 10)
			{
				kill_count = 0;
				difficulty += 0.75;
				//System.out.println( difficulty);
			}
			c.draw(gc);
			gc.setFill(Color.CRIMSON);
			gc.fillRect((getWidth()/2)+5, getHeight()-52, 50, 50);
			//System.out.println(difficulty);
			gc.setFill(Color.GREEN);
			gc.setFont(javafx.scene.text.Font.font(50));
			String scoreL = "" + score;
			gc.fillText(scoreL, getWidth() / 15, getHeight() / 8);
		} 
		else 
		{
			gc.setFont(javafx.scene.text.Font.font(100));
			gc.setFill(Color.FIREBRICK);
			gc.fillText("You LOSE!", (getWidth() / 2), getHeight() / 2);
		}
	}

	public static void main(String[] args) 
	{
		launch();
	}
}
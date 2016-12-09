import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;
import java.util.ArrayList;

public class CharlieGame extends SimpleApp
{
	
	double count = 60;
	double limit = 0;
	boolean paused = false;
	boolean playing = false;
	double missilesfired = 0;
	double collisions = 0;
	
	Building[] buildings = new Building[16];
	
	ArrayList <Missile> missiles = new ArrayList<> ();
	
	ArrayList <Ship> ships = new ArrayList<> ();
	
	Cannon C = new Cannon(700, 800, 100, 100, 90);
	
	int lives = 10;
	
	
	public void onMouseMove(MouseEvent me)
	{
		double radian = Math.atan2(C.getY()-me.getY(), me.getX()-C.getX());
		double degree = radian*180/3.1416;
		C.setAngle(degree);
	}
	
	public void onKeyPressed(KeyEvent ke)
	{
		/*if (ke.isControlDown() == true)
		{
			C.setAngle(C.getAngle() + 22.5);
			//this.angle = this.angle + 22.5;
		}
		
		if (ke.isAltDown() == true)
		{
			C.setAngle(C.getAngle() - 22.5);
			//this.angle = this.angle - 22.5;
		}*/
		
		if (ke.isShiftDown() == true && playing == true)
		{
				
			missiles.add(new Missile(C.getX(), C.getY(), 50, C.getAngle(), 20, Color.BLACK));
			//missiles.add(C.shoot());
			missilesfired++;
			//playing = true;

		}
		
		if (ke.isControlDown() == true)
		{
			if (playing == true)
			{
				paused = true;
			} else if (paused == true)
			{
				paused = false;
			} else
			{
				playing = true;
				missilesfired = 0;
				collisions = 0;
				count = 0;
			}
			
		}
		
	}
	
	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		if (playing && !paused)
		{
		
		count++;
		
		if (count >= limit)
		{
			ships.add(new Ship((int)(this.getWidth() * Math.random()), 0, 100, 100));
			limit = limit + (int)((100 - count/30) * Math.random());
		}
		
		gc.fillText("Lives: " + lives, 50, 50);
		
		gc.fillText("Accuracy: " + 100 * collisions/missilesfired + "%", 50, 100);
		
		C.draw(gc);	
		
		if (lives <= 0)
		{
			playing = false;
		}
		
		for (Ship s : ships)
		{
			s.draw(gc);
			s.move();
		}
		
		for (Missile m : missiles)
		{
			if (m.isActive())
			{
				m.draw(gc);
				//m.fall(.5);
			}

		}
		
		for (int i = 1; i < buildings.length; i++)
		{
			buildings[i].draw(gc);
		}
		
		this.CollisionDetection();
		
		}
		else if (paused == true)
		{
			gc.fillText("PAUSED", getWidth()/2, getHeight()/2);
		}
		else
		{
			gc.setFill(Color.BLACK);
			gc.setFont(javafx.scene.text.Font.font(20));
			gc.fillText("GAME OVER", getWidth()/2, getHeight()/2);
			gc.fillText("You lasted: " + (int)(Math.floor(count/60)) + " seconds", getWidth()/2, getHeight()/2 + 50);
			gc.fillText("Accuracy: " + (int)(100 * collisions/missilesfired) + "%", getWidth()/2, getHeight()/2 + 100);
			gc.fillText("press control for a new game, control to pause, and shift to shoot", getWidth()/2 - 300, getHeight()/2 + 200);
			
			lives = 10;
			limit = 60;
			
			for (Missile m : missiles)
			{
				missiles.remove(m);
			}
			
			for (Ship s : ships)
			{
				ships.remove(s);
			}
			
			for (int b = 0; b < buildings.length; b++)
			{
				buildings[b].setAlive(true);
			}
			
		}
	}	
	
	public void CollisionDetection()
	{
		
			for (int k = 0; k < ships.size(); k++)
			{

				for (int j = 0; j < buildings.length; j++)
				{
					if (ships.get(k).didHit(buildings[j]))
					{
						ships.remove(k);
						buildings[j].setAlive(false);
						lives--;
						k--;
					}
				}
				
				for (int i = 0; i < missiles.size(); i++)
				{
					if (missiles.get(i).didHit(ships.get(k)))
					{
						missiles.get(i).setInactive(true);
						missiles.remove(i);
						ships.remove(k);
						collisions++;
						i--;
						//break;
					}
					
				}
				
			}	
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < buildings.length; i++)
		{
			buildings[i] = new Building(getWidth() * i / buildings.length, getHeight() - 50, 50, Color.BLACK, Color.BURLYWOOD);
		}
		
	}
	
	public static void main (String [] args)
	{
		launch();
	}
	
}



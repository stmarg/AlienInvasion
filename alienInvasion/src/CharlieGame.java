import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;
import java.util.ArrayList;

public class CharlieGame extends SimpleApp
{
	
	//boolean test = false;
	double count = 0;
	
	//double angle = 90;
	
	//Missile[] bullets = new Missile[ammo];
	
	//Missile[] bullets = new Missile[10];
	
	Building[] buildings = new Building[16];
	
	ArrayList <Missile> missiles = new ArrayList<> ();
	
	ArrayList <Ship> ships = new ArrayList<> ();
	
	//Missile M = null;
	
	Cannon C = new Cannon(700, 800, 100, 100, 90);
	
	int lives = 16;
	
	
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
		
		if (ke.isShiftDown() == true)
		{
			
			//M = new Missile(C.getX(), C.getY(), 50, angle, 4);
			
			//bullets = new Missile[ammo];
			
			/*for (int i = 0; i < bullets.length; i++)
			{
				bullets[i] = new Missile(22.5 * i);
			}*/
			
			
			missiles.add(new Missile(C.getX(), C.getY(), 50, C.getAngle(), 4, Color.BLACK));
			//missiles.add(C.shoot());
			
			//ships.add(new Ship(600, 100, 100, 100));
			
			
			
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
		
		count = count + (int)(10 * Math.random());
		
		
		/*if (M != null)
		
		//Why are you using M and missiles?
		if (M != null)
		{
			M.draw(gc);
			
			if (M.getyPos() + M.getDiameter() < 0)
			{
				M = null;
			}
		}*/
		
		/*for (int i = 0; i < ammo; i++)
		{
			bullets[i].draw(gc);
		}*/
		
		
		if (count % 150 == 0)
		{
			ships.add(new Ship((int)(this.getWidth() * Math.random()), 0, 100, 100));
		}
		
		
		
		
		
		
		
		C.draw(gc);
		
		
		
		for (int i = 0; i < missiles.size(); i++)
		{
			Missile m = missiles.get(i);
			
			m.fall();
			
			if (m.getyPos() < -m.getDiameter())
			{
				missiles.remove(m);
			}
		
			if (m.isActive())
			{
			m.draw(gc);
			
			for (int k = 0; k < ships.size(); k++)
			{
				Ship s = ships.get(k);
			
				if (m.didHit(s))
				{
					m.setInactive(true);
					
					ships.remove(k);
					
					break;
				}
				
				for (int j = 0; j < buildings.length; j++)
				{
					
					if (s.didHit(buildings[j]))
					{
						ships.remove(k);
						buildings[j].setAlive(false);
						lives--;
					}
				}
				
			
			}
			
			}
			
		}
		
		if (lives == 0)
		{
			gc.fillText("GAME OVER", this.getWidth()/2, this.getHeight()/2);
		}
		
		
		
		
		for (Ship s : ships)
		{
			s.draw(gc);
			s.move();
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
			buildings[i] = new Building(getWidth() * i / buildings.length, getHeight() - 50, 50, Color.BLACK, Color.BURLYWOOD);
		}
		
		
		
		
		
	}
	
	
	
	public static void main (String [] args)
	{
		launch();
	}
	
}
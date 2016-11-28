import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class GavinGame extends SimpleApp
{  
	
	private int ammo=50;
	Building[] buildings = new Building[10];
	Ship[] ships = new Ship[4];
	Missile[] bullets = new Missile[ammo];

	//private Ship s;
	//private Building b; 
	
	public static void main(String[] args) {
		launch();
	}
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ships.length; i++) 
		{
			ships[i].draw(gc);
			ships[i].move();
			if (ships[i].getY() > getHeight()) 
			{
				ships[i].setY(-50);
			}
		}
		//Why are you creating an new set of 4 ships 60 times a second? Don't init your array in the draw! Do it in the setup.
		
			//ships[i].draw(gc);
			//ships[i].move();
			//if (ships[i].getY() > getHeight()) 
			//{
				//ships[i].setY(-50);
		//	}
		
		
		//Same here for the buildings
			for (int i = 0; i < buildings.length; i++)
			{
				buildings[i] = new Building((getWidth() / 4 + i * 420) - 110, getHeight() - 40, 60, Color.GREY,
						Color.BLACK);
			}
			/* how to Rotate
			 * push matrix
			 * translate (x,y)
			 * rotate(angle)
			 * drawing(0,0)
			 * pop matrix
			 */
			
			for (Ship s : ships) {
				s.draw(gc);
				s.move();
				s.setSpeed(0, 2);
			}
			
			for (Building b : buildings) {
				b.draw(gc);
			}
		
		}
		
	
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
	   
		//How to to array list..... 
	//	ArrayList<Missle> allMissles ammo = new ArrayList<>();
		
		for (int i = 0; i < ships.length; i++)
		{ 
			//ships[i] = new Ship(50 + i *150, 50,80,85,i);
			ships[i]= new Ship(Math.random()* (getWidth() - getWidth() / 10),50,95,100,1);
			//ships[i].setX((int) (Math.random()* (getWidth() - getWidth())));
		}
	  }

	}
	
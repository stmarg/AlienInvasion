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
			ships[i] = new Ship(50 + i *150, 50, 100, (int) (100/1.5),i);
			ships[i].setX((int) (Math.random()* (getWidth() - getWidth() / 10)));
			
			//ships[i].draw(gc);
			//ships[i].move();
			//if (ships[i].getY() > getHeight()) 
			//{
				//ships[i].setY(-100);
		//	}
		}
		
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
			}
			
			for (Building b : buildings) {
				b.draw(gc);
			}
		
		}
		
	
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
	    /* for(int i=0;i<Building.s;i++){
	    //     Building[i];
	   //  }*/
		
		//How to to array list..... 
	//	ArrayList<Missle> allMissles ammo = new ArrayList<>();
		
	  }

	}
	
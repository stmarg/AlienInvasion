import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class GavinGame extends SimpleApp
{  
	
	private int ammo=50;
	Building[] buildings = new Building[8];
	Ship[] ships = new Ship[4];
	Missile[] bullets = new Missile[ammo];
	
	/*private Ship s;
	private Building b; */
	
	public static void main(String[] args) {
		launch();
	}
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		for (Ship s : ships)
		{
			s.draw(gc);
			s.move();
		}
		
		for (Building b : buildings) 
		{
			b.draw(gc);
		} 
	}
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
	    // for(int i=0;i<Building.s;i++){
	    //     Building[i];
	   //  }
		new Ship((int)(Math.random()*getWidth()), (int) (Math.random()* -(getHeight()*2)), 200, 200, 1);
		
		new Building(x, y, 50, Color.RED, Color.BLACK);
	  }

	}
	
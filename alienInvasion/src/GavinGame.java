import javafx.scene.canvas.GraphicsContext;
import tsinn.ui.SimpleApp;

public class GavinGame extends SimpleApp
{  
	
	Building[] buildings = new Building[8];
	Ship[] ships = new Ship[4];
	
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
	     for(int i=0;i<Building.length;i++){
	         Building[i];
	     }
	  }

	}
	
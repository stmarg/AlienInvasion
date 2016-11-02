import javafx.scene.canvas.GraphicsContext;
import tsinn.ui.SimpleApp;

public class madigame extends SimpleApp {

	Ship[] ships = new Ship [10];
	
	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		for (int i=0; i< ships.length; i++)
		{
			ships[i] = new Ship((int)(Math.random()*getWidth()), (Math.random()* -(getHeight()*2)), 100, 100);
			//ships[i].setSpeed(0, (Math.random()*10));
			ships[i].setSpeed(0, 1);
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i<ships.length; i++)
		{
			ships[i].drawIt(gc);
			ships[i].moveIt();
		}
		
	}
	public static void main (String[] args)
	{
		launch();
	}
	
}
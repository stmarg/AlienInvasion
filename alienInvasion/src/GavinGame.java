import javafx.scene.canvas.GraphicsContext;
import tsinn.ui.SimpleApp;

public class GavinGame extends SimpleApp
{  
	Ship[] S = new Ship[4];
	Building[] B= new Building[2];
	
	private Ship s;
	private Building b;
	
	public static void main(String[] args) {
		launch();
	}
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		s.draw(gc);
		b.draw(gc);
		
	}
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;


public class JasonGame extends SimpleApp {
	
	//If there is only one Cannon, don't use an array for it
	Cannon[] cc = new Cannon[1];
	
	Building[] bb = new Building[6];
	Ship[] ss = new Ship[8];
	private Cannon c ;
	
	//What are these for? You only need the arrays for buildings and ships.
	private Building b;
	private Ship s;
	
	//score
	//angle
	//
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//You deleted the "arg0" variable. Put something back in there. For example, gc
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
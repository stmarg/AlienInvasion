import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;


public class JasonGame extends SimpleApp {
	Cannon[] cc = new Cannon[1];
	Building[] bb = new Building[6];
	Ship[] ss = new Ship[8];
	private Cannon c ;
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
	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
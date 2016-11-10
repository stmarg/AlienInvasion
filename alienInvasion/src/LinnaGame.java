import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
<<<<<<< HEAD
import javafx.scene.paint.Color;
=======
>>>>>>> branch 'HEAD' of https://github.com/stmarg/alienInvasion.git
import tsinn.ui.SimpleApp;

//I'm so pleased that my commits actually seem to be working now!!!

public class LinnaGame extends SimpleApp
{
	Building[] buildings = new Building [3];
	//Ship[] ships = new Ship [a number]
	//private Cannon c
	
	@Override
	public void updateAnimation(long arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void draw(GraphicsContext gc)
	{
		// TODO Auto-generated method stub	
		
		for (Building b : buildings)
		{
			
			b.draw(gc);
		}
	}
	@Override
	public void setupApp(GraphicsContext arg0)
	{
		// TODO Auto-generated method stub	
		for (int i = 0; i < buildings.length; i++)
		{
			buildings[i] = new Building((getWidth() / 4 + i * 420) - 110, getHeight() - 40, 60, Color.CYAN,
					Color.ROYALBLUE);
			//At first I thought it wasn't drawing.. then I realized the colors were just too light XD
			//halp me I thought it 
		}
		
	}
	
	
	public static void main (String[] args)
	{
		launch();
	}
<<<<<<< HEAD
}

=======

	@Override
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
>>>>>>> branch 'HEAD' of https://github.com/stmarg/alienInvasion.git

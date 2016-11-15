import java.awt.Font;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class madigame extends SimpleApp {
	
	int score = 100;
	
	Ship[] ships = new Ship [10];
	Building[] buildings = new Building[6];
	
	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		for (int i=0; i< ships.length; i++)
		{
			ships[i] = new Ship((int)(Math.random()*getWidth()), (int) (Math.random()* -(getHeight()*2)), 100, 100, 1);
			ships[i].setSpeed(0, (int)(Math.random()*5+1));
			
		}
		
		for (int i = 0; i < buildings.length; i++) 
		{
			int x = (int) (getWidth() * (.15 * (i + 1)));
			int y = getHeight() - 25;

			buildings[i] = new Building(x, y, 50, Color.RED, Color.BLACK);
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (score >= 0)
		{
			for (int i = 0; i<ships.length; i++)
			{
				ships[i].draw(gc);
				ships[i].move();
				if (ships[i].getY() > getHeight()) 
				{
					ships[i].setY(-100);
					score -= 5;
				}
			}
			
			for (Building b : buildings) 
			{
				b.draw(gc);
			}
			gc.setFill(Color.GREEN);
			gc.setFont(javafx.scene.text.Font.font(50));
			String scoreL = "" + score;
			gc.fillText(scoreL, getWidth()/15, getHeight()/8);
		}
		else
		{
			gc.setFont(javafx.scene.text.Font.font(100));
			gc.setFill(Color.FIREBRICK);
			gc.fillText("You LOSE!", (getWidth()/2),getHeight()/2);
		}
	}
	public static void main (String[] args)
	{
		launch();
	}
	
}
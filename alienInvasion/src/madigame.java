import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class madigame extends SimpleApp {
	// Variables
	private int score = 100;
	int angle = 0;
	// Classes
	private Ship[] ships = new Ship[10];
	private Building[] buildings = new Building[6];
	private  Cannon c;
	private Missile m;
		

	// Angle
	public void onMouseMove(MouseEvent me) //{
	//public void onMousePressed(MouseEvent me)
	{
		
		 double radians =  Math.atan2(c.getY()-me.getY(), c.getX()-me.getX());
		 double angle = Math.toDegrees(radians);
		 c.setAngle(angle); 
		angle = 180 - angle;
		 
		 System.out.println(angle);
	}
	public void onMousePressed (MouseEvent me) 
	{
		c.shoot();
	}

	

	public void updateAnimation(long arg0) {
		// TODO Auto-generated method stub
	}

	// This function sets up the arrays
	public void setupApp(GraphicsContext arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship((int) (Math.random() * getWidth()), (int) (Math.random() * -(getHeight() * 2)), 100,
					100, 1);
			ships[i].setSpeed(0, (int) (Math.random() * 5 + 1));

		}

		for (int i = 0; i < buildings.length; i++) {
			int x = (int) (getWidth() * (.15 * (i + 1)));
			int y = getHeight() - 25;

			buildings[i] = new Building(x, y, 50, Color.RED, Color.BLACK);
		}
		
		
		c = new Cannon(getWidth()/2, getHeight()/2, 100, 150, angle);
		m = new Missile(angle);
	}

	// This function draws the game provided that you are alive
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (score >= 0) {
			c.draw(gc);
			for (int i = 0; i < ships.length; i++) {
				ships[i].draw(gc);
				ships[i].move();
				if (ships[i].getY() > getHeight()) {
					ships[i].setY(-100);
					score -= 5;
				}
			}

			for (Building b : buildings) {
				b.draw(gc);
			}
			gc.setFill(Color.GREEN);
			gc.setFont(javafx.scene.text.Font.font(50));
			String scoreL = "" + score;
			gc.fillText(scoreL, getWidth() / 15, getHeight() / 8);
		} else {
			gc.setFont(javafx.scene.text.Font.font(100));
			gc.setFill(Color.FIREBRICK);
			gc.fillText("You LOSE!", (getWidth() / 2), getHeight() / 2);

		}
		
		gc.setFill(Color.BLUE);
		gc.fillOval(c.getX()-5, c.getY()-5, 10, 10);
		
	}


	public static void main(String[] args) {
		launch();
	}

}
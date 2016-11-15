import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class KevinGame extends SimpleApp {
	private Cannon c;
	//private Building b1;
	//private Building b2;
	private Ship s1;

	private int score = 0;
	private int time = 0;
	private int ammo = 100;
	private double angle;
	boolean test = false;

	Ship[] ships = new Ship[3];
	Building[] buildings = new Building[4];
	Missile[] bullets = new Missile[ammo];

	public static void main(String[] args) {
		launch();
	}

	public void updateAnimation(long arg0) {
		
	}

	public void draw(GraphicsContext gc) {
		// c.draw(gc);
		time++;

		for (Ship s : ships) {
			s.draw(gc);
			s.move();
		}
		
		if (time > 500) {
			s1.draw(gc);
			s1.move();
			s1.sChange();
		}
		
		gc.fillText("Score: " + score + time, getWidth() - getWidth()/8, getHeight()/8);
		
		for (int i = 0; i < ships.length; i++) {
			if (ships[i].getY() > getHeight()) {
				ships[i].setY(-50);
				ships[i].setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				ships[i].setOriginalx(ships[i].getX());
				ships[i].setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
				//score++;
			}
			//ships[i].remove();
		}
		
		if (s1.getY() > getHeight()) {
			s1.setY(-50);
			s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
			s1.setOriginalx(s1.getX());
			s1.setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
			//score++;
		}

		for (Building b : buildings) {
			b.draw(gc);
		}
		
		c.draw(gc);

		if (test == true) {
			gc.fillText("100", 100, 100);;
			test = false;
		}
	}

	public void setupApp(GraphicsContext gc) {
		c = new Cannon(getWidth() / 2 - 20, getHeight() - 50, 40, 40, 100);

		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship(50 + i * 150, 50, 100, (int) (100/1.5));
		}
		
		s1 = new Ship(getWidth()/2, -50, 100, (int) (100/1.5), 2);

		for (int i = 0; i < buildings.length; i++) {
			buildings[i] = new Building((getWidth() / 4 + i * 300) - 110, getHeight() - 40, 40, Color.CORNFLOWERBLUE,
					Color.DARKBLUE);
		}
	}
  
	public void onKeyPressed(KeyEvent k) {
		if (k.equals("k") == true) {
			Missile M = new Missile(angle); 
			 
			test = true;
			//score = score + 1;
		}
	}
}
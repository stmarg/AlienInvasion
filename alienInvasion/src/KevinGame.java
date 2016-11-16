import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tsinn.ui.SimpleApp;

public class KevinGame extends SimpleApp {
	private Cannon c;
	private Ship s1;

	private int score = 0;
	private int time = 0;
	private int ammo = 0;
	boolean test = false;

	Ship[] ships = new Ship[3];
	Building[] buildings = new Building[4];
	//Missile[] bullets = new Missile[ammo];
	ArrayList <Missile> bullets = new ArrayList<> ();
	

	public static void main(String[] args) {
		launch();
	}

	public void updateAnimation(long arg0) {

	}

	public void draw(GraphicsContext gc) {
		// c.draw(gc);
		
		//Use the updateAnimation method for this. note that the parameter it takes is the time since it was last called.
		//It's like the DeltaTime variable in Codea. SImply add it to your variable.
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

		gc.fillText("Score: " + score + time, getWidth() - getWidth() / 8, getHeight() / 8);

		for (int i = 0; i < ships.length; i++) {
			if (ships[i].getY() > getHeight()) {
				ships[i].setY(-50);
				ships[i].setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				ships[i].setOriginalx(ships[i].getX());
				ships[i].setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
				// score++;
			}
			// ships[i].remove();
		}

		if (s1.getY() > getHeight()) {
			s1.setY(-50);
			s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
			s1.setOriginalx(s1.getX());
			//You are casting 1.5 to 1...why? Just pass in 1 or make setSpeed take a double
			s1.setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
			// score++;
		}

		for (Building b : buildings) {
			b.draw(gc);
		}

		c.draw(gc);

		if (test == true) {
			gc.fillText("100", 100, 100);
			bullets.add(new Missile(c.getX(), c.getY(), 10, c.getAngle(), 4));
			test = false;
		}
		
		for (Missile m : bullets) {
			if (ammo != 0) {
				m.draw(gc);
			}
			
			if (m.getxPos() > getWidth() && m.getxPos() < 0 && m.getyPos() > getHeight() && m.getyPos() < 0) {
				bullets.remove(m);
			}
		}
	}

	public void setupApp(GraphicsContext gc) {
		c = new Cannon(getWidth() / 2 - 20, getHeight() - 50, 40, 40, -90);

		for (int i = 0; i < ships.length; i++) {
			ships[i] = new Ship(50 + i * 150, 50, 100, (int) (100 / 1.5));
		}

		s1 = new Ship(getWidth() / 2, -50, 100, (int) (100 / 1.5), 2);

		for (int i = 0; i < buildings.length; i++) {
			buildings[i] = new Building((getWidth() / 4 + i * 300) - 110, getHeight() - 40, 40, Color.CORNFLOWERBLUE,
					Color.DARKBLUE);
		}
	}
	
	public void onKeyPressed(KeyEvent k) {
		if (k.getCode() == KeyCode.A) {
			c.setAngle(c.getAngle() - 10);
			score = score + 1;
		}
		
		if (k.getCode() == KeyCode.D) {
			c.setAngle(c.getAngle() + 10);
			score = score + 1;
		}
	}

	public void onMousePressed(MouseEvent m) {
		ammo++;
		test = true;
	}
}
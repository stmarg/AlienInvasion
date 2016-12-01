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
	private int level = 1;
	private int ammo = 100;
	private boolean refillAmmo = false;

	private int health = 500;
	private int maxHealth = 500;

	private boolean fire = false;
	private boolean addShip = false;

	private double lineX = 0;
	private double lineY = 0;
	private boolean drawLine = false;

	// Ship[] ships = new Ship[3];
	Building[] buildings = new Building[4];
	//ArrayList<Building> buildings = new ArrayList<>();
	ArrayList<Missile> bullets = new ArrayList<>();
	ArrayList<Ship> ships = new ArrayList<>();

	public static void main(String[] args) {
		launch();
	}

	public void updateAnimation(long arg0) {
		if (refillAmmo == true) {
			if (ammo < 100) {
				ammo++;
			} else {
				refillAmmo = false;
			}
		}
	}

	public void draw(GraphicsContext gc) {
		for (int i = 0; i < ships.size(); i++) {
			// Basic ship draw/move
			ships.get(i).draw(gc);
			ships.get(i).move();

			// If ship goes below screen
			if (ships.get(i).getY() > getHeight()) {
				ships.get(i).setY(-50);
				ships.get(i).setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				ships.get(i).setOriginalx(ships.get(i).getX());
				ships.get(i).setSpeed((int) 1.5, ((int) (Math.random() * 4) + 3));
			}

			for (int j = 0; j < buildings.length; j++) {

				buildings[j].draw(gc);

				// Check if ship1 hit building
				if (ships.get(i).didHit(buildings[j]) == true) {
					score = score + 100;
					gc.fillText("OUCH", getWidth() / 2, getHeight() / 2);
					ships.remove(i);
					buildings[j].explode(gc);
					buildings[j].setAlive(false);
				}

				if (s1.didHit(buildings[j]) == true) {
					score = score + 300;
					gc.fillText("OUCH", getWidth() / 2, getHeight() / 2);
					s1.setY(-100);
				}
			}
		}

		// Level 2 and beyond
		if (level >= 2) {
			s1.draw(gc);
			s1.move();
			s1.sChange();

			if (s1.getY() > getHeight()) {
				s1.setY(-50);
				s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				s1.setOriginalx(s1.getX());
				s1.setSpeed(1, ((int) (Math.random() * 4) + 3));
			}
		}

		// Cannon
		c.draw(gc);
		// c.rotate(gc);

		// Score
		gc.setFill(Color.DARKSLATEBLUE);
		gc.fillText("Score: " + score + "  " + ammo, getWidth() - getWidth() / 8, getHeight() / 8);
		gc.fillText("" + level, getWidth() / 2, getHeight() / 4);
		gc.fillText("" + ammo, c.getX() + c.getLength() / 2 - 10, c.getY() + c.getWidth() / 2 + 5);

		// Drawing missile
		for (Missile m : bullets) {
			if (ammo != 0) {
				m.draw(gc);
			}

			// Remove missile if off screen
			if (m.getxPos() > getWidth() && m.getxPos() < 0 && m.getyPos() > getHeight() && m.getyPos() < 10) {
				bullets.remove(m);
			}
		}

		if (ammo == 0) {
			refillAmmo = true;
		}

		// Firing missiles
		if (fire == true) {
			gc.fillText("" + Math.floor(c.getAngle()), 100, 100);
			bullets.add(new Missile(c.getX() + c.getLength() / 2, c.getY(), 10, c.getAngle(), 6));
			fire = false;
		}

		// Draw Lines
		if (drawLine == true && refillAmmo == false) {
			gc.strokeLine(c.getX() + c.getLength() / 2, c.getY(), lineX, lineY);
		}
		
		gc.strokeLine(0, getHeight()-health, getWidth(), getHeight()-health);

		refillShip();
	}

	public void refillShip() {
		if (ships.size() == 0) {
			level = level + 1;
			addShip = true;
		}

		if (addShip == true) {
			for (int i = 0; i < level + 2; i++) {
				ships.add(new Ship((int) (Math.random() * (getWidth() - 100)) + 100, 50, 100, (int) (100 / 1.5)));
			}

			addShip = false;
		}
	}

	public void setupApp(GraphicsContext gc) {
		c = new Cannon(getWidth() / 2 - 20, getHeight() - 70, 40, 40, 90);

		ships.add(new Ship((int) (Math.random() * (getWidth() - 100)) + 100, 50, 100, (int) (100 / 1.5), 1));
		ships.add(new Ship((int) (Math.random() * (getWidth() - 100)) + 100, 50, 100, (int) (100 / 1.5), 1));
		ships.add(new Ship((int) (Math.random() * (getWidth() - 100)) + 100, 50, 100, (int) (100 / 1.5), 1));

		s1 = new Ship(getWidth() / 2, -50, 100, (int) (100 / 1.5), 2);

		for (int i = 0; i < buildings.length; i++) {
			buildings[i] = new Building((getWidth() / 4 + i * 300) - 110, getHeight() - 40, 40, Color.CORNFLOWERBLUE,
					Color.DARKBLUE);
		}
	}

	public void onKeyPressed(KeyEvent k) {
		/*
		 * if (k.getCode() == KeyCode.A && c.getAngle() < 180) {
		 * c.setAngle(c.getAngle() + 10); }
		 * 
		 * if (k.getCode() == KeyCode.D && c.getAngle() > 0) {
		 * c.setAngle(c.getAngle() - 10); }
		 */
	}

	public void onMousePressed(MouseEvent m) {
		lineX = m.getX();
		lineY = m.getY();

		drawLine = true;
	}

	public void onMouseDragged(MouseEvent m) {
		lineX = m.getX();
		lineY = m.getY();
	}

	public void onMouseReleased(MouseEvent m) {
		double radians = Math.atan2(c.getY() - m.getY(), -c.getX() + m.getX());
		c.setAngle(Math.toDegrees(radians));

		if (ammo > 0 && refillAmmo == false) {
			ammo--;
			fire = true;
		}

		drawLine = false;
	}
}
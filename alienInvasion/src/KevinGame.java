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

	private boolean game = true;
	private int hit = 4;

	private int score = 0;
	private int level = 1;
	private int ammo = 100;
	private boolean refillAmmo = false;

	private double pcount = 0;
	private double pcountneed = 150;

	// private int health = 300;
	private int health = 10;

	private boolean fire = false;
	private boolean addShip = false;

	private double lineX;
	private double lineY;
	private boolean drawLine = false;

	Building[] buildings = new Building[4];
	// ArrayList<Building> buildings = new ArrayList<>();
	ArrayList<Missile> bullets = new ArrayList<>();
	ArrayList<Ship> ships = new ArrayList<>();
	ArrayList<Powerup> powerups = new ArrayList<>();

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

		pcount = pcount + (int) (2 * Math.random());
	}

	public void draw(GraphicsContext gc) {
		if (game == true) {
			for (int i = 0; i < ships.size(); i++) {
				// Basic ship draw/move
				ships.get(i).draw(gc);
				ships.get(i).move();

				// If ship goes below screen
				if (ships.get(i).getY() > getHeight()) {
					ships.get(i).setY(-50);
					ships.get(i).setX((int) (Math.random() * (getWidth() - getWidth() / 10)));
					ships.get(i).setOriginalx(ships.get(i).getX());
				}
			}

			// Draw buildings
			for (Building b : buildings) {
				b.draw(gc);
			}

			// Ship 2
			if (level >= 2) {
				s1.draw(gc);
				s1.move();
				s1.sChange();

				if (s1.getY() > getHeight()) {
					s1.setY(-50);
					s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
					s1.setOriginalx(s1.getX());
				}
			}

			// Cannon
			c.draw(gc);
			// c.rotate(gc);

			// Text displaying
			gc.setFill(Color.DARKSLATEBLUE);
			gc.fillText("Score: " + score + "  " + pcount, getWidth() - getWidth() / 8, getHeight() / 8);
			gc.fillText("" + level + " " + pcountneed, getWidth() / 2, getHeight() / 4);
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

			// Refill ammo when depleted
			if (ammo == 0) {
				refillAmmo = true;
			}

			// Draw Powerups
			for (Powerup p : powerups) {
				p.draw(gc);
			}

			// Ammo appear
			if (pcount >= pcountneed) {
				powerups.add(new Powerup((int) (Math.random() * (getWidth() - 100)) + 100, getHeight() / 2, 80, 50, 1));
				pcount = 0;
				pcountneed = pcountneed * 1.1;
			}

			// Firing missiles
			if (fire == true) {
				gc.fillText("" + Math.floor(c.getAngle()), 100, 100);
				bullets.add(new Missile(c.getX() + c.getLength() / 2, c.getY(), 10, c.getAngle(), 12));
				fire = false;
			}

			// Draw Lines
			if (drawLine == true && refillAmmo == false) {
				gc.strokeLine(c.getX() + c.getLength() / 2, c.getY(), lineX, lineY);
			}

			gc.strokeLine(0, getHeight() - health, getWidth(), getHeight() - health);

			// Game over
			if (hit == 0) {
				game = false;
			}

			// Call functions
			refillShip();
			collision();
		}
	}

	public void refillShip() {
		if (ships.size() == 0) {
			level = level + 1;
			//addShip = true;
			//game = false;
		}

		if (addShip == true) {
			for (int i = 0; i < level + 2; i++) {
				//ships.add(new Ship((Math.random() * (getWidth() - 100)) + 100, ((Math.random() * 30) - 800), 100,
				//		(int) (100 / 1.5)));
				//ships.add(new Ship((Math.random() * (getWidth() - 100)) + 100, -100, 100,
				//		(int) (100 / 1.5)));
			}

			addShip = false;
		}
	}

	public void collision() {
		// Ship hitting safety bar
		for (int i = 0; i < ships.size(); i++) {
			if (ships.get(i).getY() + ships.get(i).getHeight() > getHeight() - health) {
				ships.remove(i);
				health = health - 20;
			}
		}

		if (s1.getY() + s1.getHeight() > getHeight() - health) {
			health = health - 20;
			s1.setY(-100);
			s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10)));
		}

		// Ship hit buildings
		for (int j = 0; j < buildings.length; j++) {
			for (int i = 0; i < ships.size(); i++) {
				if (ships.get(i).didHit(buildings[j]) == true && buildings[j].isAlive() == true) {
					ships.remove(i);
					buildings[j].setAlive(false);
					hit--;
				}
			}

			if (s1.didHit(buildings[j]) == true && buildings[j].isAlive() == true) {
				s1.setY(-100);
				s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10)));
				buildings[j].setAlive(false);
				hit--;
			}
		}

		// Bullet hit powerups
		for (int i = 0; i < powerups.size(); i++) {
			for (int j = 0; j < bullets.size(); j++) {
				if (powerups.get(i).didHit(bullets.get(j)) == true) {
					ammo = ammo + 10;
					powerups.remove(i);
					bullets.remove(j);

					break;
				}
			}
		}

		// Bullet hit ships
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < ships.size(); j++) {
				// if (bullets.get(i).didHit(ships.get(j)) == true) {
				if (ships.get(j).didHit(bullets.get(i)) == true) {
					score = score + 1;
					ships.remove(j);
				}
			}
		}

		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).didHit(s1) == true) {
				score = score + 5;
				s1.setY(-50);
				s1.setX((int) (Math.random() * (getWidth() - getWidth() / 10) + getWidth() / 14));
				s1.setOriginalx(s1.getX());
			}
		}
	}

	public void setupApp(GraphicsContext gc) {
		c = new Cannon(getWidth() / 2 - 20, getHeight() - 60, 40, 40, 90);

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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Building class represents the idea of a building in the Alien Invasion game
 * @author Julia
 * @author Madison
 *
 */
public class Building 
{
	private int x;
	private int y;
	private int size;
	private Color bcolor;
	private Color tcolor;
	private boolean alive = true;

	public Building(int x, int y, int size, Color bcolor, Color tcolor) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.bcolor = bcolor;
		this.tcolor = tcolor;
	}

	public void draw(GraphicsContext gc) 
	{
		gc.setFill(tcolor);
		gc.fillRect(x, y, size, size);
		gc.fillRect(x + size / 6, y - size / 3, size / 1.8, size / 3);
		gc.fillRect(x + size / 4.2, y - size / 3 - size / 5, size / 4, size / 5);
		gc.setFill(bcolor);
		gc.fillRect(x + size / 3, y + size / 4, size / 3, size - size / 4);
	}

	//This doesn't work. Please check to ensure that it is working. 
	public boolean checkHit(Ship s) 
	{
		int buildingLeft = this.x; 
		int buildingRight = this.x + this.size; 

		double shipLeft = s.getX(); 
		double shipRight = s.getX() + s.getWidth(); 

		int buildingTop = this.y - this.size; 
		int buildingBottom = this.y; 

		double shipTop = s.getY(); 
		double shipBottom = s.getY() - s.getHeight(); 
		
		if ( shipBottom < buildingTop || 
				shipLeft > buildingRight ||
				shipTop > buildingBottom ||
				shipRight < buildingLeft) 
		{
			return false; 
		}
				
		if ( shipBottom > buildingTop || 
				shipLeft < buildingRight ||
				shipTop < buildingBottom ||
				shipRight > buildingLeft)
		{
			return true; 
		} 
		
		return false; 
	} 


		/*if ((buildingLeft < shipLeft && buildingLeft > shipRight) ||  
			(buildingLeft > shipLeft && buildingRight < shipRight)) 
		{ 
			if ((shipBottom < buildingTop && shipBottom > buildingBottom) || 
				(shipTop < buildingTop && shipTop > buildingBottom))
			{ 
				return true; 
			} 
		} 	

		return false; 

	} */

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getS() {
		return size;
	}

	public void setS(int size) {
		this.size = size;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

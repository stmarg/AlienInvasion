import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class JuliaBuilding 
{
	private int x; 
	private int y; 
	private int size; 
	private Color color; 
	private boolean alive; 
	
	
	
	public JuliaBuilding(int x, int y, int size, Color color)
	{
		this.x = x; 
		this.y = y; 
		this.size = size; 
		this.color = color; 
		
	}
	
	public void draw(GraphicsContext gc)
	{ 
		
			drawBuildings(gc, this.color, this.color); 
 
	}
	
	private void drawBuildings(GraphicsContext gc, Color bottomColor, Color topColor) 
    {
        gc.setFill(bottomColor);
        gc.fillRect(x-size/2, y-size/2, size, size); 
        gc.setFill(topColor); 
        gc.fillRect(x-size/4+4, y-size/1+0.5, size/3.03, size/2.03); 
    } 
  
	
	public boolean checkHit(Ship s)
	{ 
		
		
		System.out.println("Building.checkHit not implemented. Returning false"); 
		return false; 
	}
	
	
	public int getX()
	{ 
		return x;
	}
	
	public int getY()
	{ 
		return y; 
	}
	
	public int getSize()
	{ 
		return size; 
	}
	

	
}

import java.awt.Color;
import java.awt.Graphics;

public class Particle {

	private int yPos;
	private boolean up;
	private Color color;
	
	public Particle(int y, boolean u, Color c){
		yPos = y;
		up = u;
		color = c;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(324, yPos, 8, 8);
	}
	
	public void move(){
		if(up){
			yPos--;
		}else{
			yPos++;
		}
	}
	
	public boolean inBounds(){
		if(up){
			return yPos > 350;
		}else{
			return yPos < 350;
		}
	}
	
	public int getY(){
		return yPos;
	}
	
}

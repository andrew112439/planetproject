import java.awt.Color;
import java.awt.Graphics;

public class Particle {

	//THE PARTICLE LAUNCHED BY AN INVADER
	
	private int yPos;
	private boolean up;
	private Color color;
	
	private Invader invader;
	
	public Particle(int y, boolean u, Color c){ //A PARTICLE IS INITIALIZED WITH THE TRAITS OF ITS INVADER
		yPos = y;
		up = u; //UP MEANS THE INVADER IS BELOW AND IT MUST TRAVEL UP TOWARDS THE PLANET
		color = c;
	}
	
	//PAINTS THE PARTICLE AT THE CORRECT POSITION
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(324, yPos, 8, 8);
	}
	
	public void move(){
		if(up){ //MOVES THE PARTICLE UP TOWARDS THE PLANET 
			yPos--;
		}else{ //MOVES THE PARTICLE DOWN TOWARDS THE PLANET
			yPos++;
		}
	}
	
	//DETERMINES IF THE PARTICLE SHOULD STILL BE PAINTED
	public boolean inBounds(){
		if(up){
			return yPos > 350;
		}else{
			return yPos < 350;
		}
	}
	
	//RETURNS Y POSITION OF PARTICLE
	public int getY(){
		return yPos;
	}
	
	//USED FOR OBTAINING THE TRAITS OF THE INVADER FROM WHICH THIS PARTICLE IS SHOT
	public void setInvader(Invader i){
		invader = i;
	}
	
	public Invader getInvader(){
		return invader;
	}
	
}

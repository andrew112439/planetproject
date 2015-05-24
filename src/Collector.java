import java.awt.Color;
import java.awt.Graphics;

public class Collector extends TransportModule{
	
	protected boolean comingBack;
	
	public Collector() {
		super();
		comingBack = false;
	}
	
	//MOVES THE COLLECTOR AROUND THE SCREEN
	public void move(){
		if(!isInBounds()){
			//DETERMINES IF THE COLLECTOR SHOULD TURN AROUND
			left = !left;
			comingBack = !comingBack;
			out = !out;
		}
		if(left){
			initX--;
		}else{
			initX++;
		}
	}
	
	public boolean isInBounds(){
		if(out){
			if(left){
				return initX > 0;
			}else{
				return initX < 700;
			}
		}else{
			if(initX == 350){
				if(comingBack){
					Run.addEnergy(10);
				}
				return false;
			}else{
				return true;
			}
		}
	}
	
	//PAINTS THE COLLECTOR
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(Color.yellow);
			g.fillRect(initX, initY, 8, 16);
		}else{
			//PAINTS THE COLLECTOR WITH A LOAD IF IT IS RETURNING TO THE PLANET
			g.setColor(Color.yellow);
			g.fillRect(initX, initY, 8, 16);
			g.setColor(new Color(0x00FFFF));
			g.fillRect(initX, initY-8, 8, 8);
		}
	}

}

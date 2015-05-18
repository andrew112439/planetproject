import java.awt.Color;
import java.awt.Graphics;

public class Ambulance extends Collector{

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
					Run.addSick(-10);
				}
				return false;
			}else{
				return true;
			}
		}
	}
	
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(Color.red);
			g.fillRect(initX, initY, 8, 8);
			g.setColor(Color.white);
			g.fillRect(initX, initY-8, 8, 8);
		}else{
			g.setColor(Color.red);
			g.fillRect(initX, initY, 8, 8);
		}
	}
	
}

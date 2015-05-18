import java.awt.Color;
import java.awt.Graphics;

public class Collector extends TransportModule{
	
	protected boolean comingBack;
	
	public Collector() {
		super();
		comingBack = false;
	}
	
	public void move(){
		if(!isInBounds()){
			System.out.println(Run.getMain().getEnergy());
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
	
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(Color.yellow);
			g.fillRect(initX, initY, 8, 16);
		}else{
			g.setColor(Color.yellow);
			g.fillRect(initX, initY, 8, 16);
			g.setColor(new Color(0x00FFFF));
			g.fillRect(initX, initY-8, 8, 8);
		}
	}

}

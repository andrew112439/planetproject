import java.awt.Color;
import java.awt.Graphics;

public class Miner extends Collector{

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
					Run.addMaterials(10);
				}
				return false;
			}else{
				return true;
			}
		}
	}
	
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(new Color(0x00CCCC));
			g.fillRect(initX, initY, 16, 8);
		}else{
			g.setColor(new Color(0x00CCCC));
			g.fillRect(initX, initY, 16, 8);
			g.setColor(Color.gray);
			g.fillRect(initX, initY-8, 16, 8);
		}
	}
	
}

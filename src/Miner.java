import java.awt.Color;
import java.awt.Graphics;

public class Miner extends Collector{

	//DETERMINES IF THE MINER SHOULD TURN AROUND
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
					//ADDS MATERIALS IF THE MINER HAS JUST RETURNED WITH A LOAD
					Run.addMaterials(10);
				}
				return false;
			}else{
				return true;
			}
		}
	}
	
	//PAINTS MINER AT PROPER POSITION
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(new Color(0x00CCCC));
			g.fillRect(initX, initY, 16, 8);
		}else{
			//THE MINER MUST CARRY A LOAD BACK IF IT IS RETURNING FROM A RUN
			g.setColor(new Color(0x00CCCC));
			g.fillRect(initX, initY, 16, 8);
			g.setColor(Color.gray);
			g.fillRect(initX, initY-8, 16, 8);
		}
	}
	
}

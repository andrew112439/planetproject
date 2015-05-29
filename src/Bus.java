import java.awt.Color;
import java.awt.Graphics;

public class Bus extends Collector{

	//DETERMINES IF THE BUS SHOULD TURN AROUND
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
					//ADDS TO POPULATION (IF THE BUS IS RETURNING WITH A 'LOAD' IT IS CARRYING PEOPLE)
					Run.addPopulation(15);
				}
				return false;
			}else{
				return true;
			}
		}
	}
	
	public void paint(Graphics g){
		if(!comingBack){
			g.setColor(new Color(0x66CCFF));
			g.fillRect(initX, initY, 16, 16);
		}else{
			//IF THE BUS IS COMING BACK IT IS CARRYING A LOAD OF PEOPLE TO BRING TO THE PLANET
			g.setColor(new Color(0x66CCFF));
			g.fillRect(initX, initY, 16, 16);
			g.setColor(Color.cyan);
			g.fillRect(initX, initY-8, 16, 8);
		}
	}
	
}

import java.awt.Color;
import java.awt.Graphics;

public class Ambulance extends Collector{

	private String type;
	
	public Ambulance(String t){
		type = t;
	}
	
	//DETERMINES WHETHER THE AMBULANCE SHOULD TURN AROUND
	public boolean isInBounds(){
		if(out){
			if(left){
				return initX > 0;
			}else{
				return initX < 700;
			}
		}else{
			if(initX == 350){
				//IF THE AMBULANCE RETURNS TO THE MIDDLE OF THE PLANET IT PERFORMS ITS FUNCTION
				if(comingBack){
					int level; //GET LEVEL OF THE AMBULANCE
					if(type.equals("mal") && Run.getMain().malExists()){
						level = Run.getMalLevel();
						Run.getMain().addMalaria(-(10+((level-1)*10)));
					}else if(type.equals("yel") && Run.getMain().yelExists()){
						level = Run.getYelLevel();
						Run.getMain().addFever(-(10+((level-1)*10)));
					}else if(type.equals("bub") && Run.getMain().bubExists()){
						level = Run.getBubLevel();
						Run.getMain().addBubonic(-(10+((level-1)*10)));
					}else{
						if(Run.getMain().poxExists()){
							level = Run.getPoxLevel();
							Run.getMain().addPox(-(10+((level-1)*10)));
						}
					}
				}
				return false;
			}else{
				return true;
			}
		}
	}

	//PAINTS THE AMBULANCE AT THE PROPER COORDINATE 
	public void paint(Graphics g){
		if(!comingBack){
			//THIS SHOWS A WHITE SQUARE BEING CARRIED BY THE AMBULANCE WHICH
			//	REPRESENTS PATIENTS BEING CARRIED AND CURED
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

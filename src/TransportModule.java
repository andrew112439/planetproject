import java.awt.Graphics;
import java.util.Random;

public abstract class TransportModule {

	//ADD BUSES THAT COME AND BRING POPULATION TO PLANET, BIGGER
	//TURN THIS CLASS INTO AN ABSTRACT AND HAVE THE AMBULANCE, TRANSPORT AND BUS EXTEND IT
	
	protected boolean left;
	protected Random r = new Random();
	protected int initX;
	protected int initY;
	protected boolean out;
	
	public TransportModule(){
		out = true;
		left = r.nextBoolean();
		initY = r.nextInt(200)+250;
		initX = 350;
	}
	
	public void move(){
		if(!isInBounds()){
			left = !left;
		}
		if(left){
			initX--;
		}else{
			initX++;
		}
	}
	
	public boolean isInBounds(){
		if(left){
			return initX > 0;
		}else{
			return initX < 700;
		}
	}
	
	public void paint(Graphics g){
		//OVERRIDE
	}
	
}

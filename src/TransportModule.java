import java.awt.Graphics;
import java.util.Random;

public abstract class TransportModule {

	//THIS CLASS IS THE SHELL USED FOR THE BUSES, MINERS, COLLECTORS AND HOSPITALS
	
	protected boolean left; //IF THE VEHICLE IS TRAVELING LEFT OR RIGHT
	protected Random r = new Random();
	protected int initX;
	protected int initY;
	protected boolean out; //IF THE VEHICLE IS CURRENTLY TRAVELING TOWARDS OR AWAY FROM THE PLANET
	
	public TransportModule(){
		out = true;
		left = r.nextBoolean();
		initY = r.nextInt(200)+250;
		initX = 350;
	}
	
	//MOVES THE VEHICLE AROUND DEPENDING ON WHETHER OR NOT IT IS GOING TOWARDS OR AWAY FROM THE PLANET
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
	
	//DETERMINES WHETHER OR NOT THE VEHICLE SHOULD TURN AROUND
	public boolean isInBounds(){
		if(left){
			return initX > 0;
		}else{
			return initX < 700;
		}
	}
	
	public void paint(Graphics g){
		//TO BE OVERRIDDEN IN SUBCLASSES (THIS IS REQUIRED FOR THE ARRAYLIST OF VEHICLES IN THE MAIN CLASS)
	}
	
}

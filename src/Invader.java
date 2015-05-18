import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Invader {

	private static int[][] arr;
	
	private static Random rand = new Random();
	
	private int offset;
	private int yOffset;
	
	private boolean left;
	
	private Color color;
	private Color particleColor;
	
	public Invader(){
		boolean top = rand.nextBoolean();
		if(top){
			yOffset = 50;
		}else{
			yOffset = 550;
		}
		left = rand.nextBoolean();
		if(left){
			offset = 700;
		}else{
			offset = -80;
		}
		genParticleColor();
		makeArr();
	}
	
	public void paint(Graphics g){
		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				if(arr[r][c] == 1){
					g.setColor(color);
				}else if(arr[r][c] == 2){
					g.setColor(particleColor);
				}
				if(arr[r][c] != 0){
					g.fillRect((r*8)+offset, (c*8)+yOffset, 8, 8);
				}
			}
		}
	}
	
	private void makeArr(){
		int[][] a = {
				{1,0,0,0,1},
				{0,1,1,1,0},
				{0,1,2,1,0},
				{0,1,1,1,0},
				{1,0,0,0,1}
		};
		arr = a;
	}
	
	private void genParticleColor(){
		Color[] colors = 
			{new Color(0xD4A017), new Color(0xEDDA74), new Color(0xF87A17), 
			new Color(0xCFECEC), new Color(0xF52887), new Color(0xFF00FF), 
			new Color(0xF63817), new Color(0x980517), new Color(0x9ACD32),
			new Color(0xC85A17), new Color(0xF76541), new Color(0xFEECCF), 
			new Color(0xFDE0BC), new Color(0xADA96E), new Color(0xFFF8C6), 
			new Color(0xE3E4FA), new Color(0xC57726), new Color(0x6F82BD)};
		
		color = colors[rand.nextInt(colors.length)];
		particleColor = colors[rand.nextInt(colors.length)];
	}
	
	public void move(Graphics g){
		if(offset == 324){
			//LAUNCH PARTICLE
			Run.getMain().particle();
			if(left){
				offset-=2;
			}else{
				offset+=2;
			}
		}else{
			if(left){
				offset-=2;
			}else{
				offset+=2;
			}
		}
	}
	
	public boolean isInBounds(){
		if(yOffset < 80 || yOffset > 505){
			if(left){
				return offset > -80;
			}else{
				return offset < 780;
			}
		}
		if(left){
			if(offset <= 350){
				Run.getMain().addSick(rand.nextInt(250));
			}
			return offset >= 350;
		}else{
			if(offset >= 350){
				Run.getMain().addSick(rand.nextInt(250));
			}
			return offset <= 350;
		}
	}
	
	//Particle temp = new Particle(yOffset, up, particleColor);
	public int getY(){
		return yOffset;
	}
	
	public boolean getUp(){
		if(yOffset == 50){
			return false;
		}else{
			return true;
		}
	}
	
	public Color getParticleColor(){
		return particleColor;
	}
}

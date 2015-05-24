import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Invader {

	private static int[][] arr;
	
	private static Random rand = new Random();
	
	private int offset;
	private int yOffset;
	
	private boolean left;
	
	private Color color;
	private Color particleColor;
	
	private String diseaseType;
	
	public Invader(){
		boolean top = rand.nextBoolean(); //DETERMINES IF THE INVADER ATTACKS FROM ABOVE OR BELOW
		if(top){ //PLACES THE INVADER AT THE CORRECT POSITION
			yOffset = 50;
		}else{
			yOffset = 550;
		}
		left = rand.nextBoolean(); //DETERMINES IF THE INVADER IS COMING FROM THE LEFT OR THE RIGHT
		if(left){ //PLACES THE INVADER AT THE CORRECT POSITION
			offset = 700;
		}else{
			offset = -80;
		}
		genParticleColor();
		makeArr();
		genDiseaseType();
	}
	
	//PAINTS THE INVADER AT THE CORRECT POSITION
	public void paint(Graphics g){
		//TRAVERSES THROUGH THE ARRAY BY WHICH THE INVADER IS REPRESENTED 
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
	
	//INITIALIZES THE ARRAY BY WHICH THE INVADER IS REPRESENTED
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
	
	//DETERMINES THE COLOR OF THE INVADER AND THE PARTICLE THAT IT SHOOTS
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
			if(left){ //MOVE THE PARTICLE
				offset-=2;
			}else{
				offset+=2;
			}
		}else{
			if(left){ //MOVE THE PARTICLE
				offset-=2;
			}else{
				offset+=2;
			}
		}
	}
	
	//DETERMINES TO WHICH DISEASE THE INVADER WILL CONTRIBUTE TO
	public void genDiseaseType(){
		int t = rand.nextInt(5);
		System.out.println(t);
		if(t == 0){
			diseaseType = "bub";
		}else if(t == 1){
			diseaseType = "pox";
		}else if(t == 2){
			diseaseType = "yel";
		}else{
			diseaseType = "mal";
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
				//CONTRIBUTES TO THE DISEASE IT WAS ASSIGNED TO
				if(diseaseType.equals("bub")){
					System.out.println("bub+=");
					Run.getMain().addBubonic(rand.nextInt(250));
				}else if(diseaseType.equals("pox")){
					System.out.println("pox+=");
					Run.getMain().addPox(rand.nextInt(250));
				}else if(diseaseType.equals("yel")){
					System.out.println("yel+=");
					Run.getMain().addFever(rand.nextInt(250));
				}else{
					System.out.println("mal+=");
					Run.getMain().addMalaria(rand.nextInt(250));
				}	
			}
			return offset >= 350;
		}else{
			//CONTRIBUTES TO THE DISEASE IT WAS ASSIGNED TO
			if(diseaseType.equals("bub")){
				Run.getMain().addBubonic(rand.nextInt(250));
			}else if(diseaseType.equals("pox")){
				Run.getMain().addPox(rand.nextInt(250));
			}else if(diseaseType.equals("yel")){
				Run.getMain().addFever(rand.nextInt(250));
			}else{
				Run.getMain().addMalaria(rand.nextInt(250));
			}
			return offset <= 350;
		}
	}
	
	//RETURNS THE Y POSITION OF THE INVADER
	public int getY(){
		return yOffset;
	}
	
	//FOR THE PURPOSE OF THE MOVEMENT OF A PARTICLE: RETURNS IF THE INVADER IS ABOVE OR BELOW THE PLANET
	public boolean getUp(){
		if(yOffset == 50){
			return false;
		}else{
			return true;
		}
	}
	
	//FOR THE PURPOSE OF THE PARTICLE: RETURNS COLOR OF PARTICLE
	public Color getParticleColor(){
		return particleColor;
	}
	
	public String getDiseaseType(){
		return diseaseType;
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Asteroid {

	private static Color primary;
	private static Color secondary;

	private static int[][] arr;
	
	private static Random rand = new Random();
	
	private int offset;
	private boolean left;
	
	private int yOffset;
	private int yMove;
	private boolean up;
	
	public Asteroid(){
		up = rand.nextBoolean();
		yMove = rand.nextInt(3);
		yOffset = rand.nextInt(700);
		left = rand.nextBoolean();
		if(left){
			offset = 700;
		}else{
			offset = -80;
		}
		genArr();
		genColors();
	}
	
	public void paint(Graphics g){
		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				if(arr[r][c] != 0){
					if(arr[r][c] == 1){
						g.setColor(Color.black);
					}else if(arr[r][c] == 2){
						g.setColor(primary);
					}else{
						g.setColor(secondary);
					}
					g.fillRect((r * 16)+offset, (c * 16)+yOffset, 16, 16);
				}
			}
		}
	}
	public void move(){
		if(left){
			offset-=2;
			
		}else{
			offset+=2;
		}
		if(up){
			yOffset-=yMove;
		}else{
			yOffset+=yMove;
		}
	}
	
	public boolean inBounds(){
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
	
	private void genArr(){
		int[][] a = {
				{0, 0, 1, 1, 1, 0, 0},
				{0, 1, 2, 2, 2, 1, 0},
				{1, 2, 2, 2, 2, 2, 1},
				{1, 2, 2, 2, 2, 2, 1},
				{1, 2, 2, 2, 2, 2, 1},
				{0, 1, 2, 2, 2, 1, 0},
				{0, 0, 1, 1, 1, 0, 0},
		};
		for(int r = 0; r < a.length; r++){
			for(int c = 0; c < a[r].length; c++){
				if(a[r][c] == 2){
					boolean changeTo3 = rand.nextBoolean();
					int secondCheck = rand.nextInt(5); //TO MAKE THE PRIMARY MORE COMMON THAN THE SECONDARY
					if(changeTo3 && secondCheck <= 3){
						a[r][c] = 3; //FOR COLORING
					}
				}
			}
		}
		arr = a;
	}
	
	private void genColors(){
		Color[] colors = 
			{new Color(0xD4A017), new Color(0xEDDA74), new Color(0xF87A17), 
			new Color(0xCFECEC), new Color(0xF52887), new Color(0xFF00FF), 
			new Color(0xF63817), new Color(0x980517), new Color(0x9ACD32),
			new Color(0xC85A17), new Color(0xF76541), new Color(0xFEECCF), 
			new Color(0xFDE0BC), new Color(0xADA96E), new Color(0xFFF8C6), 
			new Color(0xE3E4FA), new Color(0xC57726), new Color(0x6F82BD)};

		
		int firstColor = rand.nextInt(colors.length);
		int secondColor = rand.nextInt(colors.length);
		while(secondColor == firstColor){
			secondColor = rand.nextInt(colors.length);
		}
		primary = colors[firstColor];
		secondary = colors[secondColor];
	}
	
}

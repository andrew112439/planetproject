import java.awt.Color;
import java.util.Random;

public class Planet {

	//PICKED FROM A SERIES OF COLORS, SAME COLOR CAN'T BE PICKED TWICE
	private static Color primary;
	private static Color secondary;

	private static int[][] planetArray;
	
	private static Random rand = new Random();
	
	public static void setup(){
		genArray();
		genColors();
	}

	private static void genArray(){
		int[][] p = {
				{0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
				{0,0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,1,0,0,0},
				{0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0,0},
				{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1}, //A 0 MEANS NO COLOR
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1}, //A 1 MEANS BLACK (OUTLINE)
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1}, //A 2 MEANS IT WILL BE COLORED LATER
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
				{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
				{0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0,0},
				{0,0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,1,0,0,0},
				{0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
		};
		for(int r = 0; r < p.length; r++){
			for(int c = 0; c < p[r].length; c++){
				if(p[r][c] == 2){
					boolean changeTo3 = rand.nextBoolean();
					int secondCheck = rand.nextInt(5); //TO MAKE THE PRIMARY MORE COMMON THAN THE SECONDARY
					if(changeTo3 && secondCheck <= 3){
						p[r][c] = 3; //FOR COLORING
					}
				}
			}
		}
		planetArray = p;
	}
	
	private static void genColors(){
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

	public static Color getPrimary(){
		return primary;
	}
	
	public static Color getSecondary(){
		return secondary;
	}

	public static int[][] getPlanetArray(){
		return planetArray;
	}
	
	//FOR THE PURPOSES OF LOADING FROM A SAVE FILE
	public static void setPrimary(Color c){
		primary = c;
	}
	
	public static void setSecondary(Color c){
		secondary = c;
	}

	public static void setPlanetArray(int[][] a){
		planetArray = a;
	}
}
